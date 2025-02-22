package net.lion.northernthaifoodmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.lion.northernthaifoodmod.block.ModBlocks;
import net.lion.northernthaifoodmod.block.custom.CauliflowerCropBlock;
import net.lion.northernthaifoodmod.block.custom.ChiliCropBlock;
import net.lion.northernthaifoodmod.block.custom.GreenOnionCropBlock;
import net.lion.northernthaifoodmod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        blockStateModelGenerator.registerCrop(ModBlocks.CAULIFLOWER_CROP, CauliflowerCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
        blockStateModelGenerator.registerCrop(ModBlocks.GREEN_ONION_CROP, GreenOnionCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        blockStateModelGenerator.registerCrop(ModBlocks.CHILI_CHOP, ChiliCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);

        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);

        itemModelGenerator.register(ModItems.CURRY_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.F_SOYBEAN_P, Models.GENERATED);
        itemModelGenerator.register(ModItems.FISH_SAUCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLOUR, Models.GENERATED);

        itemModelGenerator.register(ModItems.OIL, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHRIMP_P, Models.GENERATED);
        itemModelGenerator.register(ModItems.TAMARIND_P, Models.GENERATED);

        itemModelGenerator.register(ModItems.NOODLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RICE, Models.GENERATED);

        itemModelGenerator.register(ModItems.GREEN_ONION, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHILI, Models.GENERATED);

        itemModelGenerator.register(ModItems.FOOD1, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOD2, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOD3, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOD4, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOD5, Models.GENERATED);

        itemModelGenerator.register(ModItems.FOOD6, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOD7, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOD8, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOD9, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOD10, Models.GENERATED);

        itemModelGenerator.register(ModItems.FOOD11, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOD12, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOD13, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOD14, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOD15, Models.GENERATED);

        itemModelGenerator.register(ModItems.FOOD16, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOD17, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOD18, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOD19, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOOD20, Models.GENERATED);

        itemModelGenerator.register(ModItems.FOOD21, Models.GENERATED);

    }
}
