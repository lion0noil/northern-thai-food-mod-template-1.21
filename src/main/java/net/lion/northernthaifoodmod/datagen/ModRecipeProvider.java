package net.lion.northernthaifoodmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.lion.northernthaifoodmod.NorthernThaiFoodMod;
import net.lion.northernthaifoodmod.block.ModBlocks;
import net.lion.northernthaifoodmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE,
                ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

        offerSmelting(exporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");
        offerBlasting(exporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 100, "pink_garnet");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RAW_PINK_GARNET)
                .criterion(hasItem(ModItems.RAW_PINK_GARNET), conditionsFromItem(ModItems.RAW_PINK_GARNET))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 9)
                .input(ModBlocks.RAW_PINK_GARNET_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 32)
                .input(ModBlocks.MAGIC_BLOCK)
                .criterion(hasItem(ModBlocks.MAGIC_BLOCK), conditionsFromItem(ModBlocks.MAGIC_BLOCK))
                .offerTo(exporter, Identifier.of(NorthernThaiFoodMod.MOD_ID, "raw_pink_garnet_from_magic_block"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RICE_SEED, 1)
                .input(ModItems.RICE)
                .criterion(hasItem(ModItems.RICE), conditionsFromItem(ModItems.RICE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BEAN_SEED, 1)
                .input(ModItems.BEAN)
                .criterion(hasItem(ModItems.BEAN), conditionsFromItem(ModItems.BEAN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHILI_SEED, 1)
                .input(ModItems.CHILI)
                .criterion(hasItem(ModItems.CHILI), conditionsFromItem(ModItems.CHILI))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CILANTRO_SEED, 1)
                .input(ModItems.CHILANTRO)
                .criterion(hasItem(ModItems.CHILANTRO), conditionsFromItem(ModItems.CHILANTRO))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GALANGAL_SEED, 1)
                .input(ModItems.GALANGAL)
                .criterion(hasItem(ModItems.GALANGAL), conditionsFromItem(ModItems.GALANGAL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GARLIC_SEED, 1)
                .input(ModItems.GARLIC)
                .criterion(hasItem(ModItems.GARLIC), conditionsFromItem(ModItems.GARLIC))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GINGER_SEED, 1)
                .input(ModItems.GINGER)
                .criterion(hasItem(ModItems.GINGER), conditionsFromItem(ModItems.GINGER))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GREEN_ONION_SEED, 1)
                .input(ModItems.GREEN_ONION)
                .criterion(hasItem(ModItems.GREEN_ONION), conditionsFromItem(ModItems.GREEN_ONION))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.IVY_G_L_SEED, 1)
                .input(ModItems.IVY)
                .criterion(hasItem(ModItems.IVY), conditionsFromItem(ModItems.IVY))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.KAFFIR_SEED, 1)
                .input(ModItems.KAFFIR)
                .criterion(hasItem(ModItems.KAFFIR), conditionsFromItem(ModItems.KAFFIR))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.KAPOK_SEED, 1)
                .input(ModItems.KAPOK)
                .criterion(hasItem(ModItems.KAPOK), conditionsFromItem(ModItems.KAPOK))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.LAKSA_SEED, 1)
                .input(ModItems.LAKSA)
                .criterion(hasItem(ModItems.LAKSA), conditionsFromItem(ModItems.LAKSA))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.LEMONGRASS_SEED, 1)
                .input(ModItems.LEMONGRASS)
                .criterion(hasItem(ModItems.LEMONGRASS), conditionsFromItem(ModItems.LEMONGRASS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.LONG_BEAN_SEED, 1)
                .input(ModItems.LONG_BEAN)
                .criterion(hasItem(ModItems.LONG_BEAN), conditionsFromItem(ModItems.LONG_BEAN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.PINEAPPLE_SEED, 1)
                .input(ModItems.PINEAPPLE)
                .criterion(hasItem(ModItems.PINEAPPLE), conditionsFromItem(ModItems.PINEAPPLE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SHALLOT_SEED, 1)
                .input(ModItems.SHALLOT)
                .criterion(hasItem(ModItems.SHALLOT), conditionsFromItem(ModItems.SHALLOT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SPEARMINT_SEED, 1)
                .input(ModItems.SPEARMINT)
                .criterion(hasItem(ModItems.SPEARMINT), conditionsFromItem(ModItems.SPEARMINT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.TAMARIND_SEED, 1)
                .input(ModItems.TAMARIND)
                .criterion(hasItem(ModItems.TAMARIND), conditionsFromItem(ModItems.TAMARIND))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.THAI_EGGPLANT_SEED, 1)
                .input(ModItems.THAI_EGGPLANT)
                .criterion(hasItem(ModItems.THAI_EGGPLANT), conditionsFromItem(ModItems.THAI_EGGPLANT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.TOMATO_SEED, 1)
                .input(ModItems.TOMATO)
                .criterion(hasItem(ModItems.TOMATO), conditionsFromItem(ModItems.TOMATO))
                .offerTo(exporter);




    }
}
