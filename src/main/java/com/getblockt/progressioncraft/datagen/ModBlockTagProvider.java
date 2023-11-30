package com.getblockt.progressioncraft.datagen;

import com.getblockt.progressioncraft.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.WART);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.WART_BLOCK);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.SNOW_BRICK_SLAB)
                .add(ModBlocks.SNOW_BRICK_STAIRS)
                .add(ModBlocks.SNOW_BRICK_WALL)
                .add(ModBlocks.SNOW_BRICKS)
                .add(ModBlocks.STEEL_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.STEEL_BLOCK);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.SNOW_BRICK_SLAB);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.SNOW_BRICK_STAIRS);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.SNOW_BRICK_WALL);

        getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT)
                .add(ModBlocks.WART);

        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.STEEL_BLOCK);

        getOrCreateTagBuilder(BlockTags.FIRE)
                .add(ModBlocks.CORRUPTED_FIRE);
        getOrCreateTagBuilder(BlockTags.REPLACEABLE)
                .add(ModBlocks.CORRUPTED_FIRE);
    }
}
