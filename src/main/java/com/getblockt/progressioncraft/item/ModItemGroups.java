package com.getblockt.progressioncraft.item;

import com.getblockt.progressioncraft.ProgressionCraft;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BOSS_SUMMONS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ProgressionCraft.MOD_ID, "boss_summons"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.boss_summons"))
                    .icon(() -> new ItemStack(ModItems.DESERT_SHARD)).entries((displayContext, entries) -> {
                        entries.add(ModItems.DESERT_SHARD);
                    }).build());

    public static void registerItemGroups() {
        ProgressionCraft.LOGGER.info("Registering Item Groups for " + ProgressionCraft.MOD_ID);
    }
}
