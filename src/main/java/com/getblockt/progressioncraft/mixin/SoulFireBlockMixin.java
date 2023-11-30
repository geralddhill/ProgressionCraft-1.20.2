package com.getblockt.progressioncraft.mixin;

import com.getblockt.progressioncraft.entity.damage.ModDamageTypes;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoulFireBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SoulFireBlock.class)
public class SoulFireBlockMixin extends AbstractFireBlock {
    public SoulFireBlockMixin(AbstractBlock.Settings settings) {
        super(settings, 2.0f);
    }


    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!entity.isFireImmune()) {
            entity.setFireTicks(entity.getFireTicks() + 1);
            if (entity.getFireTicks() == 0) {
                entity.setOnFireFor(8);
            }
        }
        entity.damage(ModDamageTypes.of(world, ModDamageTypes.IN_FIRE_SOUL), 2.0f);
        super.onEntityCollision(state, world, pos, entity);
    }

    @Override
    public boolean isFlammable(BlockState state) {
        return true;
    }
}
