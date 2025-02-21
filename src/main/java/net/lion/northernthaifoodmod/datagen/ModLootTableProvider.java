package net.lion.northernthaifoodmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.lion.northernthaifoodmod.block.ModBlocks;
import net.lion.northernthaifoodmod.block.custom.CauliflowerCropBlock;
import net.lion.northernthaifoodmod.block.custom.ChiliCropBlock;
import net.lion.northernthaifoodmod.block.custom.GreenOnionCropBlock;
import net.lion.northernthaifoodmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.PINK_GARNET_BLOCK);
        addDrop(ModBlocks.RAW_PINK_GARNET_BLOCK);
        addDrop(ModBlocks.MAGIC_BLOCK);

        addDrop(ModBlocks.PINK_GARNET_ORE, oreDrops(ModBlocks.PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET));
        addDrop(ModBlocks.PINK_GARNET_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.PINK_GARNET_DEEPSLATE_ORE, ModItems.RAW_PINK_GARNET, 3, 7));

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.CAULIFLOWER_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(CauliflowerCropBlock.AGE, CauliflowerCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder greenOnionCondition = BlockStatePropertyLootCondition.builder(ModBlocks.GREEN_ONION_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(GreenOnionCropBlock.AGE, GreenOnionCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder chiliCondition = BlockStatePropertyLootCondition.builder(ModBlocks.CHILI_CHOP)
                .properties(StatePredicate.Builder.create().exactMatch(ChiliCropBlock.AGE, ChiliCropBlock.MAX_AGE));

        this.addDrop(ModBlocks.CAULIFLOWER_CROP, this.cropDrops(ModBlocks.CAULIFLOWER_CROP, ModItems.CAULIFLOWER, ModItems.CAULIFLOWER_SEEDS, builder2));
        this.addDrop(ModBlocks.GREEN_ONION_CROP, this.cropDrops(ModBlocks.GREEN_ONION_CROP, ModItems.GREEN_ONION, ModItems.GREEN_ONION_SEED, greenOnionCondition));
        this.addDrop(ModBlocks.CHILI_CHOP, this.cropDrops(ModBlocks.CHILI_CHOP, ModItems.CHILI, ModItems.CHILI_SEED, chiliCondition));

    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
