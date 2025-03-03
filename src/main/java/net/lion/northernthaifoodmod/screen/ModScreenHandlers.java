package net.lion.northernthaifoodmod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.lion.northernthaifoodmod.NorthernThaiFoodMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import org.intellij.lang.annotations.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<PotScreenHandler> POT_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(NorthernThaiFoodMod.MOD_ID,"pot"),
                    new ExtendedScreenHandlerType<>(PotScreenHandler::new));

    public static void registerScreenHandler() {
        NorthernThaiFoodMod.LOGGER.info("Registering Screen Handlers for " + NorthernThaiFoodMod.MOD_ID);
    }
}
