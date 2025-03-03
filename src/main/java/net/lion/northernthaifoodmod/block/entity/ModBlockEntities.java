package net.lion.northernthaifoodmod.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.lion.northernthaifoodmod.NorthernThaiFoodMod;
import net.lion.northernthaifoodmod.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.intellij.lang.annotations.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<PotBlockEntity> POT_BLOCK_ENTITY =
            Registry.register(
                    Registries.BLOCK_ENTITY_TYPE,
                    new Identifier(NorthernThaiFoodMod.MOD_ID, "pot_be"),
                    FabricBlockEntityTypeBuilder.create(PotBlockEntity::new, ModBlocks.POT).build()
            );

    public static void registerBlockEntities() {
        NorthernThaiFoodMod.LOGGER.info("Registering Block Entities for " + NorthernThaiFoodMod.MOD_ID);    }
}