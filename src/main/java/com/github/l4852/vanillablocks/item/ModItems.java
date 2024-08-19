package com.github.l4852.vanillablocks.item;

import com.github.l4852.vanillablocks.VanillaBlocks;
import com.github.l4852.vanillablocks.block.ModBlocks;
import com.github.l4852.vanillablocks.block.custom.FlushWallBlock;
import com.github.l4852.vanillablocks.block.custom.TileBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item REDSTONE_PICKAXE = registerItem("redstone_pickaxe", new PickaxeItem(ModToolMaterial.REDSTONE, 6, 4.0f, new FabricItemSettings()));
    public static final Item REDSTONE_AXE = registerItem("redstone_axe", new AxeItem(ModToolMaterial.REDSTONE, 10, 2.0f, new FabricItemSettings()));
    public static final Item REDSTONE_SWORD = registerItem("redstone_sword", new SwordItem(ModToolMaterial.REDSTONE, 15, 5.0f, new FabricItemSettings()));
    public static final Item REDSTONE_SHOVEL = registerItem("redstone_shovel", new ShovelItem(ModToolMaterial.REDSTONE, 1, 8.0f, new FabricItemSettings()));
    public static final Item REDSTONE_HOE = registerItem("redstone_hoe", new HoeItem(ModToolMaterial.REDSTONE, 4, 7.0f, new FabricItemSettings()));
    private static final Item[] gameItems = {};
    public static final Block[] gameBlocks = {
            ModBlocks.MARBLE_BLOCK,
            ModBlocks.POLISHED_MARBLE_BLOCK,
            ModBlocks.MARBLE_SLAB,
            ModBlocks.MARBLE_STAIRS,
            ModBlocks.POLISHED_MARBLE_BUTTON,
            ModBlocks.POLISHED_MARBLE_TRAPDOOR,
            ModBlocks.POLISHED_MARBLE_STAIRS,
            ModBlocks.POLISHED_MARBLE_WALL,
            ModBlocks.POLISHED_MARBLE_DOOR,
            ModBlocks.POLISHED_MARBLE_PRESSURE_PLATE,
            ModBlocks.POLISHED_MARBLE_SLAB
    };
    private static final Block[] redstoneItems = {
            ModBlocks.POLISHED_MARBLE_BUTTON,
            ModBlocks.POLISHED_MARBLE_PRESSURE_PLATE
    };

    private static final FlushWallBlock[] flushBlocks = {
            ModBlocks.FLUSH_STONE_WALL,
            ModBlocks.FLUSH_POLISHED_MARBLE_WALL
    };
    private static final TileBlock[] tileBlocks = {
            ModBlocks.POLISHED_MARBLE_TILE
    };

    private static final Item[] toolItems = {
            REDSTONE_PICKAXE,
            REDSTONE_AXE,
            REDSTONE_HOE,
            REDSTONE_SHOVEL
    };
    private static final Item[] combatItems = {
            REDSTONE_SWORD
    };


    private static void addItemsToBuildingBlocksGroup(FabricItemGroupEntries entries) {
        for (Item item : gameItems) {
            entries.add(item);
        }
        for (Block block : gameBlocks) {
            entries.add(block);
        }
        for (FlushWallBlock block : flushBlocks) {
            entries.add(block.asItem());
        }
        for (TileBlock block : tileBlocks) {
            entries.add(block.asItem());
        }
    }

    private static void addItemsToCombatGroup(FabricItemGroupEntries entries) {
        for (Item item : combatItems) {
            entries.add(item);
        }
    }

    private static void addItemsToRedstoneGroup(FabricItemGroupEntries entries) {
        for (Block block : redstoneItems) {
            entries.add(block);
        }
    }

    private static void addItemsToToolGroup(FabricItemGroupEntries entries) {
        for (Item item : toolItems) {
            entries.add(item);
        }
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(VanillaBlocks.MOD_ID, name), item);
    }

    public static void registerModItems() {
        VanillaBlocks.LOGGER.info("Registering mod items for VanillaBlocks...");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItems::addItemsToBuildingBlocksGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(ModItems::addItemsToRedstoneGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatGroup);
    }
}
