package com.github.l4852.vanillablocks.datagen;

import com.github.l4852.vanillablocks.VanillaBlocks;
import com.github.l4852.vanillablocks.block.ModBlocks;
import com.github.l4852.vanillablocks.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public static final Block[] NORMAL_DROPS = {
            ModBlocks.MARBLE_BLOCK,
            ModBlocks.POLISHED_MARBLE_BLOCK,
            ModBlocks.MARBLE_STAIRS,
            ModBlocks.POLISHED_MARBLE_BUTTON,
            ModBlocks.POLISHED_MARBLE_TRAPDOOR,
            ModBlocks.POLISHED_MARBLE_STAIRS,
            ModBlocks.POLISHED_MARBLE_PRESSURE_PLATE,
    };

    public static final Block[] DOORS = {
            ModBlocks.POLISHED_MARBLE_DOOR,
    };
    public static final Block[] SLABS = {
            ModBlocks.POLISHED_MARBLE_SLAB,
            ModBlocks.MARBLE_SLAB
    };

    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        for (Block block : NORMAL_DROPS) {
            addDrop(block);
        }
        for (Block block : DOORS) {
            addDrop(block, doorDrops(ModBlocks.POLISHED_MARBLE_DOOR));
        }
        for (Block block : SLABS) {
            addDrop(block, slabDrops(ModBlocks.POLISHED_MARBLE_SLAB));
        }
        addDrop(ModBlocks.FLUSH_STONE_WALL);
        addDrop(ModBlocks.FLUSH_POLISHED_MARBLE_WALL);
//        addDrop(ModBlocks.MARBLE_BLOCK, oreDrops(ModBlocks.MARBLE_BLOCK (silk touch drop), ModItems.MARBLE_BLOCK (main drop));
    }
}
