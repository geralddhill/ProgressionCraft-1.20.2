package com.getblockt.progressioncraft.datagen;

import com.getblockt.progressioncraft.entity.ModEntities;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;

import java.util.concurrent.CompletableFuture;

public class ModEntityTypeTagProvider extends FabricTagProvider.EntityTypeTagProvider {
    public ModEntityTypeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(EntityTypeTags.FROG_FOOD)
                .add(ModEntities.CONJURED_SLIME);
        getOrCreateTagBuilder(EntityTypeTags.NON_CONTROLLING_RIDER)
                .add(ModEntities.CONJURED_SLIME);
    }
}
