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

    public static final Item GREEN_ONION = registerItem("green_onion", new Item(new Item.Settings()));
    public static final Item CHILI = registerItem("chili", new Item(new Item.Settings()));

    public static final Item GREEN_ONION_SEED = registerItem("green_onion_seed",
            new AliasedBlockItem(ModBlocks.GREEN_ONION_CROP, new Item.Settings()));

    public static final Item CHILI_SEED = registerItem("chili_seed",
            new AliasedBlockItem(ModBlocks.CHILI_CHOP, new Item.Settings()));

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
