package com.github.l4852.vanillablocks.item;

import com.github.l4852.vanillablocks.VanillaBlocks;
import com.github.l4852.vanillablocks.block.ModBlocks;
import com.github.l4852.vanillablocks.block.custom.BeamBlock;
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
    public static final Item REDSTONE_PICKAXE = registerItem("redstone_pickaxe", new PickaxeItem(ModToolMaterial.REDSTONE, 3, -3.0f, new FabricItemSettings()));
    public static final Item REDSTONE_AXE = registerItem("redstone_axe", new AxeItem(ModToolMaterial.REDSTONE, 10, -3.5f, new FabricItemSettings()));
    public static final Item REDSTONE_SWORD = registerItem("redstone_sword", new SwordItem(ModToolMaterial.REDSTONE, 3, -1.5f, new FabricItemSettings()));
    public static final Item REDSTONE_SHOVEL = registerItem("redstone_shovel", new ShovelItem(ModToolMaterial.REDSTONE, 1, -3.0f, new FabricItemSettings()));
    public static final Item REDSTONE_HOE = registerItem("redstone_hoe", new HoeItem(ModToolMaterial.REDSTONE, 2, -3.0f, new FabricItemSettings()));

    public static final Item EMERALD_PICKAXE = registerItem("emerald_pickaxe", new PickaxeItem(ModToolMaterial.EMERALD, 3, -2.5f, new FabricItemSettings()));
    public static final Item EMERALD_AXE = registerItem("emerald_axe", new AxeItem(ModToolMaterial.EMERALD, 15, -3.5f, new FabricItemSettings()));
    public static final Item EMERALD_SWORD = registerItem("emerald_sword", new SwordItem(ModToolMaterial.EMERALD, 5, -2.5f, new FabricItemSettings()));
    public static final Item EMERALD_SHOVEL = registerItem("emerald_shovel", new ShovelItem(ModToolMaterial.EMERALD, 3, -3.0f, new FabricItemSettings()));
    public static final Item EMERALD_HOE = registerItem("emerald_hoe", new HoeItem(ModToolMaterial.EMERALD, 4, -3.0f, new FabricItemSettings()));
    public static final Item SILICA = registerItem("silica", new Item(new FabricItemSettings()));
    public static final Item COPPER_DUST = registerItem("copper_dust", new Item(new FabricItemSettings()));
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
    private static final Block[] REDSTONE_BLOCKS = {
            ModBlocks.POLISHED_MARBLE_BUTTON,
            ModBlocks.POLISHED_MARBLE_PRESSURE_PLATE
    };
    private static final Item[] REDSTONE_ITEMS = {
            ModItems.SILICA,
            ModItems.COPPER_DUST
    };
    private static final Item[] INGREDIENT_ITEMS = {
    };

    private static final FlushWallBlock[] FLUSH_BLOCKS = {
            ModBlocks.FLUSH_STONE_WALL,
            ModBlocks.FLUSH_POLISHED_MARBLE_WALL
    };
    private static final TileBlock[] TILE_BLOCKS = {
            ModBlocks.POLISHED_MARBLE_TILE
    };
    private static final BeamBlock[] BEAM_BLOCKS = {
            ModBlocks.POLISHED_MARBLE_BEAM
    };

    private static final Item[] TOOL_ITEMS = {
            REDSTONE_PICKAXE,
            REDSTONE_AXE,
            REDSTONE_HOE,
            REDSTONE_SHOVEL,
            EMERALD_PICKAXE,
            EMERALD_AXE,
            EMERALD_HOE,
            EMERALD_SHOVEL
    };
    private static final Item[] COMBAT_ITEMS = {
            REDSTONE_SWORD,
            EMERALD_SWORD
    };


    private static void addItemsToBuildingBlocksGroup(FabricItemGroupEntries entries) {
        for (Item item : gameItems) {
            entries.add(item);
        }
        for (Block block : gameBlocks) {
            entries.add(block);
        }
        for (FlushWallBlock block : FLUSH_BLOCKS) {
            entries.add(block.asItem());
        }
        for (TileBlock block : TILE_BLOCKS) {
            entries.add(block.asItem());
        }
        for (BeamBlock block : BEAM_BLOCKS) {
            entries.add(block.asItem());
        }
    }

    private static void addItemsToCombatGroup(FabricItemGroupEntries entries) {
        for (Item item : COMBAT_ITEMS) {
            entries.add(item);
        }
    }

    private static void addItemsToRedstoneGroup(FabricItemGroupEntries entries) {
        for (Block block : REDSTONE_BLOCKS) {
            entries.add(block);
        }
        for (Item item : REDSTONE_ITEMS) {
            entries.add(item);
        }
    }

    private static void addItemsToToolGroup(FabricItemGroupEntries entries) {
        for (Item item : TOOL_ITEMS) {
            entries.add(item);
        }
    }

    private static void addItemsToIngredientGroup(FabricItemGroupEntries entries) {
        for (Item item : INGREDIENT_ITEMS) {
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
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientGroup);
    }
}
