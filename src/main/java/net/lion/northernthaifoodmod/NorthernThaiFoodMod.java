package net.lion.northernthaifoodmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.lion.northernthaifoodmod.block.ModBlocks;
import net.lion.northernthaifoodmod.block.entity.ModBlockEntities;
import net.lion.northernthaifoodmod.item.ModItemGroups;
import net.lion.northernthaifoodmod.item.ModItems;
import net.lion.northernthaifoodmod.villager.ModVillagers;
import net.lion.northernthaifoodmod.world.gen.ModWorldGeneration;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NorthernThaiFoodMod implements ModInitializer {

	public static final String MOD_ID = "northernthaifoodmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModWorldGeneration.generateModWorldGen();

		ModVillagers.registerVillagers();

		ModBlockEntities.registerBlockEntities();


		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES,600);


		CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER, 0.5f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER_SEEDS, 0.25f);

		CompostingChanceRegistry.INSTANCE.add(ModItems.GREEN_ONION, 0.5f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.GREEN_ONION_SEED, 0.25f);

		CompostingChanceRegistry.INSTANCE.add(ModItems.CHILI, 0.5f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.CHILI_SEED, 0.25f);

		TradeOfferHelper.registerVillagerOffers(ModVillagers.SELL,1,factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.RICE,10),
					new ItemStack(Items.EMERALD,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.BEAN,8),
					new ItemStack(Items.EMERALD,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.CHILI,15),
					new ItemStack(Items.EMERALD,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.CHILANTRO,10),
					new ItemStack(Items.EMERALD,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.GALANGAL,6),
					new ItemStack(Items.EMERALD,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.GARLIC,7),
					new ItemStack(Items.EMERALD,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.GINGER,7),
					new ItemStack(Items.EMERALD,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.GREEN_ONION,10),
					new ItemStack(Items.EMERALD,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.IVY,10),
					new ItemStack(Items.EMERALD,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.KAFFIR,12),
					new ItemStack(Items.EMERALD,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.KAPOK,12),
					new ItemStack(Items.EMERALD,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.LAKSA,9),
					new ItemStack(Items.EMERALD,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.LEMONGRASS,10),
					new ItemStack(Items.EMERALD,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.LONG_BEAN,8),
					new ItemStack(Items.EMERALD,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.PINEAPPLE,7),
					new ItemStack(Items.EMERALD,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.SHALLOT,9),
					new ItemStack(Items.EMERALD,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.SPEARMINT,10),
					new ItemStack(Items.EMERALD,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.TAMARIND,6),
					new ItemStack(Items.EMERALD,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.THAI_EGGPLANT,8),
					new ItemStack(Items.EMERALD,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.TOMATO,12),
					new ItemStack(Items.EMERALD,1),100,7,0.04f));

		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.VEGETABLE,1,factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,2),
					new ItemStack(ModItems.RICE,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,6),
					new ItemStack(ModItems.BEAN,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,4),
					new ItemStack(ModItems.CHILI,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,6),
					new ItemStack(ModItems.CHILANTRO,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,6),
					new ItemStack(ModItems.GALANGAL,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,6),
					new ItemStack(ModItems.GARLIC,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,6),
					new ItemStack(ModItems.GINGER,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,5),
					new ItemStack(ModItems.GREEN_ONION,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,3),
					new ItemStack(ModItems.IVY,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,4),
					new ItemStack(ModItems.KAFFIR,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,4),
					new ItemStack(ModItems.KAPOK,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,5),
					new ItemStack(ModItems.LAKSA_SEED,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,6),
					new ItemStack(ModItems.LEMONGRASS,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,5),
					new ItemStack(ModItems.LONG_BEAN,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,8),
					new ItemStack(ModItems.PINEAPPLE,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,5),
					new ItemStack(ModItems.SHALLOT,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,5),
					new ItemStack(ModItems.SPEARMINT,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,7),
					new ItemStack(ModItems.TAMARIND,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,7),
					new ItemStack(ModItems.THAI_EGGPLANT,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,6),
					new ItemStack(ModItems.TOMATO,1),100,7,0.04f));


		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.INGREDIENT,1,factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,3),
					new ItemStack(ModItems.CURRY_POWDER,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,3),
					new ItemStack(ModItems.F_SOYBEAN_P,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,4),
					new ItemStack(ModItems.FISH_SAUCE,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,2),
					new ItemStack(ModItems.FLOUR,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,3),
					new ItemStack(ModItems.OIL,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,2),
					new ItemStack(ModItems.SALT,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,2),
					new ItemStack(ModItems.SHRIMP_P,1),100,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,4),
					new ItemStack(ModItems.TAMARIND_P,1),100,7,0.04f));

		});


	}
}