package com.getblockt.progressioncraft.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.SlimeEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

@Environment(value= EnvType.CLIENT)
public class ConjuredSlimeOverlayFeatureRenderer<T extends LivingEntity>
        extends FeatureRenderer<T, ConjuredSlimeEntityModel<T>> {
    private final EntityModel<T> model;

    public ConjuredSlimeOverlayFeatureRenderer(FeatureRendererContext<T, ConjuredSlimeEntityModel<T>> context, EntityModelLoader loader) {
        super(context);
        this.model = new ConjuredSlimeEntityModel(loader.getModelPart(ModModelLayers.CONJURED_SLIME_OUTER));
        }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l) {
        boolean bl;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        boolean bl2 = bl = minecraftClient.hasOutline((Entity)livingEntity) && ((Entity)livingEntity).isInvisible();
        if (((Entity)livingEntity).isInvisible() && !bl) {
            return;
        }
        VertexConsumer vertexConsumer = bl ? vertexConsumerProvider.getBuffer(RenderLayer.getOutline(this.getTexture(livingEntity))) : vertexConsumerProvider.getBuffer(RenderLayer.getEntityTranslucent(this.getTexture(livingEntity)));
        ((ConjuredSlimeEntityModel)this.getContextModel()).copyStateTo(this.model);
        this.model.animateModel(livingEntity, f, g, h);
        this.model.setAngles(livingEntity, f, g, j, k, l);
        this.model.render(matrixStack, vertexConsumer, i, LivingEntityRenderer.getOverlay(livingEntity, 0.0f), 1.0f, 1.0f, 1.0f, 0.75f);
    }
}
