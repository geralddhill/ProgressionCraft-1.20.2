package com.getblockt.progressioncraft.entity;

import com.getblockt.progressioncraft.ProgressionCraft;
import com.getblockt.progressioncraft.entity.client.ConjuredSlimeEntityRenderer;
import com.getblockt.progressioncraft.entity.custom.ConjuredSlimeEntity;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<ConjuredSlimeEntity> CONJURED_SLIME = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(ProgressionCraft.MOD_ID, "conjured_slime"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ConjuredSlimeEntity::new)
                    .dimensions(EntityDimensions.fixed(2.04f, 2.04f)).trackRangeChunks(10).build());

    public static void registerModEntities() {
        ProgressionCraft.LOGGER.info("Registering Mod Entities for " + ProgressionCraft.MOD_ID);

        FabricDefaultAttributeRegistry.register(CONJURED_SLIME, ConjuredSlimeEntity.createConjuredSlimeAttributes());
    }

    public static void registerModEntityRenderers() {
        ProgressionCraft.LOGGER.info("Registering Mod Entity Renderers for " + ProgressionCraft.MOD_ID);

        EntityRendererRegistry.register(CONJURED_SLIME, ConjuredSlimeEntityRenderer::new);
    }
}
