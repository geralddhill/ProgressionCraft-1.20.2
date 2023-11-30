package com.getblockt.progressioncraft.block.custom;

import com.getblockt.progressioncraft.block.ModBlocks;
import com.getblockt.progressioncraft.entity.damage.ModDamageTypes;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class CorruptedFireBlock extends AbstractFireBlock {
    private final float damage = 1.5f;
    public CorruptedFireBlock(AbstractBlock.Settings settings) {
        super(settings, 1.5f);
    }

    public static BlockState getState(BlockView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        if (SoulFireBlock.isSoulBase(blockState)) {
            return Blocks.SOUL_FIRE.getDefaultState();
        }
        return ModBlocks.CORRUPTED_FIRE.getDefaultState();
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!entity.isFireImmune()) {
            entity.setFireTicks(entity.getFireTicks() + 1);
            if (entity.getFireTicks() == 0) {
                entity.setOnFireFor(8);
            }
        }
        entity.damage(ModDamageTypes.of(world, ModDamageTypes.IN_FIRE_CORRUPTED), this.damage);
        super.onEntityCollision(state, world, pos, entity);
    }

    @Override
    protected boolean isFlammable(BlockState state) {
        return true;
    }
}
