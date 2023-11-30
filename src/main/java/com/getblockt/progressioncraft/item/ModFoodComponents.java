package com.getblockt.progressioncraft.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent GOLDEN_SALMON = new FoodComponent.Builder().hunger(6).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 50, 1), 1.0f)
            .alwaysEdible().build();
}
