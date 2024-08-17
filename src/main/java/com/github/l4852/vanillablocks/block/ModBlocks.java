package com.github.l4852.vanillablocks.block;

import com.github.l4852.vanillablocks.VanillaBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block MARBLE_BLOCK = registerBlock("marble_block", new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_DIORITE).slipperiness(0.65f).sounds(BlockSoundGroup.CHAIN)));

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(VanillaBlocks.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(VanillaBlocks.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        VanillaBlocks.LOGGER.info("Registering blocks for VanillaBlocks...");
    }
}
