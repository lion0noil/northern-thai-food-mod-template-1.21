package net.lion.northernthaifoodmod.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.lion.northernthaifoodmod.NorthernThaiFoodMod;
import net.lion.northernthaifoodmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    //sell
    public static final RegistryKey<PointOfInterestType> SELL_POI_KEY = registerPoiKey("sell_poi");
    public static final PointOfInterestType SELL_POI = registerPOI("sell_poi",ModBlocks.SELL_TRADES);

    public static final VillagerProfession SELL = registerProfession("sell_trades_employee", SELL_POI_KEY);

    //vegetable
    public static final RegistryKey<PointOfInterestType> VEGETABLE_POI_KEY = registerPoiKey("vegetable_poi");
    public static final PointOfInterestType VEGETABLE_POI = registerPOI("vegetable_poi",ModBlocks.INGREDIENT_TRADES);

    public static final VillagerProfession VEGETABLE = registerProfession("vegetable_trades_employee", VEGETABLE_POI_KEY);


    //ingredient
    public static final RegistryKey<PointOfInterestType> INGREDIENT_POI_KEY = registerPoiKey("ingredient_poi");
    public static final PointOfInterestType INGREDIENT_POI = registerPOI("ingredient_poi",ModBlocks.VEGETABLE_TRADES);

    public static final VillagerProfession INGREDIENT = registerProfession("ingredient_trades_employee", INGREDIENT_POI_KEY);


    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(NorthernThaiFoodMod.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN));
    }

    private static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(Identifier.of(NorthernThaiFoodMod.MOD_ID, name),
                1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> registerPoiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(NorthernThaiFoodMod.MOD_ID, name));
    }


    public static void registerVillagers() {
        NorthernThaiFoodMod.LOGGER.info("Registering Villagers for " + NorthernThaiFoodMod.MOD_ID);
    }
}
