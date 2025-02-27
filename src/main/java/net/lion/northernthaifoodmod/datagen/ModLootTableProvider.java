package net.lion.northernthaifoodmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.lion.northernthaifoodmod.block.ModBlocks;
import net.lion.northernthaifoodmod.block.custom.*;
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



        BlockStatePropertyLootCondition.Builder beanCondition = BlockStatePropertyLootCondition.builder(ModBlocks.BEAN_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(BeanCropBlock.AGE, BeanCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder chiliCondition = BlockStatePropertyLootCondition.builder(ModBlocks.CHILI_CHOP)
                .properties(StatePredicate.Builder.create().exactMatch(ChiliCropBlock.AGE, ChiliCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder CilantroCondition = BlockStatePropertyLootCondition.builder(ModBlocks.CILANTRO_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(CilantroCropBlock.AGE, CilantroCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder galangalCondition = BlockStatePropertyLootCondition.builder(ModBlocks.GALANGAL_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(GalangalCropBlock.AGE, GalangalCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder garlicCondition = BlockStatePropertyLootCondition.builder(ModBlocks.GARLIC_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(GarlicCropBlock.AGE, GarlicCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder gingerCondition = BlockStatePropertyLootCondition.builder(ModBlocks.GINGER_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(GingerCropBlock.AGE, GingerCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder greenOnionCondition = BlockStatePropertyLootCondition.builder(ModBlocks.GREEN_ONION_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(GreenOnionCropBlock.AGE, GreenOnionCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder IvyCondition = BlockStatePropertyLootCondition.builder(ModBlocks.IVY_G_L_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(IvygourdleavesCropBlock.AGE, IvygourdleavesCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder KaffirCondition = BlockStatePropertyLootCondition.builder(ModBlocks.KAFFIR_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(KaffirlimeleafCropBlock.AGE, KaffirlimeleafCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder KapokCondition = BlockStatePropertyLootCondition.builder(ModBlocks.KAPOK_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(KapokflowerCropBlock.AGE, KapokflowerCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder LaksaCondition = BlockStatePropertyLootCondition.builder(ModBlocks.LAKSA_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(LaksaleafCropBlock.AGE, LaksaleafCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder LemongrassCondition = BlockStatePropertyLootCondition.builder(ModBlocks.LEMONGRASS_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(LemongrassCropBlock.AGE, LemongrassCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder LongbeanCondition = BlockStatePropertyLootCondition.builder(ModBlocks.LONG_BEAN_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(LongbeanCropBlock.AGE, LongbeanCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder PineappleCondition = BlockStatePropertyLootCondition.builder(ModBlocks.PINEAPPLE_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(PineappleCropBlock.AGE, PineappleCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder RiceCondition = BlockStatePropertyLootCondition.builder(ModBlocks.RICE_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(RiceCropBlock.AGE, RiceCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder ShallotCondition = BlockStatePropertyLootCondition.builder(ModBlocks.SHALLOT_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(ShallotCropBlock.AGE, ShallotCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder SpearmintCondition = BlockStatePropertyLootCondition.builder(ModBlocks.SPEARMINT_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(SpearmintCropBlock.AGE, SpearmintCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder TamarindCondition = BlockStatePropertyLootCondition.builder(ModBlocks.TAMARIND_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(TamarindCropBlock.AGE, TamarindCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder ThaieggplantCondition = BlockStatePropertyLootCondition.builder(ModBlocks.THAI_EGGPLANT_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(ThaieggplantCropBlock.AGE, ThaieggplantCropBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder TomatoCondition = BlockStatePropertyLootCondition.builder(ModBlocks.TOMATO_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(TomatoCropBlock.AGE, TomatoCropBlock.MAX_AGE));



        this.addDrop(ModBlocks.CAULIFLOWER_CROP, this.cropDrops(ModBlocks.CAULIFLOWER_CROP, ModItems.CAULIFLOWER, ModItems.CAULIFLOWER_SEEDS, builder2));

        this.addDrop(ModBlocks.BEAN_CROP, this.cropDrops(ModBlocks.BEAN_CROP, ModItems.BEAN, ModItems.BEAN_SEED, beanCondition));
        this.addDrop(ModBlocks.CHILI_CHOP, this.cropDrops(ModBlocks.CHILI_CHOP, ModItems.CHILI, ModItems.CHILI_SEED, chiliCondition));
        this.addDrop(ModBlocks.CILANTRO_CROP, this.cropDrops(ModBlocks.CILANTRO_CROP, ModItems.CHILANTRO, ModItems.CILANTRO_SEED, CilantroCondition));
        this.addDrop(ModBlocks.GALANGAL_CROP, this.cropDrops(ModBlocks.GALANGAL_CROP, ModItems.GALANGAL, ModItems.GALANGAL_SEED, galangalCondition));
        this.addDrop(ModBlocks.GARLIC_CROP, this.cropDrops(ModBlocks.GARLIC_CROP, ModItems.GARLIC, ModItems.GARLIC_SEED, garlicCondition));

        this.addDrop(ModBlocks.GINGER_CROP, this.cropDrops(ModBlocks.GINGER_CROP, ModItems.GINGER, ModItems.GINGER_SEED, gingerCondition));
        this.addDrop(ModBlocks.GREEN_ONION_CROP, this.cropDrops(ModBlocks.GREEN_ONION_CROP, ModItems.GREEN_ONION, ModItems.GREEN_ONION_SEED, greenOnionCondition));
        this.addDrop(ModBlocks.IVY_G_L_CROP, this.cropDrops(ModBlocks.IVY_G_L_CROP, ModItems.IVY, ModItems.IVY_G_L_SEED, IvyCondition));
        this.addDrop(ModBlocks.KAFFIR_CROP, this.cropDrops(ModBlocks.KAFFIR_CROP, ModItems.KAFFIR, ModItems.KAFFIR_SEED, KaffirCondition));
        this.addDrop(ModBlocks.KAPOK_CROP, this.cropDrops(ModBlocks.KAPOK_CROP, ModItems.KAPOK, ModItems.KAPOK_SEED, KapokCondition));

        this.addDrop(ModBlocks.LAKSA_CROP, this.cropDrops(ModBlocks.LAKSA_CROP, ModItems.LAKSA, ModItems.LAKSA_SEED, LaksaCondition));
        this.addDrop(ModBlocks.LEMONGRASS_CROP, this.cropDrops(ModBlocks.LEMONGRASS_CROP, ModItems.LEMONGRASS, ModItems.LEMONGRASS_SEED, LemongrassCondition));
        this.addDrop(ModBlocks.LONG_BEAN_CROP, this.cropDrops(ModBlocks.LONG_BEAN_CROP, ModItems.LONG_BEAN, ModItems.LONG_BEAN_SEED, LongbeanCondition));
        this.addDrop(ModBlocks.PINEAPPLE_CROP, this.cropDrops(ModBlocks.PINEAPPLE_CROP, ModItems.PINEAPPLE, ModItems.PINEAPPLE_SEED, PineappleCondition));

        this.addDrop(ModBlocks.RICE_CROP, this.cropDrops(ModBlocks.RICE_CROP, ModItems.RICE, ModItems.RICE_SEED, RiceCondition));
        this.addDrop(ModBlocks.SHALLOT_CROP, this.cropDrops(ModBlocks.SHALLOT_CROP, ModItems.SHALLOT, ModItems.SHALLOT_SEED, ShallotCondition));
        this.addDrop(ModBlocks.SPEARMINT_CROP, this.cropDrops(ModBlocks.SPEARMINT_CROP, ModItems.SPEARMINT, ModItems.SPEARMINT_SEED, SpearmintCondition));

        this.addDrop(ModBlocks.TAMARIND_CROP, this.cropDrops(ModBlocks.TAMARIND_CROP, ModItems.TAMARIND, ModItems.TAMARIND_SEED, TamarindCondition));
        this.addDrop(ModBlocks.THAI_EGGPLANT_CROP, this.cropDrops(ModBlocks.THAI_EGGPLANT_CROP, ModItems.THAI_EGGPLANT, ModItems.THAI_EGGPLANT_SEED, ThaieggplantCondition));
        this.addDrop(ModBlocks.TOMATO_CROP, this.cropDrops(ModBlocks.TOMATO_CROP, ModItems.TOMATO, ModItems.TOMATO_SEED, TomatoCondition));

    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
