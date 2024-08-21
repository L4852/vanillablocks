package com.github.l4852.vanillablocks.datagen;

import com.github.l4852.vanillablocks.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.MARBLE_BLOCK)
                .add(ModBlocks.MARBLE_STAIRS)
                .add(ModBlocks.MARBLE_SLAB)
                .add(ModBlocks.POLISHED_MARBLE_BLOCK)
                .add(ModBlocks.POLISHED_MARBLE_STAIRS)
                .add(ModBlocks.POLISHED_MARBLE_PRESSURE_PLATE)
                .add(ModBlocks.POLISHED_MARBLE_DOOR)
                .add(ModBlocks.POLISHED_MARBLE_TRAPDOOR)
                .add(ModBlocks.POLISHED_MARBLE_BUTTON)
                .add(ModBlocks.POLISHED_MARBLE_SLAB)
                .add(ModBlocks.FLUSH_POLISHED_MARBLE_WALL)
                .add(ModBlocks.FLUSH_STONE_WALL)
                .add(ModBlocks.POLISHED_MARBLE_BEAM);
        getOrCreateTagBuilder(BlockTags.DOORS).add(ModBlocks.POLISHED_MARBLE_DOOR);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.POLISHED_MARBLE_WALL);
    }
}
