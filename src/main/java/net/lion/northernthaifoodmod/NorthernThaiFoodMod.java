package net.lion.northernthaifoodmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.lion.northernthaifoodmod.block.ModBlocks;
import net.lion.northernthaifoodmod.item.ModItemGroups;
import net.lion.northernthaifoodmod.item.ModItems;
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

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES,600);

	}
}