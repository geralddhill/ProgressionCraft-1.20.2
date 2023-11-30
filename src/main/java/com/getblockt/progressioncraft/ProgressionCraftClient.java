package com.getblockt.progressioncraft;

import com.getblockt.progressioncraft.block.ModBlocks;
import com.getblockt.progressioncraft.entity.ModEntities;
import com.getblockt.progressioncraft.entity.client.ConjuredSlimeEntityRenderer;
import com.getblockt.progressioncraft.entity.client.ModModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class ProgressionCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WART, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORRUPTED_FIRE, RenderLayer.getCutout());

        ModEntities.registerModEntityRenderers();
        ModModelLayers.registerModEntityModelLayers();
    }
}
