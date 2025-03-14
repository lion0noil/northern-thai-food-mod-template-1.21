package net.lion.northernthaifoodmod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.lion.northernthaifoodmod.NorthernThaiFoodMod;
import net.lion.northernthaifoodmod.screen.custom.PotScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<PotScreenHandler> POT_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(NorthernThaiFoodMod.MOD_ID, "pot_screen_handler"),
                    new ExtendedScreenHandlerType<>(PotScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers() {
        NorthernThaiFoodMod.LOGGER.info("Registering Screen Handlers for " + NorthernThaiFoodMod.MOD_ID);
    }
}
