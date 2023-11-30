package com.getblockt.progressioncraft.item.custom;

import com.getblockt.progressioncraft.item.ModArmorMaterials;
import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Map;

public class ModArmorItem extends ArmorItem {
    static class ArmorEffectWrapper {
        public ArmorEffectWrapper(StatusEffectInstance statusEffectInstance, int slotsNeededForEffect) {
            this.statusEffectInstance = statusEffectInstance;
            this.slotsNeededForEffect = slotsNeededForEffect;
        }

        public StatusEffectInstance getStatusEffectInstance() {
            return statusEffectInstance;
        }

        public int getSlotsNeededForEffect() {
            return slotsNeededForEffect;
        }

        private final StatusEffectInstance statusEffectInstance;
        private final int slotsNeededForEffect;
    }
    private static final Map<ArmorMaterial, ArmorEffectWrapper> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, ArmorEffectWrapper>())
                    .put(ModArmorMaterials.STRAY_FABRIC, new ArmorEffectWrapper(new StatusEffectInstance(StatusEffects.HASTE, 400, 1,
                            false, false, true), 3)).build();






    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player && hasArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, ArmorEffectWrapper> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue().getStatusEffectInstance();
            int mapSlotsNeeded = entry.getValue().getSlotsNeededForEffect();

            if(hasCorrectArmorOn(mapArmorMaterial, player, mapSlotsNeeded)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect, mapSlotsNeeded);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, StatusEffectInstance mapStatusEffect, int mapSlotsNeeded) {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.getEffectType());

        if(hasCorrectArmorOn(mapArmorMaterial, player, mapSlotsNeeded) && !hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect));
        }
    }

    private boolean hasArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() || !breastplate.isEmpty()
                || !leggings.isEmpty() || !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player, int slotsNeeded) {
        int correctSlots = 0;

        for (ItemStack armorStack: player.getInventory().armor) {
            if(armorStack.getItem() instanceof ArmorItem) {
                if (((ArmorItem) armorStack.getItem()).getMaterial() == material)
                    correctSlots++;
            }
        }

        return correctSlots == slotsNeeded;
    }
}