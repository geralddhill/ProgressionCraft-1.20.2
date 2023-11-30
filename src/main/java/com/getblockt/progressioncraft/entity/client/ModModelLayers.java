package com.getblockt.progressioncraft.entity.client;

import com.getblockt.progressioncraft.ProgressionCraft;
import com.getblockt.progressioncraft.entity.custom.ConjuredSlimeEntity;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer CONJURED_SLIME =
            new EntityModelLayer(new Identifier(ProgressionCraft.MOD_ID, "conjured_slime"), "main");
    public static final EntityModelLayer CONJURED_SLIME_OUTER =
            new EntityModelLayer(new Identifier(ProgressionCraft.MOD_ID, "conjured_slime"), "outer");


    public static void registerModEntityModelLayers() {
        ProgressionCraft.LOGGER.info("Registering Mod Entity Model Layers for " + ProgressionCraft.MOD_ID);

        EntityModelLayerRegistry.registerModelLayer(CONJURED_SLIME, ConjuredSlimeEntityModel::getInnerTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(CONJURED_SLIME_OUTER, ConjuredSlimeEntityModel::getOuterTexturedModelData);
    }
}
