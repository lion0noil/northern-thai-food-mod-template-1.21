package net.lion.northernthaifoodmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lion.northernthaifoodmod.NorthernThaiFoodMod;
import net.lion.northernthaifoodmod.block.ModBlocks;
import net.lion.northernthaifoodmod.item.custom.ChiselItem;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {

    public static final Item PINK_GARNET = registerItem("pink_garnet",new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet",new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));
    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.northernthaifoodmod.cauliflower.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));

    public static final Item CAULIFLOWER_SEEDS = registerItem("cauliflower_seeds",
            new AliasedBlockItem(ModBlocks.CAULIFLOWER_CROP, new Item.Settings()));

    public static final Item CURRY_POWDER = registerItem("curry_powder", new Item(new Item.Settings()));
    public static final Item F_SOYBEAN_P = registerItem("fermented_soybean_paste", new Item(new Item.Settings()));
    public static final Item FISH_SAUCE = registerItem("fish_sauce", new Item(new Item.Settings()));
    public static final Item FLOUR = registerItem("flour", new Item(new Item.Settings()));

    public static final Item OIL = registerItem("oil", new Item(new Item.Settings()));
    public static final Item SALT = registerItem("salt", new Item(new Item.Settings()));
    public static final Item SHRIMP_P = registerItem("shrimp_paste", new Item(new Item.Settings()));
    public static final Item TAMARIND_P = registerItem("tamarind_paste", new Item(new Item.Settings()));

    public static final Item NOODLE = registerItem("noodle", new Item(new Item.Settings()));
    public static final Item RICE = registerItem("rice", new Item(new Item.Settings()));

    public static final Item BEAN = registerItem("bean", new Item(new Item.Settings()));
    public static final Item CHILI = registerItem("chili", new Item(new Item.Settings()));
    public static final Item CHILANTRO = registerItem("cilantro", new Item(new Item.Settings()));
    public static final Item GALANGAL = registerItem("galangal", new Item(new Item.Settings()));
    public static final Item GARLIC = registerItem("garlic", new Item(new Item.Settings()));

    public static final Item GINGER = registerItem("ginger", new Item(new Item.Settings()));
    public static final Item GREEN_ONION = registerItem("green_onion", new Item(new Item.Settings()));
    public static final Item IVY = registerItem("ivy_gourd_leaves", new Item(new Item.Settings()));
    public static final Item KAFFIR = registerItem("kaffir_lime_leaf", new Item(new Item.Settings()));
    public static final Item KAPOK = registerItem("kapok_flower", new Item(new Item.Settings()));

    public static final Item LAKSA = registerItem("laksa_leaf", new Item(new Item.Settings()));
    public static final Item LEMONGRASS = registerItem("lemongrass", new Item(new Item.Settings()));
    public static final Item LONG_BEAN = registerItem("long_bean", new Item(new Item.Settings()));
    public static final Item PINEAPPLE = registerItem("pineapple", new Item(new Item.Settings()));
    public static final Item SHALLOT = registerItem("shallot", new Item(new Item.Settings()));

    public static final Item SPEARMINT = registerItem("spearmint", new Item(new Item.Settings()));
    public static final Item TAMARIND = registerItem("tamarind", new Item(new Item.Settings()));
    public static final Item THAI_EGGPLANT = registerItem("thai_eggplant", new Item(new Item.Settings()));
    public static final Item TOMATO = registerItem("tomato", new Item(new Item.Settings()));

    public static final Item BEAN_SEED = registerItem("bean_seed",
            new AliasedBlockItem(ModBlocks.BEAN_CROP, new Item.Settings()));

    public static final Item CHILI_SEED = registerItem("chili_seed",
            new AliasedBlockItem(ModBlocks.CHILI_CHOP, new Item.Settings()));

    public static final Item CILANTRO_SEED = registerItem("cilantro_seed",
            new AliasedBlockItem(ModBlocks.CILANTRO_CROP, new Item.Settings()));

    public static final Item GALANGAL_SEED = registerItem("galangal_seed",
            new AliasedBlockItem(ModBlocks.GALANGAL_CROP, new Item.Settings()));

    public static final Item GARLIC_SEED = registerItem("garlic_seed",
            new AliasedBlockItem(ModBlocks.GARLIC_CROP, new Item.Settings()));

    public static final Item GINGER_SEED = registerItem("ginger_seed",
            new AliasedBlockItem(ModBlocks.GINGER_CROP, new Item.Settings()));

    public static final Item GREEN_ONION_SEED = registerItem("green_onion_seed",
            new AliasedBlockItem(ModBlocks.GREEN_ONION_CROP, new Item.Settings()));

    public static final Item IVY_G_L_SEED = registerItem("ivy_gourd_leaves_seed",
            new AliasedBlockItem(ModBlocks.IVY_G_L_CROP, new Item.Settings()));

    public static final Item KAFFIR_SEED = registerItem("kaffir_lime_leaf_seed",
            new AliasedBlockItem(ModBlocks.KAFFIR_CROP, new Item.Settings()));

    public static final Item KAPOK_SEED = registerItem("kapok_flower_seed",
            new AliasedBlockItem(ModBlocks.KAPOK_CROP, new Item.Settings()));

    public static final Item LAKSA_SEED = registerItem("laksa_leaf_seed",
            new AliasedBlockItem(ModBlocks.LAKSA_CROP, new Item.Settings()));

    public static final Item LEMONGRASS_SEED = registerItem("lemongrass_seed",
            new AliasedBlockItem(ModBlocks.LEMONGRASS_CROP, new Item.Settings()));

    public static final Item LONG_BEAN_SEED = registerItem("long_bean_seed",
            new AliasedBlockItem(ModBlocks.LONG_BEAN_CROP, new Item.Settings()));

    public static final Item PINEAPPLE_SEED = registerItem("pineapple_seed",
            new AliasedBlockItem(ModBlocks.PINEAPPLE_CROP, new Item.Settings()));

    public static final Item RICE_SEED = registerItem("rice_seed",
            new AliasedBlockItem(ModBlocks.RICE_CROP, new Item.Settings()));

    public static final Item SHALLOT_SEED = registerItem("shallot_seed",
            new AliasedBlockItem(ModBlocks.SHALLOT_CROP, new Item.Settings()));

    public static final Item SPEARMINT_SEED = registerItem("spearmint_seed",
            new AliasedBlockItem(ModBlocks.SPEARMINT_CROP, new Item.Settings()));


    public static final Item FOOD1 = registerItem("food1", new Item(new Item.Settings().food(ModFoodComponents.FOOD1)));
    public static final Item FOOD2 = registerItem("food2", new Item(new Item.Settings().food(ModFoodComponents.FOOD2)));
    public static final Item FOOD3 = registerItem("food3", new Item(new Item.Settings().food(ModFoodComponents.FOOD3)));
    public static final Item FOOD4 = registerItem("food4", new Item(new Item.Settings().food(ModFoodComponents.FOOD4)));
    public static final Item FOOD5 = registerItem("food5", new Item(new Item.Settings().food(ModFoodComponents.FOOD5)));

    public static final Item FOOD6 = registerItem("food6", new Item(new Item.Settings().food(ModFoodComponents.FOOD6)));
    public static final Item FOOD7 = registerItem("food7", new Item(new Item.Settings().food(ModFoodComponents.FOOD7)));
    public static final Item FOOD8 = registerItem("food8", new Item(new Item.Settings().food(ModFoodComponents.FOOD8)));
    public static final Item FOOD9 = registerItem("food9", new Item(new Item.Settings().food(ModFoodComponents.FOOD9)));
    public static final Item FOOD10 = registerItem("food10", new Item(new Item.Settings().food(ModFoodComponents.FOOD10)));

    public static final Item FOOD11 = registerItem("food11", new Item(new Item.Settings().food(ModFoodComponents.FOOD11)));
    public static final Item FOOD12 = registerItem("food12", new Item(new Item.Settings().food(ModFoodComponents.FOOD12)));
    public static final Item FOOD13 = registerItem("food13", new Item(new Item.Settings().food(ModFoodComponents.FOOD13)));
    public static final Item FOOD14 = registerItem("food14", new Item(new Item.Settings().food(ModFoodComponents.FOOD14)));
    public static final Item FOOD15 = registerItem("food15", new Item(new Item.Settings().food(ModFoodComponents.FOOD15)));

    public static final Item FOOD16 = registerItem("food16", new Item(new Item.Settings().food(ModFoodComponents.FOOD16)));
    public static final Item FOOD17 = registerItem("food17", new Item(new Item.Settings().food(ModFoodComponents.FOOD17)));
    public static final Item FOOD18 = registerItem("food18", new Item(new Item.Settings().food(ModFoodComponents.FOOD18)));
    public static final Item FOOD19 = registerItem("food19", new Item(new Item.Settings().food(ModFoodComponents.FOOD19)));
    public static final Item FOOD20 = registerItem("food20", new Item(new Item.Settings().food(ModFoodComponents.FOOD20)));

    public static final Item FOOD21 = registerItem("food21", new Item(new Item.Settings().food(ModFoodComponents.FOOD21)));



    private static Item registerItem(String name,Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(NorthernThaiFoodMod.MOD_ID, name), item);
    }



    public static void  registerModItems(){
        NorthernThaiFoodMod.LOGGER.info("Registering Mod Items for "+ NorthernThaiFoodMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });
    }
}
