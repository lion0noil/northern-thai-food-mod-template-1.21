package net.lion.northernthaifoodmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.lion.northernthaifoodmod.block.ModBlocks;
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
					new ItemStack(Items.EMERALD,1),4,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.BEAN,8),
					new ItemStack(Items.EMERALD,1),4,7,0.04f));
		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.VEGETABLE,1,factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,3),
					new ItemStack(ModItems.BEAN,1),4,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,3),
					new ItemStack(ModItems.CHILI,1),4,7,0.04f));
		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.INGREDIENT,1,factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,2),
					new ItemStack(ModItems.CURRY_POWDER,1),4,7,0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD,2),
					new ItemStack(ModItems.F_SOYBEAN_P,1),4,7,0.04f));
		});


	}
}