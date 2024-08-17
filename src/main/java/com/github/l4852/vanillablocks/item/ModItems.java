package com.github.l4852.vanillablocks.item;

import com.github.l4852.vanillablocks.VanillaBlocks;
import com.github.l4852.vanillablocks.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    private static final Item FLUSH_STONE_WALL = registerItem("flush_stone_wall", new Item(new FabricItemSettings()));

    private static final Item[] gameItems = {};
    private static final Block[] gameBlocks = {ModBlocks.MARBLE_BLOCK};

    private static void addItemsToBuildingBlocksGroup(FabricItemGroupEntries entries) {
        for (Item item : gameItems) {
            entries.add(item);
        }
        for (Block block : gameBlocks) {
            entries.add(block);
        }
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(VanillaBlocks.MOD_ID, name), item);
    }

    public static void registerModItems() {
        VanillaBlocks.LOGGER.info("Registering mod items for VanillaBlocks...");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItems::addItemsToBuildingBlocksGroup);
    }
}
