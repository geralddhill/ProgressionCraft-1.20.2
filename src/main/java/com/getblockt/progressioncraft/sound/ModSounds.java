package com.getblockt.progressioncraft.sound;

import com.getblockt.progressioncraft.ProgressionCraft;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent ENTITY_CONJURED_SLIME_DEATH = registerSoundEvent("entity_conjured_slime_death");
    public static final SoundEvent ENTITY_CONJURED_SLIME_HURT = registerSoundEvent("entity_conjured_slime_hurt");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(ProgressionCraft.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        ProgressionCraft.LOGGER.info("Registering Sounds for " + ProgressionCraft.MOD_ID);
    }
}
