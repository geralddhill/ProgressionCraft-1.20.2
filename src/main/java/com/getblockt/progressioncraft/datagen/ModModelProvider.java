package com.getblockt.progressioncraft.datagen;

import com.getblockt.progressioncraft.block.ModBlocks;
import com.getblockt.progressioncraft.block.custom.WartBlock;
import com.getblockt.progressioncraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool snowBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SNOW_BRICKS);
        snowBrickPool.slab(ModBlocks.SNOW_BRICK_SLAB);
        snowBrickPool.stairs(ModBlocks.SNOW_BRICK_STAIRS);
        snowBrickPool.wall(ModBlocks.SNOW_BRICK_WALL);

        blockStateModelGenerator.registerCrop(ModBlocks.WART, WartBlock.AGE, 0, 1, 1, 2);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WART_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STEEL_BLOCK);

        blockStateModelGenerator.getFireFloorModels(ModBlocks.CORRUPTED_FIRE);
        blockStateModelGenerator.getFireSideModels(ModBlocks.CORRUPTED_FIRE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CELESTIAL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DESERT_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAY_FABRIC, Models.GENERATED);
        itemModelGenerator.register(ModItems.FROST_SHARD, Models.GENERATED);

        itemModelGenerator.register(ModItems.DPS_METER, Models.GENERATED);

        itemModelGenerator.register(ModItems.GOLDEN_SALMON, Models.GENERATED);

        itemModelGenerator.register(ModItems.CELESTIAL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CELESTIAL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CELESTIAL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CELESTIAL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CELESTIAL_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STRAY_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STRAY_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STRAY_LEGGINGS));

        itemModelGenerator.register(ModItems.CONJURED_SLIME_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.CORRUPTED_FLINT_AND_STEEL, Models.GENERATED);
    }
}
