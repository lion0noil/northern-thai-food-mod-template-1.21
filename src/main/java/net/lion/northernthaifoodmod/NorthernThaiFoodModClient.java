package net.lion.northernthaifoodmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.lion.northernthaifoodmod.block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class NorthernThaiFoodModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAULIFLOWER_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREEN_ONION_CROP, RenderLayer.getCutout());

    }
}
