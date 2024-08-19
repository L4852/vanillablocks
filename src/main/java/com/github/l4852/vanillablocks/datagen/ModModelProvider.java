package com.github.l4852.vanillablocks.datagen;

import com.github.l4852.vanillablocks.block.ModBlocks;
import com.github.l4852.vanillablocks.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    private static final Block[] CUBE_BLOCKS = {};

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool polished_marble_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_MARBLE_BLOCK);
        BlockStateModelGenerator.BlockTexturePool marble_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MARBLE_BLOCK);

        for (Block block : CUBE_BLOCKS) {
            blockStateModelGenerator.registerSimpleCubeAll(block);
        }

        polished_marble_pool.button(ModBlocks.POLISHED_MARBLE_BUTTON);
        polished_marble_pool.pressurePlate(ModBlocks.POLISHED_MARBLE_PRESSURE_PLATE);
        polished_marble_pool.stairs(ModBlocks.POLISHED_MARBLE_STAIRS);
        polished_marble_pool.slab(ModBlocks.POLISHED_MARBLE_SLAB);
        polished_marble_pool.wall(ModBlocks.POLISHED_MARBLE_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.POLISHED_MARBLE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.POLISHED_MARBLE_TRAPDOOR);

        marble_pool.stairs(ModBlocks.MARBLE_STAIRS);
        marble_pool.slab(ModBlocks.MARBLE_SLAB);
    }

    public static final Item[] toolListItems = {
            ModItems.REDSTONE_SWORD,
            ModItems.REDSTONE_SHOVEL,
            ModItems.REDSTONE_AXE,
            ModItems.REDSTONE_PICKAXE,
            ModItems.REDSTONE_HOE,
            ModItems.EMERALD_SWORD,
            ModItems.EMERALD_SHOVEL,
            ModItems.EMERALD_AXE,
            ModItems.EMERALD_PICKAXE,
            ModItems.EMERALD_HOE
    };

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for (Item item : toolListItems) {
            itemModelGenerator.register(item, Models.HANDHELD);
        }
    }
}
