package com.github.l4852.vanillablocks.datagen;

import com.github.l4852.vanillablocks.block.ModBlocks;
import com.github.l4852.vanillablocks.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public static final Ingredient WOOD_PLANKS = Ingredient.ofItems(Items.OAK_PLANKS, Items.BIRCH_PLANKS, Items.ACACIA_PLANKS, Items.JUNGLE_PLANKS, Items.DARK_OAK_PLANKS, Items.BAMBOO_PLANKS, Items.CHERRY_PLANKS, Items.SPRUCE_PLANKS);

    //    private static final List<ItemConvertible> SMELTABLES = List.of();
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // ======================
        // ALTERNATE REDSTONE COMPONENT RECIPES
        // ======================
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.PISTON, 8)
                .pattern(" P ")
                .pattern(" S ")
                .pattern(" C ")
                .input('C', Items.COBBLESTONE)
                .input('S', Items.STICK)
                .input('P', WOOD_PLANKS)
                .criterion(hasItem(Items.COBBLESTONE), InventoryChangedCriterion.Conditions.items(Items.COBBLESTONE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.PISTON)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Blocks.STICKY_PISTON, 4)
                .pattern("   ")
                .pattern(" S ")
                .pattern(" P ")
                .input('S', Items.STRING)
                .input('P', Items.PISTON)
                .criterion(hasItem(Items.PISTON), InventoryChangedCriterion.Conditions.items(Items.PISTON))
                .offerTo(exporter, new Identifier(getRecipeName(Items.STICKY_PISTON)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModItems.SILICA, 16)
                .pattern(" S ")
                .pattern("SGS")
                .pattern(" S ")
                .input('S', Items.SAND)
                .input('G', Items.GRAVEL)
                .criterion(hasItem(Items.SAND), InventoryChangedCriterion.Conditions.items(Items.SAND))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SILICA)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModItems.COPPER_DUST, 4)
                .pattern("   ")
                .pattern(" C ")
                .pattern("   ")
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(Items.RAW_COPPER), InventoryChangedCriterion.Conditions.items(Items.RAW_COPPER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COPPER_DUST)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Items.REDSTONE, 4)
                .pattern(" S ")
                .pattern("SCS")
                .pattern(" S ")
                .input('S', ModItems.SILICA)
                .input('C', ModItems.COPPER_DUST)
                .criterion(hasItem(ModItems.COPPER_DUST), InventoryChangedCriterion.Conditions.items(ModItems.COPPER_DUST))
                .offerTo(exporter, new Identifier(getRecipeName(Items.REDSTONE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Items.OBSERVER, 4)
                .pattern("   ")
                .pattern(" C#")
                .pattern(" CC")
                .input('#', ModItems.COPPER_DUST)
                .input('C', Items.COBBLESTONE)
                .criterion(hasItem(ModItems.COPPER_DUST), InventoryChangedCriterion.Conditions.items(ModItems.COPPER_DUST))
                .offerTo(exporter, new Identifier(getRecipeName(Items.OBSERVER)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Items.REPEATER, 16)
                .pattern("   ")
                .pattern("R R")
                .pattern("CCC")
                .input('R', Items.REDSTONE)
                .input('C', Items.COBBLESTONE)
                .criterion(hasItem(Items.REDSTONE), InventoryChangedCriterion.Conditions.items(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.REPEATER)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Items.COMPARATOR, 16)
                .pattern("   ")
                .pattern("RRR")
                .pattern("CCC")
                .input('R', Items.REDSTONE)
                .input('C', Items.COBBLESTONE)
                .criterion(hasItem(Items.REDSTONE), InventoryChangedCriterion.Conditions.items(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.COMPARATOR)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Items.DISPENSER, 8)
                .pattern("CCC")
                .pattern("CR ")
                .pattern("CCC")
                .input('R', Items.REDSTONE)
                .input('C', Items.COBBLESTONE)
                .criterion(hasItem(Items.REDSTONE), InventoryChangedCriterion.Conditions.items(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.DISPENSER)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Items.DROPPER, 8)
                .pattern("CCC")
                .pattern("C  ")
                .pattern("CCC")
                .input('C', Items.COBBLESTONE)
                .criterion(hasItem(Items.REDSTONE), InventoryChangedCriterion.Conditions.items(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.DROPPER)));

        // ======================
        // ALTERNATE RAIL RECIPES
        // ======================

        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, Blocks.RAIL, 64)
                .pattern("   ")
                .pattern("ISI")
                .pattern("   ")
                .input('S', Items.STICK)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), InventoryChangedCriterion.Conditions.items(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(Items.RAIL)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, Blocks.POWERED_RAIL, 64)
                .pattern(" # ")
                .pattern(" R ")
                .pattern("   ")
                .input('R', Items.RAIL)
                .input('#', Items.REDSTONE)
                .criterion(hasItem(Items.RAIL), InventoryChangedCriterion.Conditions.items(Items.RAIL))
                .offerTo(exporter, new Identifier(getRecipeName(Items.POWERED_RAIL)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BLOCK, 9)
                .pattern("CIC")
                .pattern("I#I")
                .pattern("CIC")
                .input('C', Items.CALCITE)
                .input('I', Items.IRON_NUGGET)
                .input('#', Items.COBBLESTONE)
                .criterion(hasItem(Items.CALCITE), InventoryChangedCriterion.Conditions.items(Items.CALCITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.MARBLE_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUSH_STONE_WALL, 6)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Items.STONE)
                .criterion(hasItem(Items.STONE), InventoryChangedCriterion.Conditions.items(Items.STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.FLUSH_STONE_WALL)));
        // ======================
        // POLISHED MARBLE BLOCKS
        // ======================
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUSH_POLISHED_MARBLE_WALL, 6)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', ModBlocks.POLISHED_MARBLE_BLOCK.asItem())
                .criterion(hasItem(Items.STONE), InventoryChangedCriterion.Conditions.items(Items.STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.FLUSH_POLISHED_MARBLE_WALL)));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_BLOCK, ModBlocks.MARBLE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUSH_POLISHED_MARBLE_WALL, ModBlocks.POLISHED_MARBLE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_STAIRS, ModBlocks.POLISHED_MARBLE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_SLAB, ModBlocks.POLISHED_MARBLE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_WALL, ModBlocks.POLISHED_MARBLE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_TILE, ModBlocks.POLISHED_MARBLE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_BEAM, ModBlocks.POLISHED_MARBLE_BLOCK);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_SLAB, ModBlocks.POLISHED_MARBLE_BLOCK);
        offerPressurePlateRecipe(exporter, ModBlocks.POLISHED_MARBLE_PRESSURE_PLATE, ModBlocks.POLISHED_MARBLE_BLOCK);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_WALL, ModBlocks.POLISHED_MARBLE_BLOCK);

        createDoorRecipe(ModBlocks.POLISHED_MARBLE_DOOR, Ingredient.ofItems(ModBlocks.POLISHED_MARBLE_BLOCK))
                .criterion(hasItem(ModBlocks.POLISHED_MARBLE_BLOCK.asItem()), InventoryChangedCriterion.Conditions.items(ModBlocks.POLISHED_MARBLE_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.POLISHED_MARBLE_DOOR)));
        createStairsRecipe(ModBlocks.POLISHED_MARBLE_STAIRS, Ingredient.ofItems(ModBlocks.POLISHED_MARBLE_BLOCK))
                .criterion(hasItem(ModBlocks.POLISHED_MARBLE_BLOCK.asItem()), InventoryChangedCriterion.Conditions.items(ModBlocks.POLISHED_MARBLE_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.POLISHED_MARBLE_STAIRS)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_TRAPDOOR, 4)
                .pattern("   ")
                .pattern(" ##")
                .pattern(" ##")
                .input('#', ModBlocks.POLISHED_MARBLE_BLOCK.asItem())
                .criterion(hasItem(ModBlocks.POLISHED_MARBLE_BLOCK.asItem()), InventoryChangedCriterion.Conditions.items(ModBlocks.POLISHED_MARBLE_BLOCK.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.POLISHED_MARBLE_TRAPDOOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.CALCITE, 9)
                .pattern("#G#")
                .pattern("G#G")
                .pattern("#G#")
                .input('#', Items.COBBLESTONE)
                .input('G', Items.GRAVEL)
                .criterion(hasItem(Items.GRAVEL), InventoryChangedCriterion.Conditions.items(Items.GRAVEL))
                .offerTo(exporter, new Identifier(getRecipeName(Items.CALCITE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_TILE, 24)
                .pattern("   ")
                .pattern("###")
                .pattern("###")
                .input('#', ModBlocks.POLISHED_MARBLE_BLOCK.asItem())
                .criterion(hasItem(ModBlocks.POLISHED_MARBLE_BLOCK.asItem()), InventoryChangedCriterion.Conditions.items(ModBlocks.POLISHED_MARBLE_BLOCK.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.POLISHED_MARBLE_BLOCK.asItem())));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_BEAM, 8)
                .pattern("   ")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', ModBlocks.POLISHED_MARBLE_BLOCK.asItem())
                .criterion(hasItem(ModBlocks.POLISHED_MARBLE_BLOCK.asItem()), InventoryChangedCriterion.Conditions.items(ModBlocks.POLISHED_MARBLE_BLOCK.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.POLISHED_MARBLE_BEAM.asItem())));
        // ======================
        // REDSTONE TOOLS
        // ======================
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.REDSTONE_PICKAXE, 1)
                .pattern("RRR")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Items.STICK)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(Items.REDSTONE), InventoryChangedCriterion.Conditions.items(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.REDSTONE_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.REDSTONE_AXE, 1)
                .pattern(" RR")
                .pattern(" #R")
                .pattern(" # ")
                .input('#', Items.STICK)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(Items.REDSTONE), InventoryChangedCriterion.Conditions.items(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.REDSTONE_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.REDSTONE_SHOVEL, 1)
                .pattern(" R ")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Items.STICK)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(Items.REDSTONE), InventoryChangedCriterion.Conditions.items(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.REDSTONE_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.REDSTONE_SWORD, 1)
                .pattern(" R ")
                .pattern(" R ")
                .pattern(" # ")
                .input('#', Items.STICK)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(Items.REDSTONE), InventoryChangedCriterion.Conditions.items(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.REDSTONE_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.REDSTONE_HOE, 1)
                .pattern(" RR")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Items.STICK)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(Items.REDSTONE), InventoryChangedCriterion.Conditions.items(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.REDSTONE_HOE)));
        // ======================
        // EMERALD TOOLS
        // ======================
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.EMERALD_PICKAXE, 1)
                .pattern("RRR")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Items.STICK)
                .input('R', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), InventoryChangedCriterion.Conditions.items(Items.EMERALD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.EMERALD_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.EMERALD_AXE, 1)
                .pattern(" RR")
                .pattern(" #R")
                .pattern(" # ")
                .input('#', Items.STICK)
                .input('R', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), InventoryChangedCriterion.Conditions.items(Items.EMERALD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.EMERALD_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.EMERALD_SHOVEL, 1)
                .pattern(" R ")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Items.STICK)
                .input('R', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), InventoryChangedCriterion.Conditions.items(Items.EMERALD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.EMERALD_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.EMERALD_SWORD, 1)
                .pattern(" R ")
                .pattern(" R ")
                .pattern(" # ")
                .input('#', Items.STICK)
                .input('R', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), InventoryChangedCriterion.Conditions.items(Items.EMERALD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.EMERALD_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.EMERALD_HOE, 1)
                .pattern(" RR")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Items.STICK)
                .input('R', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), InventoryChangedCriterion.Conditions.items(Items.EMERALD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.EMERALD_HOE)));
    }
}
