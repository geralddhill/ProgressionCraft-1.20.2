package com.getblockt.progressioncraft.item;

import com.getblockt.progressioncraft.ProgressionCraft;
import com.getblockt.progressioncraft.block.ModBlocks;
import com.getblockt.progressioncraft.entity.ModEntities;
import com.getblockt.progressioncraft.item.custom.CorruptedFlintAndSteelItem;
import com.getblockt.progressioncraft.item.custom.DPSMeterItem;
import com.getblockt.progressioncraft.item.custom.ModArmorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item DESERT_SHARD = registerItem("desert_shard", new Item(new FabricItemSettings()));
    public static final Item FROST_SHARD = registerItem("frost_shard", new Item(new FabricItemSettings()));


    public static final Item CELESTIAL_INGOT = registerItem("celestial_ingot", new Item(new FabricItemSettings()));
    public static final Item CELESTIAL_SWORD = registerItem("celestial_sword",
            new SwordItem(ModToolMaterials.CELESTIAL, 3,-2.4f, new FabricItemSettings()));
    public static final Item CELESTIAL_SHOVEL = registerItem("celestial_shovel",
            new ShovelItem(ModToolMaterials.CELESTIAL, 1.5f,-3.0f, new FabricItemSettings()));
    public static final Item CELESTIAL_PICKAXE = registerItem("celestial_pickaxe",
            new PickaxeItem(ModToolMaterials.CELESTIAL, 1,-2.8f, new FabricItemSettings()));
    public static final Item CELESTIAL_AXE = registerItem("celestial_axe",
            new AxeItem(ModToolMaterials.CELESTIAL, 5.0f,-3.0f, new FabricItemSettings()));
    public static final Item CELESTIAL_HOE = registerItem("celestial_hoe",
            new HoeItem(ModToolMaterials.CELESTIAL, -5,0.0f, new FabricItemSettings()));


    public static final Item STRAY_FABRIC = registerItem("stray_fabric", new Item(new FabricItemSettings()));
    public static final Item STRAY_HELMET = registerItem("stray_helmet",
            new ModArmorItem(ModArmorMaterials.STRAY_FABRIC, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item STRAY_CHESTPLATE = registerItem("stray_chestplate",
            new ArmorItem(ModArmorMaterials.STRAY_FABRIC, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item STRAY_LEGGINGS = registerItem("stray_leggings",
            new ArmorItem(ModArmorMaterials.STRAY_FABRIC, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));


    public static final Item DPS_METER = registerItem("dps_meter",
            new DPSMeterItem(new FabricItemSettings()));


    public static final Item GOLDEN_SALMON = registerItem("golden_salmon",
            new Item(new FabricItemSettings().food(ModFoodComponents.GOLDEN_SALMON)));

    public static final Item WART = registerItem("wart",
            new AliasedBlockItem(ModBlocks.WART, new FabricItemSettings()));

    public static final Item CONJURED_SLIME_SPAWN_EGG = registerItem("conjured_slime_spawn_egg",
            new SpawnEggItem(ModEntities.CONJURED_SLIME, 0x853c9a, 0x9660a6, new FabricItemSettings()));

    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new FabricItemSettings()));

    public static final Item CORRUPTED_FLINT_AND_STEEL = registerItem("corrupted_flint_and_steel",
            new CorruptedFlintAndSteelItem(new FabricItemSettings().maxDamage(128)));

    private static void addItemsToNaturalItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(WART);
    }
    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(CORRUPTED_FLINT_AND_STEEL);
        entries.add(CELESTIAL_SHOVEL);
        entries.add(CELESTIAL_PICKAXE);
        entries.add(CELESTIAL_AXE);
        entries.add(CELESTIAL_HOE);
        entries.add(DPS_METER);
    }
    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.add(CELESTIAL_SWORD);
        entries.add(STRAY_HELMET);
        entries.add(STRAY_CHESTPLATE);
        entries.add(STRAY_LEGGINGS);
    }
    private static void addItemsToFoodItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(GOLDEN_SALMON);
    }
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(STEEL_INGOT);
        entries.add(DESERT_SHARD);
        entries.add(STRAY_FABRIC);
        entries.add(FROST_SHARD);
        entries.add(CELESTIAL_INGOT);
    }
    private static void addItemsToSpawnEggsItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(CONJURED_SLIME_SPAWN_EGG);
    }


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ProgressionCraft.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ProgressionCraft.LOGGER.info("Registering Mod Items for " + ProgressionCraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addItemsToNaturalItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(ModItems::addItemsToSpawnEggsItemGroup);
    }
}
