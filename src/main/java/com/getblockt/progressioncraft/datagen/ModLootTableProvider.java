package com.getblockt.progressioncraft.datagen;

import com.getblockt.progressioncraft.ProgressionCraft;
import com.getblockt.progressioncraft.block.ModBlocks;
import com.getblockt.progressioncraft.block.custom.WartBlock;
import com.getblockt.progressioncraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SNOW_BRICK_SLAB, slabDrops(ModBlocks.SNOW_BRICK_SLAB));
        addDrop(ModBlocks.SNOW_BRICK_STAIRS);
        addDrop(ModBlocks.SNOW_BRICK_WALL);
        addDrop(ModBlocks.SNOW_BRICKS);

        addDrop(ModBlocks.WART, (Block block) -> LootTable.builder().pool(this.applyExplosionDecay((ItemConvertible)block,
                LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f))
                        .with((LootPoolEntry.Builder<?>)((Object)((LeafEntry.Builder) ItemEntry.builder(ModItems.WART)
                                .apply((LootFunction.Builder)((Object) SetCountLootFunction.builder(UniformLootNumberProvider
                                        .create(2.0f, 4.0f)).conditionally(BlockStatePropertyLootCondition.builder(block)
                                        .properties(StatePredicate.Builder.create().exactMatch(WartBlock.AGE, 3))))))
                                .apply((LootFunction.Builder)((Object) ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE)
                                        .conditionally(BlockStatePropertyLootCondition.builder(block)
                                                .properties(StatePredicate.Builder.create().exactMatch(WartBlock.AGE, 3))))))))));
        addDrop(ModBlocks.WART_BLOCK);
    }
}
