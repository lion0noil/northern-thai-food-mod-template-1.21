package net.lion.northernthaifoodmod.block.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.lion.northernthaifoodmod.block.ModBlocks;
import net.lion.northernthaifoodmod.block.entity.ImplementedInventory;
import net.lion.northernthaifoodmod.block.entity.ModBlockEntities;
import net.lion.northernthaifoodmod.item.ModItems;
import net.lion.northernthaifoodmod.screen.custom.PotScreenHandler;
import net.lion.northernthaifoodmod.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.Recipe;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PotBlockEntity extends BlockEntity implements ImplementedInventory, ExtendedScreenHandlerFactory<BlockPos> {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(10,ItemStack.EMPTY);
    //private static final int INPUT = 0;
    private static final int OUTPUT = 9;

    private int cookTime = 0;
    //private static final int COOK_TIME_TOTAL = 72; // Adjust cooking speed

    public PotBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.POT_BE, pos, state);
    }
    public static void tick(World world, BlockPos pos, BlockState state, PotBlockEntity entity) {
        if (!world.isClient) {
            if (entity.isOnStove(world, pos)) {
                Recipe currentRecipe = entity.getCurrentRecipe();
                if (currentRecipe != null) {
                    entity.cookTime++;
                    if (entity.cookTime >= currentRecipe.cookTime) { // Use recipe's cook time
                        entity.cookItems();
                        entity.cookTime = 0;
                    }
                }
            } else {
                entity.cookTime = 0; // Reset cook time if not on stove
            }
        }
    }

    private Recipe getCurrentRecipe() {
        for (Recipe recipe : RECIPES) {
            if (canCraft(recipe)) {
                return recipe;
            }
        }
        return null;
    }

    private boolean isOnStove(World world, BlockPos pos) {
        return world.getBlockState(pos.down()).getBlock() == ModBlocks.STOVE;
    }

    private static final List<Recipe> RECIPES = List.of(
            new Recipe(List.of(ModItems.GREEN_ONION, ModItems.RICE), new ItemStack(ModItems.FOOD1), 100),
            new Recipe(List.of(Items.BEEF), new ItemStack(Items.COOKED_BEEF), 50),
            new Recipe(List.of(Items.PORKCHOP), new ItemStack(Items.COOKED_PORKCHOP), 60),
            new Recipe(List.of(Items.CHICKEN), new ItemStack(Items.COOKED_CHICKEN), 40)
    );

    private static class Recipe {
        List<Item> inputs;
        ItemStack output;
        int cookTime; // New field for custom cook time

        Recipe(List<Item> inputs, ItemStack output, int cookTime) {
            this.inputs = inputs;
            this.output = output;
            this.cookTime = cookTime; // Store custom cook time
        }
    }

    private void cookItems() {
        for (Recipe recipe : RECIPES) {
            if (canCraft(recipe)) {
                craft(recipe);
                break; // Only craft one item per tick
            }
        }
    }

    private void craft(Recipe recipe) {
        List<Item> requiredItems = new ArrayList<>(recipe.inputs);

        // Remove ingredients from the input slots
        for (int i = 0; i < 9; i++) {
            ItemStack stack = this.inventory.get(i);
            if (requiredItems.remove(stack.getItem())) {
                stack.decrement(1);
            }
            if (requiredItems.isEmpty()) break;
        }

        // Handle output slot stacking
        ItemStack outputStack = this.inventory.get(OUTPUT);
        if (!outputStack.isEmpty() && outputStack.isOf(recipe.output.getItem())) {
            // If output is the same item, increase the stack size
            outputStack.increment(recipe.output.getCount());
        } else if (outputStack.isEmpty()) {
            // If output slot is empty, set the new item
            this.inventory.set(OUTPUT, recipe.output.copy());
        }

        markDirty();
    }

    private boolean canCraft(Recipe recipe) {
        List<Item> requiredItems = new ArrayList<>(recipe.inputs);
        for (int i = 0; i < 9; i++) {
            ItemStack stack = this.inventory.get(i);
            requiredItems.remove(stack.getItem());
            if (requiredItems.isEmpty()) return true;
        }
        return false;
    }

    /*private ItemStack getCookedResult(ItemStack input) {
        if (input.getItem() == Items.BEEF) {
            return new ItemStack(Items.COOKED_BEEF);
        } else if (input.getItem() == Items.PORKCHOP) {
            return new ItemStack(Items.COOKED_PORKCHOP);
        } else if (input.getItem() == Items.CHICKEN) {
            return new ItemStack(Items.COOKED_CHICKEN);
        } else if (input.getItem() == ModItems.GREEN_ONION) {
            return new ItemStack(ModItems.FOOD1);
        } else {
            return ItemStack.EMPTY;
        }
    }*/

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }


    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
    }

    @Override
    public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }


    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity player) {
        return this.pos;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Pot");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new PotScreenHandler(syncId,playerInventory,this.pos);
    }



}
