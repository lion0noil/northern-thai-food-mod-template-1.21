package net.lion.northernthaifoodmod.block.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.lion.northernthaifoodmod.block.ModBlocks;
import net.lion.northernthaifoodmod.block.entity.ImplementedInventory;
import net.lion.northernthaifoodmod.block.entity.ModBlockEntities;
import net.lion.northernthaifoodmod.screen.custom.PotScreenHandler;
import net.lion.northernthaifoodmod.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PotBlockEntity extends BlockEntity implements ImplementedInventory, ExtendedScreenHandlerFactory<BlockPos> {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(10,ItemStack.EMPTY);
    private int cookTime = 0;
    private static final int COOK_TIME_TOTAL = 100; // Adjust cooking speed

    public PotBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.POT_BE, pos, state);
    }
    public static void tick(World world, BlockPos pos, BlockState state, PotBlockEntity entity) {
        if (!world.isClient) {
            if (entity.isOnStove(world, pos)) {
                entity.cookTime++;
                if (entity.cookTime >= COOK_TIME_TOTAL) {
                    entity.cookItems();
                    entity.cookTime = 0;
                }
            } else {
                entity.cookTime = 0; // Reset cook time if not on stove
            }
        }
    }

    private boolean isOnStove(World world, BlockPos pos) {
        return world.getBlockState(pos.down()).getBlock() == ModBlocks.STOVE;
    }

    private void cookItems() {
        for (int i = 0; i < 9; i++) {
            ItemStack input = this.inventory.get(i);
            if (!input.isEmpty()) {
                ItemStack cooked = getCookedResult(input);
                if (!cooked.isEmpty()) {
                    this.inventory.set(i, ItemStack.EMPTY); // Remove raw item
                    this.inventory.set(9, cooked); // Place cooked item in output slot
                }
            }
        }
        markDirty();
    }

    private ItemStack getCookedResult(ItemStack input) {
        if (input.getItem() == Items.BEEF) {
            return new ItemStack(Items.COOKED_BEEF);
        } else if (input.getItem() == Items.PORKCHOP) {
            return new ItemStack(Items.COOKED_PORKCHOP);
        } else if (input.getItem() == Items.CHICKEN) {
            return new ItemStack(Items.COOKED_CHICKEN);
        } else {
            return ItemStack.EMPTY;
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
