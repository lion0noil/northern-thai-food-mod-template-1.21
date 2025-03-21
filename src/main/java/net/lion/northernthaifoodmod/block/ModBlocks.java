package net.lion.northernthaifoodmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lion.northernthaifoodmod.NorthernThaiFoodMod;
import net.lion.northernthaifoodmod.block.custom.*;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool()));

    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));
    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerBlock("pink_garnet_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(1f).requiresTool()));

    public static final Block CAULIFLOWER_CROP = registerBlockWithoutBlockItem("cauliflower_crop",
            new CauliflowerCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block BEAN_CROP = registerBlockWithoutBlockItem("bean_crop",
            new BeanCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block CILANTRO_CROP = registerBlockWithoutBlockItem("cilantro_crop",
            new CilantroCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block CHILI_CHOP = registerBlockWithoutBlockItem("chili_crop",
            new ChiliCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block GALANGAL_CROP = registerBlockWithoutBlockItem("galangal_crop",
            new GalangalCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block GARLIC_CROP = registerBlockWithoutBlockItem("garlic_crop",
            new GarlicCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block GINGER_CROP = registerBlockWithoutBlockItem("ginger_crop",
            new GingerCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block GREEN_ONION_CROP = registerBlockWithoutBlockItem("green_onion_crop",
            new GreenOnionCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block IVY_G_L_CROP = registerBlockWithoutBlockItem("ivy_gourd_leaves_crop",
            new IvygourdleavesCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block KAFFIR_CROP = registerBlockWithoutBlockItem("kaffir_lime_leaf_crop",
            new KaffirlimeleafCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block KAPOK_CROP = registerBlockWithoutBlockItem("kapok_flower_crop",
            new KapokflowerCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block LAKSA_CROP = registerBlockWithoutBlockItem("laksa_leaf_crop",
            new LaksaleafCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block LEMONGRASS_CROP = registerBlockWithoutBlockItem("lemongrass_crop",
            new LemongrassCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block LONG_BEAN_CROP = registerBlockWithoutBlockItem("long_bean_crop",
            new LongbeanCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block PINEAPPLE_CROP = registerBlockWithoutBlockItem("pineapple_crop",
            new PineappleCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block RICE_CROP = registerBlockWithoutBlockItem("rice_crop",
            new RiceCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block SHALLOT_CROP = registerBlockWithoutBlockItem("shallot_crop",
            new ShallotCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block SPEARMINT_CROP = registerBlockWithoutBlockItem("spearmint_crop",
            new SpearmintCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block TAMARIND_CROP = registerBlockWithoutBlockItem("tamarind_crop",
            new TamarindCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block THAI_EGGPLANT_CROP = registerBlockWithoutBlockItem("thai_eggplant_crop",
            new ThaieggplantCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));

    public static final Block TOMATO_CROP = registerBlockWithoutBlockItem("tomato_crop",
            new TomatoCropBlock(AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN)));



    public static final Block STOVE = registerBlock("stove",
            new StoveBlock(AbstractBlock.Settings.create().nonOpaque()));

    public static final Block INGREDIENT_TRADES = registerBlock("ingredient_trades",
            new IngredienttradesBlock(AbstractBlock.Settings.create().nonOpaque()));

    public static final Block SELL_TRADES = registerBlock("sell_trades",
            new SelltradesBlock(AbstractBlock.Settings.create().nonOpaque()));

    public static final Block VEGETABLE_TRADES = registerBlock("vegetable_trades",
            new VegetabletradesBlock(AbstractBlock.Settings.create().nonOpaque()));



    public static final Block POT = registerBlock("pot",
            new PotBlock(AbstractBlock.Settings.create().nonOpaque()));




    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(NorthernThaiFoodMod.MOD_ID, name), block);
    }


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK,Identifier.of(NorthernThaiFoodMod.MOD_ID,name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(NorthernThaiFoodMod.MOD_ID,name),
                new BlockItem(block, new Item.Settings()));
    }


    public static void registerModBlocks() {
        NorthernThaiFoodMod.LOGGER.info("Registering Mod Blocks for" + NorthernThaiFoodMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.PINK_GARNET_BLOCK);
            entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);

        });
    }

}
