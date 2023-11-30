package com.getblockt.progressioncraft.block;

import com.getblockt.progressioncraft.ProgressionCraft;
import com.getblockt.progressioncraft.block.custom.CorruptedFireBlock;
import com.getblockt.progressioncraft.block.custom.WartBlock;
import com.getblockt.progressioncraft.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block SNOW_BRICKS = registerBlock("snow_bricks",
            new Block(FabricBlockSettings.create().mapColor(MapColor.WHITE).requiresTool()
                    .strength(1.5f, 3.0f).sounds(BlockSoundGroup.SNOW)));
    public static final Block SNOW_BRICK_SLAB = registerBlock("snow_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.SNOW_BRICKS)));
    public static final Block SNOW_BRICK_STAIRS = registerBlock("snow_brick_stairs",
            new StairsBlock(ModBlocks.SNOW_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.SNOW_BRICKS)));
    public static final Block SNOW_BRICK_WALL = registerBlock("snow_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(ModBlocks.SNOW_BRICKS)));

    public static final Block WART = Registry.register(Registries.BLOCK, new Identifier(ProgressionCraft.MOD_ID, "wart"),
            new WartBlock(Blocks.SAND, ModItems.WART, FabricBlockSettings.copyOf(Blocks.NETHER_WART).mapColor(MapColor.SPRUCE_BROWN)));
    public static final Block WART_BLOCK = registerBlock("wart_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHER_WART_BLOCK).mapColor(MapColor.SPRUCE_BROWN)));

    public static final Block INFUSION_PILLAR = registerBlock("infusion_pillar",
            new Block(FabricBlockSettings.create().mapColor(MapColor.DEEPSLATE_GRAY).requiresTool()
                    .strength(5.0f, 6.0f).sounds(BlockSoundGroup.DEEPSLATE).nonOpaque()));

    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.GRAY).requiresTool()
                    .strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL)));

    public static final Block CORRUPTED_FIRE = registerBlockNoItem("corrupted_fire",
            new CorruptedFireBlock(FabricBlockSettings.create().mapColor(MapColor.PINK).replaceable().noCollision().breakInstantly().
                    luminance(state -> 15).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));


    private static void addBlocksToBuildingBlocksItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(SNOW_BRICKS);
        entries.add(SNOW_BRICK_STAIRS);
        entries.add(SNOW_BRICK_SLAB);
        entries.add(SNOW_BRICK_WALL);
        entries.add(STEEL_BLOCK);
    }
    private static void addBlocksToNaturalItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(WART_BLOCK);
    }
    private static void addBlocksToFunctionalItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(INFUSION_PILLAR);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ProgressionCraft.MOD_ID, name), block);
    }

    private static Block registerBlockNoItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(ProgressionCraft.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(ProgressionCraft.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        ProgressionCraft.LOGGER.info("Registering Mod Blocks for " + ProgressionCraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addBlocksToBuildingBlocksItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModBlocks::addBlocksToNaturalItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModBlocks::addBlocksToFunctionalItemGroup);
    }
}
