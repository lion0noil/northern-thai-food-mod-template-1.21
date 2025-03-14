package net.lion.northernthaifoodmod.block.entity;

import net.lion.northernthaifoodmod.NorthernThaiFoodMod;
import net.lion.northernthaifoodmod.block.ModBlocks;
import net.lion.northernthaifoodmod.block.entity.custom.PotBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<PotBlockEntity> POT_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(NorthernThaiFoodMod.MOD_ID, "pot_be"),
                    BlockEntityType.Builder.create(PotBlockEntity::new, ModBlocks.POT).build());


    public static void registerBlockEntities() {
        NorthernThaiFoodMod.LOGGER.info("Registering Block Entities for " + NorthernThaiFoodMod.MOD_ID);

    }
}
