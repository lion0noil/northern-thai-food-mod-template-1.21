package net.lion.northernthaifoodmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.lion.northernthaifoodmod.NorthernThaiFoodMod;
import net.lion.northernthaifoodmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup PINK_GARNET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(NorthernThaiFoodMod.MOD_ID, "pink_garnet_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_GARNET))
                    .displayName(Text.translatable("itemgroup.northernthaifoodmod.pink_garnet_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModItems.RAW_PINK_GARNET);

                        entries.add(ModItems.CHISEL);
                        entries.add(ModItems.CAULIFLOWER);
                        entries.add(ModItems.CAULIFLOWER_SEEDS);

                        entries.add(ModItems.STARLIGHT_ASHES);

                    }).build());

    public static final ItemGroup PINK_GARNET_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(NorthernThaiFoodMod.MOD_ID, "pink_garnet_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
                    .displayName(Text.translatable("itemgroup.northernthaifoodmod.pink_garnet_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);

                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

                        entries.add(ModBlocks.MAGIC_BLOCK);


                    }).build());

    public static final ItemGroup NORTHERN_THAI_FOOD_MOD = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(NorthernThaiFoodMod.MOD_ID, "green_onion"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.GREEN_ONION))
                    .displayName(Text.translatable("itemgroup.northernthaifoodmod.northern_thai_food_mod"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CURRY_POWDER);
                        entries.add(ModItems.F_SOYBEAN_P);
                        entries.add(ModItems.FISH_SAUCE);
                        entries.add(ModItems.FLOUR);

                        entries.add(ModItems.OIL);
                        entries.add(ModItems.SALT);
                        entries.add(ModItems.SHRIMP_P);
                        entries.add(ModItems.TAMARIND_P);

                        entries.add(ModItems.NOODLE);
                        entries.add(ModItems.RICE);

                        entries.add(ModItems.GREEN_ONION);
                        entries.add(ModItems.CHILI);

                        entries.add(ModItems.GREEN_ONION_SEED);
                        entries.add(ModItems.CHILI_SEED);

                        entries.add(ModItems.FOOD1);
                        entries.add(ModItems.FOOD2);
                        entries.add(ModItems.FOOD3);
                        entries.add(ModItems.FOOD4);
                        entries.add(ModItems.FOOD5);

                        entries.add(ModItems.FOOD6);
                        entries.add(ModItems.FOOD7);
                        entries.add(ModItems.FOOD8);
                        entries.add(ModItems.FOOD9);
                        entries.add(ModItems.FOOD10);

                        entries.add(ModItems.FOOD11);
                        entries.add(ModItems.FOOD12);
                        entries.add(ModItems.FOOD13);
                        entries.add(ModItems.FOOD14);
                        entries.add(ModItems.FOOD15);

                        entries.add(ModItems.FOOD16);
                        entries.add(ModItems.FOOD17);
                        entries.add(ModItems.FOOD18);
                        entries.add(ModItems.FOOD19);
                        entries.add(ModItems.FOOD20);

                        entries.add(ModItems.FOOD21);


                    }).build());

    public static void registerItemGroups() {
        NorthernThaiFoodMod.LOGGER.info("Registering Item Group for "+NorthernThaiFoodMod.MOD_ID);

    }
}
