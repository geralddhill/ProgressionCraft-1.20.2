package com.getblockt.progressioncraft.entity.client;

import com.getblockt.progressioncraft.ProgressionCraft;
import com.getblockt.progressioncraft.ProgressionCraftClient;
import com.getblockt.progressioncraft.entity.custom.ConjuredSlimeEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.SlimeOverlayFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class ConjuredSlimeEntityRenderer extends MobEntityRenderer<ConjuredSlimeEntity, ConjuredSlimeEntityModel<ConjuredSlimeEntity>> {
    private static final Identifier TEXTURE = new Identifier(ProgressionCraft.MOD_ID, "textures/entity/slime/conjured_slime.png");

    public ConjuredSlimeEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ConjuredSlimeEntityModel<>(context.getPart(ModModelLayers.CONJURED_SLIME)), 0.25f);
        this.addFeature(new ConjuredSlimeOverlayFeatureRenderer<>(this, context.getModelLoader()));
    }

    @Override
    public Identifier getTexture(ConjuredSlimeEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(ConjuredSlimeEntity conjuredSlimeEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        this.shadowRadius = 0.25f * (float)conjuredSlimeEntity.getSize();
        super.render(conjuredSlimeEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    protected void scale(ConjuredSlimeEntity conjuredSlimeEntity, MatrixStack matrixStack, float f) {
        float g = 0.999f;
        matrixStack.scale(0.999f, 0.999f, 0.999f);
        matrixStack.translate(0.0f, 0.001f, 0.0f);
        float h = conjuredSlimeEntity.getSize();
        float i = MathHelper.lerp(f, conjuredSlimeEntity.lastStretch, conjuredSlimeEntity.stretch) / (h * 0.5f + 1.0f);
        float j = 1.0f / (i + 1.0f);
        matrixStack.scale(j * h, 1.0f / j * h, j * h);
    }
}
