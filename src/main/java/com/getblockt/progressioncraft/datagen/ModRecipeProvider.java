package com.getblockt.progressioncraft.datagen;

import com.getblockt.progressioncraft.block.ModBlocks;
import com.getblockt.progressioncraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.VanillaRecipeProvider;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.book.RecipeCategory;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_BRICKS, 4)
                .input('#', Blocks.SNOW_BLOCK)
                .pattern("##")
                .pattern("##")
                .criterion(hasItem(Items.SNOW_BLOCK), conditionsFromItem(Items.SNOW_BLOCK))
                .offerTo(exporter, getRecipeName(ModBlocks.SNOW_BRICKS));

        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_BRICK_SLAB, ModBlocks.SNOW_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_BRICK_SLAB, ModBlocks.SNOW_BRICKS, 2);

        createStairsRecipe(ModBlocks.SNOW_BRICK_STAIRS, Ingredient.ofItems(ModBlocks.SNOW_BRICKS))
                .criterion(hasItem(ModBlocks.SNOW_BRICKS), conditionsFromItem(ModBlocks.SNOW_BRICKS))
                .offerTo(exporter, getRecipeName(ModBlocks.SNOW_BRICK_STAIRS));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_BRICK_STAIRS, ModBlocks.SNOW_BRICKS);

        offerWallRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.SNOW_BRICK_WALL, ModBlocks.SNOW_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.SNOW_BRICK_WALL, ModBlocks.SNOW_BRICKS);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.STRAY_HELMET)
                .input('#', ModItems.STRAY_FABRIC)
                .pattern("###")
                .pattern("# #")
                .criterion(hasItem(ModItems.STRAY_FABRIC), conditionsFromItem(ModItems.STRAY_FABRIC))
                .offerTo(exporter, getRecipeName(ModItems.STRAY_HELMET));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.STRAY_CHESTPLATE)
                .input('#', ModItems.STRAY_FABRIC)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .criterion(hasItem(ModItems.STRAY_FABRIC), conditionsFromItem(ModItems.STRAY_FABRIC))
                .offerTo(exporter, getRecipeName(ModItems.STRAY_CHESTPLATE));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.STRAY_LEGGINGS)
                .input('#', ModItems.STRAY_FABRIC)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .criterion(hasItem(ModItems.STRAY_FABRIC), conditionsFromItem(ModItems.STRAY_FABRIC))
                .offerTo(exporter, getRecipeName(ModItems.STRAY_LEGGINGS));

        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WART_BLOCK, ModItems.WART);

        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Items.IRON_INGOT), RecipeCategory.MISC, ModItems.STEEL_INGOT, 0.8f, 100)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, getRecipeName(ModItems.STEEL_INGOT));
        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.STEEL_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_BLOCK, "steel_ingot_from_steel_block", "steel_ingot");
    }
}
