package com.getblockt.progressioncraft.util;

import com.getblockt.progressioncraft.ProgressionCraft;
import com.getblockt.progressioncraft.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        ProgressionCraft.LOGGER.info("Registering Custom Trades for " + ProgressionCraft.MOD_ID);

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(ModItems.WART, 1),
                            12, 5, 0.05f)
                    );
                });
    }
}
