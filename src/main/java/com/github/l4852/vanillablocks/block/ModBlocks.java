package com.github.l4852.vanillablocks.block;

import com.github.l4852.vanillablocks.VanillaBlocks;
import com.github.l4852.vanillablocks.block.custom.BeamBlock;
import com.github.l4852.vanillablocks.block.custom.FlushWallBlock;
import com.github.l4852.vanillablocks.block.custom.TileBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block POLISHED_MARBLE_BLOCK = registerBlock("polished_marble_block", new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_DIORITE).slipperiness(0.65f).sounds(BlockSoundGroup.CHAIN)));
    public static final Block MARBLE_BLOCK = registerBlock("marble_block", new Block(FabricBlockSettings.copyOf(Blocks.DIORITE)));
    public static final FlushWallBlock FLUSH_STONE_WALL = registerFlushWall("flush_stone_wall", new FlushWallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_WALL)));

    public static final Block MARBLE_STAIRS = registerBlock("marble_stairs", new StairsBlock(ModBlocks.MARBLE_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.DIORITE_STAIRS)));
    public static final Block MARBLE_SLAB = registerBlock("marble_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.DIORITE_SLAB)));
    public static final Block POLISHED_MARBLE_SLAB = registerBlock("polished_marble_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_DIORITE_SLAB)));
    public static final Block POLISHED_MARBLE_BUTTON = registerBlock("polished_marble_button", new ButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE_BUTTON), BlockSetType.STONE, 30, false));
    public static final Block POLISHED_MARBLE_PRESSURE_PLATE = registerBlock("polished_marble_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.copyOf(Blocks.STONE_PRESSURE_PLATE), BlockSetType.STONE));
    public static final Block POLISHED_MARBLE_WALL = registerBlock("polished_marble_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.DIORITE_WALL)));
    public static final FlushWallBlock FLUSH_POLISHED_MARBLE_WALL = registerFlushWall("flush_polished_marble_wall", new FlushWallBlock(FabricBlockSettings.copyOf(Blocks.STONE_BRICK_WALL)));
    public static final Block POLISHED_MARBLE_STAIRS = registerBlock("polished_marble_stairs", new StairsBlock(ModBlocks.MARBLE_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.POLISHED_DIORITE_STAIRS)));
    public static final Block POLISHED_MARBLE_DOOR = registerBlock("polished_marble_door", new DoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_DOOR).nonOpaque(), BlockSetType.STONE));
    public static final Block POLISHED_MARBLE_TRAPDOOR = registerBlock("polished_marble_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_TRAPDOOR).nonOpaque(), BlockSetType.STONE));
    public static final TileBlock POLISHED_MARBLE_TILE = registerTileBlock("polished_marble_tile", new TileBlock(FabricBlockSettings.copyOf(ModBlocks.POLISHED_MARBLE_SLAB)));
    public static final BeamBlock POLISHED_MARBLE_BEAM = registerBeamBlock("polished_marble_beam", new BeamBlock(FabricBlockSettings.copyOf(ModBlocks.POLISHED_MARBLE_WALL)));


    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(VanillaBlocks.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    private static Item registerFlushWallItem(String name, FlushWallBlock block) {
        return Registry.register(Registries.ITEM, new Identifier(VanillaBlocks.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    private static Item registerTileBlockItem(String name, TileBlock block) {
        return Registry.register(Registries.ITEM, new Identifier(VanillaBlocks.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    private static Item registerBeamBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(VanillaBlocks.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(VanillaBlocks.MOD_ID, name), block);
    }

    private static FlushWallBlock registerFlushWall(String name, FlushWallBlock block) {
        registerFlushWallItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(VanillaBlocks.MOD_ID, name), block);
    }

    private static TileBlock registerTileBlock(String name, TileBlock block) {
        registerTileBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(VanillaBlocks.MOD_ID, name), block);
    }

    private static BeamBlock registerBeamBlock(String name, BeamBlock block) {
        registerBeamBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(VanillaBlocks.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        VanillaBlocks.LOGGER.info("Registering blocks for VanillaBlocks...");
    }
}
