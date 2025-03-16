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
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.PropertyDelegate;
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

    private final PropertyDelegate propertyDelegate;
    private int cookTime = 0;
    private static final int COOK_TIME_TOTAL = 72; // Adjust cooking speed

    public PotBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.POT_BE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> cookTime;
                    case 1 -> getCurrentRecipeCookTime(); // Get different cook time for each recipe
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                if (index == 0) cookTime = value;
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    private int getCurrentRecipeCookTime() {
        Recipe currentRecipe = getCurrentRecipe();
        return currentRecipe != null ? currentRecipe.cookTime : COOK_TIME_TOTAL;
    }

    public PropertyDelegate getPropertyDelegate() {
        return propertyDelegate;
    }


    public static void tick(World world, BlockPos pos, BlockState state, PotBlockEntity entity) {
        if (!world.isClient) {
            if (entity.isOnStove(world, pos)) {
                Recipe currentRecipe = entity.getCurrentRecipe();
                if (currentRecipe != null) {
                    entity.cookTime++; // Increase cook time as long as we have a valid recipe
                    if (entity.cookTime >= currentRecipe.cookTime) {
                        entity.cookItems(); // Craft the item when cooking is done
                        entity.cookTime = 0; // Reset the cook time after crafting
                    }
                }
            } else {
                entity.cookTime = 0; // Reset the cook time if not on stove
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
            new Recipe(List.of(Items.EGG,Items.EGG, ModItems.GREEN_ONION,ModItems.CHILI,ModItems.SALT), new ItemStack(ModItems.FOOD1), 50,1),
            new Recipe(List.of(Items.PORKCHOP,Items.SUGAR, ModItems.TAMARIND_P,ModItems.GINGER,ModItems.GARLIC,ModItems.BEAN,ModItems.PINEAPPLE), new ItemStack(ModItems.FOOD2), 50,1),

            new Recipe(List.of(ModItems.GALANGAL,ModItems.GALANGAL,ModItems.CHILI,ModItems.CHILI,ModItems.GARLIC,ModItems.SALT,Items.BROWN_MUSHROOM), new ItemStack(ModItems.FOOD4), 50,1),
            new Recipe(List.of(ModItems.GALANGAL,ModItems.GALANGAL,ModItems.CHILI,ModItems.CHILI,ModItems.GARLIC,ModItems.SALT,Items.RED_MUSHROOM), new ItemStack(ModItems.FOOD4), 50,1),

            new Recipe(List.of(Items.BROWN_MUSHROOM,ModItems.TAMARIND,ModItems.GALANGAL,ModItems.CHILI,ModItems.CHILI,ModItems.LEMONGRASS,ModItems.GARLIC,ModItems.SHRIMP_P,ModItems.SALT), new ItemStack(ModItems.FOOD5), 50,1),
            new Recipe(List.of(Items.RED_MUSHROOM,ModItems.TAMARIND,ModItems.GALANGAL,ModItems.CHILI,ModItems.CHILI,ModItems.LEMONGRASS,ModItems.GARLIC,ModItems.SHRIMP_P,ModItems.SALT), new ItemStack(ModItems.FOOD5), 50,1),

            new Recipe(List.of(Items.PORKCHOP,ModItems.FISH_SAUCE,ModItems.FLOUR,ModItems.OIL), new ItemStack(ModItems.FOOD6), 50,1),
            new Recipe(List.of(Items.PORKCHOP,Items.EGG,Items.EGG,ModItems.CHILI,ModItems.GREEN_ONION,ModItems.CHILANTRO), new ItemStack(ModItems.FOOD7), 50,1),
            new Recipe(List.of(ModItems.NOODLE,ModItems.NOODLE,Items.PORKCHOP,ModItems.TOMATO,ModItems.FISH_SAUCE,ModItems.GARLIC,ModItems.SHALLOT,ModItems.SHRIMP_P,ModItems.CHILI), new ItemStack(ModItems.FOOD8), 50,1),
            new Recipe(List.of(Items.CHICKEN,ModItems.NOODLE,ModItems.OIL,ModItems.CURRY_POWDER), new ItemStack(ModItems.FOOD9), 50,1),
            new Recipe(List.of(ModItems.CHILI,ModItems.SHALLOT,ModItems.GARLIC,ModItems.CHILANTRO,ModItems.GREEN_ONION), new ItemStack(ModItems.FOOD10), 50,1),

            new Recipe(List.of(Items.PORKCHOP,ModItems.CHILANTRO,ModItems.CHILI,ModItems.CHILANTRO,ModItems.GARLIC,ModItems.SALT,ModItems.FISH_SAUCE,Items.EGG,Items.SUGAR), new ItemStack(ModItems.FOOD11), 50,1),
            new Recipe(List.of(ModItems.TOMATO,Items.PORKCHOP,ModItems.CHILI,ModItems.CHILI,ModItems.GARLIC,ModItems.SHALLOT,ModItems.SHRIMP_P,Items.SUGAR,ModItems.OIL), new ItemStack(ModItems.FOOD12), 50,1),
            new Recipe(List.of(Items.CHICKEN,ModItems.KAFFIR,ModItems.CHILI,ModItems.GALANGAL,ModItems.LEMONGRASS,ModItems.SHALLOT,ModItems.GARLIC,ModItems.SALT), new ItemStack(ModItems.FOOD13), 50,1),
            new Recipe(List.of(ModItems.CHILI,ModItems.SHALLOT,ModItems.GARLIC,Items.COD,ModItems.SHRIMP_P,ModItems.TAMARIND_P,Items.SUGAR,ModItems.FISH_SAUCE,ModItems.OIL), new ItemStack(ModItems.FOOD14), 50,1),
            new Recipe(List.of(ModItems.CHILI,ModItems.SHALLOT,ModItems.GARLIC,Items.SALMON,ModItems.SHRIMP_P,ModItems.TAMARIND_P,Items.SUGAR,ModItems.FISH_SAUCE,ModItems.OIL), new ItemStack(ModItems.FOOD14), 50,1),
            new Recipe(List.of(Items.CHICKEN,ModItems.CHILI,ModItems.FISH_SAUCE,ModItems.CHILANTRO,ModItems.GREEN_ONION,ModItems.LAKSA,ModItems.LEMONGRASS,ModItems.KAFFIR), new ItemStack(ModItems.FOOD15), 50,1),

            new Recipe(List.of(Items.PORKCHOP,ModItems.CHILI,ModItems.CHILI,ModItems.LAKSA,ModItems.SPEARMINT,ModItems.GREEN_ONION,ModItems.CHILANTRO), new ItemStack(ModItems.FOOD16), 50,1),
            new Recipe(List.of(ModItems.RICE,ModItems.RICE,Items.PORKCHOP,ModItems.LEMONGRASS,ModItems.SALT,ModItems.GARLIC,ModItems.SHALLOT,ModItems.CHILI), new ItemStack(ModItems.FOOD17), 50,1),

            new Recipe(List.of(Items.CHICKEN,ModItems.LONG_BEAN,ModItems.THAI_EGGPLANT,Items.BROWN_MUSHROOM,ModItems.CHILI,ModItems.SHRIMP_P,ModItems.FISH_SAUCE,Items.SUGAR), new ItemStack(ModItems.FOOD19), 50,1),
            new Recipe(List.of(Items.CHICKEN,ModItems.LONG_BEAN,ModItems.THAI_EGGPLANT,Items.RED_MUSHROOM,ModItems.CHILI,ModItems.SHRIMP_P,ModItems.FISH_SAUCE,Items.SUGAR), new ItemStack(ModItems.FOOD19), 50,1),

            new Recipe(List.of(ModItems.CHILI,ModItems.LEMONGRASS,ModItems.SHALLOT,ModItems.LAKSA,ModItems.GREEN_ONION,ModItems.CHILANTRO,Items.PORKCHOP,ModItems.SPEARMINT,ModItems.SALT), new ItemStack(ModItems.FOOD20), 50,1),
            new Recipe(List.of(ModItems.CHILI,ModItems.LEMONGRASS,ModItems.SHALLOT,ModItems.LAKSA,ModItems.GREEN_ONION,ModItems.CHILANTRO,Items.CHICKEN,ModItems.SPEARMINT,ModItems.SALT), new ItemStack(ModItems.FOOD20), 50,1),
            new Recipe(List.of(ModItems.CHILI,ModItems.LEMONGRASS,ModItems.SHALLOT,ModItems.LAKSA,ModItems.GREEN_ONION,ModItems.CHILANTRO,Items.BEEF,ModItems.SPEARMINT,ModItems.SALT), new ItemStack(ModItems.FOOD20), 50,1),

            new Recipe(List.of(ModItems.RICE,Items.WATER_BUCKET), new ItemStack(ModItems.FOOD21), 50,3),


            new Recipe(List.of(Items.BEEF), new ItemStack(Items.COOKED_BEEF), 30,1),
            new Recipe(List.of(Items.PORKCHOP), new ItemStack(Items.COOKED_PORKCHOP), 30,1),
            new Recipe(List.of(Items.CHICKEN), new ItemStack(Items.COOKED_CHICKEN), 30,1)
    );

    private static class Recipe {
        List<Item> inputs;
        ItemStack output;
        int cookTime;

        /*Recipe(List<Item> inputs, ItemStack output, int cookTime) {
            this.inputs = inputs;
            this.output = output.copy(); // Copy to avoid modifying original items
            this.cookTime = cookTime;
        }*/

        Recipe(List<Item> inputs, ItemStack output, int cookTime, int outputCount) {
            this.inputs = inputs;
            this.output = output.copy();
            this.output.setCount(outputCount); // Set the amount of output items
            this.cookTime = cookTime;
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

        // Deduct required items from inventory
        for (Item requiredItem : requiredItems) {
            int needed = (int) recipe.inputs.stream().filter(item -> item == requiredItem).count();
            for (int i = 0; i < 9 && needed > 0; i++) {
                ItemStack stack = this.inventory.get(i);
                if (stack.isOf(requiredItem)) {
                    int toRemove = Math.min(stack.getCount(), needed);
                    stack.decrement(toRemove);
                    needed -= toRemove;
                }
            }
        }

        // Handle output slot stacking
        ItemStack outputStack = this.inventory.get(OUTPUT);
        if (!outputStack.isEmpty() && outputStack.isOf(recipe.output.getItem())) {
            outputStack.increment(recipe.output.getCount());
        } else if (outputStack.isEmpty()) {
            this.inventory.set(OUTPUT, recipe.output.copy());
        }

        markDirty();
    }

    private boolean canCraft(Recipe recipe) {
        List<Item> requiredItems = new ArrayList<>(recipe.inputs);
        int[] itemCounts = new int[9]; // Store counts per slot

        // Count available items in input slots
        for (int i = 0; i < 9; i++) {
            ItemStack stack = this.inventory.get(i);
            if (!stack.isEmpty()) {
                itemCounts[i] = stack.getCount();
            }
        }

        // Check if enough of each required item is available
        for (Item requiredItem : requiredItems) {
            int needed = 0;
            for (int i = 0; i < 9; i++) {
                if (this.inventory.get(i).isOf(requiredItem)) {
                    needed += itemCounts[i]; // Add item count from this slot
                    if (needed >= recipe.inputs.stream().filter(item -> item == requiredItem).count()) {
                        break; // Stop if enough is found
                    }
                }
            }
            if (needed < recipe.inputs.stream().filter(item -> item == requiredItem).count()) {
                return false; // Not enough items
            }
        }
        return true;
    }


    public int getCookProgress() {
        Recipe currentRecipe = getCurrentRecipe();
        if (currentRecipe != null) {
            return (int) ((float) cookTime / currentRecipe.cookTime * 24); // 24 is the arrow width
        }
        return 0;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        ImplementedInventory.super.setStack(slot, stack); // Call the superclass method to handle the normal stack update
        if (slot < 9) {  // Check if the change was in the input slots (0-8)
            this.cookTime = 0; // Reset cook time when an item is pulled out
        }
    }


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
