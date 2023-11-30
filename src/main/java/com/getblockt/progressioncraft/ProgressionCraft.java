package com.getblockt.progressioncraft;

import com.getblockt.progressioncraft.block.ModBlocks;
import com.getblockt.progressioncraft.entity.ModEntities;
import com.getblockt.progressioncraft.item.ModItemGroups;
import com.getblockt.progressioncraft.item.ModItems;
import com.getblockt.progressioncraft.sound.ModSounds;
import com.getblockt.progressioncraft.util.ModCustomTrades;
import com.getblockt.progressioncraft.util.ModLootTableModifiers;
import com.getblockt.progressioncraft.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProgressionCraft implements ModInitializer {
	public static final String MOD_ID = "progressioncraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.modifyLootTables();
		ModVillagers.registerVillagers();
		ModCustomTrades.registerCustomTrades();

		ModSounds.registerSounds();

		ModEntities.registerModEntities();
	}
}