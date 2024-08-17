package com.github.l4852.vanillablocks;

import com.github.l4852.vanillablocks.block.ModBlocks;
import com.github.l4852.vanillablocks.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VanillaBlocks implements ModInitializer {
    public static final String MOD_ID = "vanillablocks";
    public static final Logger LOGGER = LoggerFactory.getLogger("vanillablocks");

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        LOGGER.info("Hello Fabric world!");
    }
}