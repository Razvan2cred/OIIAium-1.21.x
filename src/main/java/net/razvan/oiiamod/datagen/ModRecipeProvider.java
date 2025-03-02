package net.razvan.oiiamod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.razvan.oiiamod.Oiia;
import net.razvan.oiiamod.block.ModBlocks;
import net.razvan.oiiamod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> OIIAITE_SMELTABLES = List.of(ModItems.RAW_OIIAITE,
                ModBlocks.OIIAITE_ORE, ModBlocks.OIIAITE_DEEPSLATE_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.OIIAITE_BLOCK.get())
                .pattern("OOO")
                .pattern("OOO")
                .pattern("OOO")
                .define('O', ModItems.OIIAITE.get())
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OIIAITE.get(), 9)
                .requires(ModBlocks.OIIAITE_BLOCK.get())
                .unlockedBy("has_oiiaite_block", has(ModBlocks.OIIAITE_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DEAD_CAT.get())
                .requires(ModItems.HALF_DEAD_CAT.get())
                .requires(Items.FLINT)
                .unlockedBy("has_half_dead_cat", has(ModItems.HALF_DEAD_CAT)).save(recipeOutput);

        oreSmelting(recipeOutput, OIIAITE_SMELTABLES, RecipeCategory.MISC, ModItems.OIIAITE.get(), 4f, 200, "oiiaite");
        oreBlasting(recipeOutput, OIIAITE_SMELTABLES, RecipeCategory.MISC, ModItems.OIIAITE.get(), 4f, 100, "oiiaite");

        stairBuilder(ModBlocks.OIIA_STAIRS.get(), Ingredient.of(ModItems.OIIAITE)).group("oiiaite")
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OIIA_SLAB.get(), ModItems.OIIAITE.get());
        buttonBuilder(ModBlocks.OIIA_BUTTON.get(), Ingredient.of(ModItems.OIIAITE.get())).group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.OIIAITE.get())).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.OIIA_PRESSURE_PLATE.get(), ModItems.OIIAITE.get());

        fenceBuilder(ModBlocks.OIIA_FENCE.get(), Ingredient.of(ModItems.OIIAITE.get())).group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.OIIAITE.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.OIIA_FENCE_GATE.get(), Ingredient.of(ModItems.OIIAITE.get())).group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.OIIAITE.get())).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OIIA_WALL.get(), ModItems.OIIAITE.get());

        doorBuilder(ModBlocks.OIIA_DOOR.get(), Ingredient.of(ModItems.OIIAITE.get())).group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.OIIAITE.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.OIIA_TRAPDOOR.get(), Ingredient.of(ModItems.OIIAITE.get())).group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.OIIAITE.get())).save(recipeOutput);
    }
}
