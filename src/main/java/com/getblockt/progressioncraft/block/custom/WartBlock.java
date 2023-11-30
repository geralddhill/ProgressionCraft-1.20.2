package com.getblockt.progressioncraft.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class WartBlock extends NetherWartBlock {
    private final Block plantableBlock;
    private final Item cropItem;

    public WartBlock(Block plantableBlock, Item cropItem, Settings settings) {
        super(settings);
        this.plantableBlock = plantableBlock;
        this.cropItem = cropItem;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(plantableBlock);
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(cropItem);
    }
}
