package net.lion.northernthaifoodmod.world;

import com.google.common.collect.ImmutableList;
import net.lion.northernthaifoodmod.NorthernThaiFoodMod;
import net.lion.northernthaifoodmod.block.ModBlocks;
import net.lion.northernthaifoodmod.block.custom.BeanCropBlock;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.processor.RuleStructureProcessor;
import net.minecraft.structure.processor.StructureProcessorRule;
import net.minecraft.structure.rule.AlwaysTrueRuleTest;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RandomBlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> BEAN_CROP_KEY = registerKey("bean_crop");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        BlockPredicate grassPredicate = BlockPredicate.matchingBlocks(Blocks.GRASS_BLOCK);

        // กำหนดการเกิดของ Bean Crop ให้เกิดบน Grass Block
        register(context, BEAN_CROP_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(
                                BlockStateProvider.of(ModBlocks.BEAN_CROP.getDefaultState().with(BeanCropBlock.AGE, 6)) // กำหนดให้เป็นอายุ 6 (เติบโตเต็มที่)
                        ),
                        List.of(Blocks.GRASS_BLOCK) // ให้เกิดเฉพาะบนบล็อก Grass Block
                ),
                grassPredicate // ใช้ BlockPredicate ที่กำหนด
        );

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(NorthernThaiFoodMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration, BlockPredicate grassPredicate) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

