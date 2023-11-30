package com.getblockt.progressioncraft.datagen;

import com.getblockt.progressioncraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.CELESTIAL_SWORD);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.CELESTIAL_SHOVEL);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.CELESTIAL_PICKAXE);
        getOrCreateTagBuilder(ItemTags.CLUSTER_MAX_HARVESTABLES)
                .add(ModItems.CELESTIAL_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.CELESTIAL_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.CELESTIAL_HOE);
        getOrCreateTagBuilder(ConventionalItemTags.INGOTS)
                .add(ModItems.CELESTIAL_INGOT);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.STRAY_HELMET)
                .add(ModItems.STRAY_CHESTPLATE)
                .add(ModItems.STRAY_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FREEZE_IMMUNE_WEARABLES)
                .add(ModItems.STRAY_HELMET)
                .add(ModItems.STRAY_CHESTPLATE)
                .add(ModItems.STRAY_LEGGINGS);

        getOrCreateTagBuilder(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(ModItems.STEEL_INGOT);

        getOrCreateTagBuilder(ItemTags.CREEPER_IGNITERS)
                .add(ModItems.CORRUPTED_FLINT_AND_STEEL);
    }
}
