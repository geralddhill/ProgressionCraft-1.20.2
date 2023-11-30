package com.getblockt.progressioncraft.entity.damage;

import com.getblockt.progressioncraft.ProgressionCraft;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDamageTypes {
    public static final RegistryKey<DamageType> IN_FIRE_SOUL = registerDamageType("in_fire_soul");
    public static final RegistryKey<DamageType> ON_FIRE_SOUL = registerDamageType("on_fire_soul");
    public static final RegistryKey<DamageType> IN_FIRE_CORRUPTED = registerDamageType("in_fire_corrupted");
    public static final RegistryKey<DamageType> ON_FIRE_CORRUPTED = registerDamageType("on_fire_corrupted");

    public static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }

    private static RegistryKey<DamageType> registerDamageType(String name) {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(ProgressionCraft.MOD_ID, name));
    }
}
