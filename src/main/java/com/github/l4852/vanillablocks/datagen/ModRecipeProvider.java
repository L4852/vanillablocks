package com.github.l4852.vanillablocks.datagen;

import com.github.l4852.vanillablocks.block.ModBlocks;
import com.github.l4852.vanillablocks.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
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
    //    private static final List<ItemConvertible> SMELTABLES = List.of();
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
//        offerSmelting(exporter, SMELTABLES, RecipeCategory.BUILDING_BLOCKS, ModItems.ITEM_NAME);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BLOCK, 4)
                .pattern("CIC")
                .pattern("I#I")
                .pattern("CIC")
                .input('C', Items.CALCITE)
                .input('I', Items.IRON_NUGGET)
                .input('#', Items.COBBLESTONE)
                .criterion(hasItem(Items.CALCITE), conditionsFromItem(Items.CALCITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.MARBLE_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUSH_STONE_WALL, 6)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Items.STONE)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.FLUSH_STONE_WALL)));
        // ======================
        // POLISHED MARBLE BLOCKS
        // ======================
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUSH_POLISHED_MARBLE_WALL, 6)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', ModBlocks.POLISHED_MARBLE_BLOCK.asItem())
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.FLUSH_POLISHED_MARBLE_WALL)));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_BLOCK, ModBlocks.MARBLE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUSH_POLISHED_MARBLE_WALL, ModBlocks.POLISHED_MARBLE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_STAIRS, ModBlocks.POLISHED_MARBLE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_SLAB, ModBlocks.POLISHED_MARBLE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_WALL, ModBlocks.POLISHED_MARBLE_BLOCK);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_SLAB, ModBlocks.POLISHED_MARBLE_BLOCK);
        offerPressurePlateRecipe(exporter, ModBlocks.POLISHED_MARBLE_PRESSURE_PLATE, ModBlocks.POLISHED_MARBLE_BLOCK);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_WALL, ModBlocks.POLISHED_MARBLE_BLOCK);

        createDoorRecipe(ModBlocks.POLISHED_MARBLE_DOOR, Ingredient.ofItems(ModBlocks.POLISHED_MARBLE_BLOCK))
                .criterion(hasItem(ModBlocks.POLISHED_MARBLE_BLOCK.asItem()), conditionsFromItem(ModBlocks.POLISHED_MARBLE_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.POLISHED_MARBLE_DOOR)));
        createStairsRecipe(ModBlocks.POLISHED_MARBLE_STAIRS, Ingredient.ofItems(ModBlocks.POLISHED_MARBLE_BLOCK))
                .criterion(hasItem(ModBlocks.POLISHED_MARBLE_BLOCK.asItem()), conditionsFromItem(ModBlocks.POLISHED_MARBLE_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.POLISHED_MARBLE_STAIRS)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_TRAPDOOR, 4)
                .pattern("   ")
                .pattern(" ##")
                .pattern(" ##")
                .input('#', ModBlocks.POLISHED_MARBLE_BLOCK.asItem())
                .criterion(hasItem(ModBlocks.POLISHED_MARBLE_BLOCK.asItem()), conditionsFromItem(ModBlocks.POLISHED_MARBLE_BLOCK.asItem()))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.POLISHED_MARBLE_TRAPDOOR)));
        // ======================
        // REDSTONE TOOLS
        // ======================
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.REDSTONE_PICKAXE, 1)
                .pattern("RRR")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Items.STICK)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.REDSTONE_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.REDSTONE_AXE, 1)
                .pattern(" RR")
                .pattern(" #R")
                .pattern(" # ")
                .input('#', Items.STICK)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.REDSTONE_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.REDSTONE_SHOVEL, 1)
                .pattern(" R ")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Items.STICK)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.REDSTONE_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.REDSTONE_SWORD, 1)
                .pattern(" R ")
                .pattern(" R ")
                .pattern(" # ")
                .input('#', Items.STICK)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.REDSTONE_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.REDSTONE_HOE, 1)
                .pattern(" RR")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Items.STICK)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
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
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.EMERALD_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.EMERALD_AXE, 1)
                .pattern(" RR")
                .pattern(" #R")
                .pattern(" # ")
                .input('#', Items.STICK)
                .input('R', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.EMERALD_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.EMERALD_SHOVEL, 1)
                .pattern(" R ")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Items.STICK)
                .input('R', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.EMERALD_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.EMERALD_SWORD, 1)
                .pattern(" R ")
                .pattern(" R ")
                .pattern(" # ")
                .input('#', Items.STICK)
                .input('R', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.EMERALD_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.EMERALD_HOE, 1)
                .pattern(" RR")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Items.STICK)
                .input('R', Items.EMERALD)
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.EMERALD_HOE)));
    }
}
