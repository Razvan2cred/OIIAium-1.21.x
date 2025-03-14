package net.razvan.oiiamod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OIIA_PICKAXE.get())
                .pattern("OOO")
                .pattern("OdO")
                .pattern("OOO")
                .define('O', ModItems.OIIAITE.get())
                .define('d', Items.DIAMOND_PICKAXE)
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OIIA_AXE.get())
                .pattern("OOO")
                .pattern("OdO")
                .pattern("OOO")
                .define('O', ModItems.OIIAITE.get())
                .define('d', Items.DIAMOND_AXE)
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OIIA_SWORD.get())
                .pattern("OOO")
                .pattern("OdO")
                .pattern("OOO")
                .define('O', ModItems.OIIAITE.get())
                .define('d', Items.DIAMOND_SWORD)
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OIIA_SHOVEL.get())
                .pattern("OOO")
                .pattern("OdO")
                .pattern("OOO")
                .define('O', ModItems.OIIAITE.get())
                .define('d', Items.DIAMOND_SHOVEL)
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OIIA_HOE.get())
                .pattern("OOO")
                .pattern("OdO")
                .pattern("OOO")
                .define('O', ModItems.OIIAITE.get())
                .define('d', Items.DIAMOND_HOE)
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OIIA_HAMMER.get())
                .pattern("OOO")
                .pattern("OpO")
                .pattern("OOO")
                .define('O', Items.DIAMOND_PICKAXE)
                .define('p', ModItems.OIIA_PICKAXE.get())
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OIIAITE_HELMET.get())
                .pattern("OOO")
                .pattern("O O")
                .define('O', ModItems.OIIAITE.get())
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OIIAITE_CHESTPLATE.get())
                .pattern("O O")
                .pattern("OOO")
                .pattern("OOO")
                .define('O', ModItems.OIIAITE.get())
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OIIAITE_LEGGINGS.get())
                .pattern("OOO")
                .pattern("O O")
                .pattern("O O")
                .define('O', ModItems.OIIAITE.get())
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OIIAITE_BOOTS.get())
                .pattern("O O")
                .pattern("O O")
                .define('O', ModItems.OIIAITE.get())
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OIIAITE.get(), 9)
                .requires(ModBlocks.OIIAITE_BLOCK.get())
                .unlockedBy("has_oiiaite_block", has(ModBlocks.OIIAITE_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DEAD_CAT.get())
                .requires(ModItems.HALF_DEAD_CAT.get())
                .requires(Items.FLINT)
                .unlockedBy("has_half_dead_cat", has(ModItems.HALF_DEAD_CAT)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OIIAITE_HORSE_ARMOR.get())
                .requires(ModItems.OIIAITE.get())
                .requires(Items.IRON_BLOCK)
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COMPOUND_BOW.get())
                .requires(Items.BOW)
                .requires(ModItems.OIIAITE.get())
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OIIA_CAT_SPAWN_EGG.get())
                .requires(Items.EGG)
                .requires(ModItems.OIIAITE.get())
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE)).save(recipeOutput);

        oreSmelting(recipeOutput, OIIAITE_SMELTABLES, RecipeCategory.MISC, ModItems.OIIAITE.get(), 4f, 200, "oiiaite");
        oreBlasting(recipeOutput, OIIAITE_SMELTABLES, RecipeCategory.MISC, ModItems.OIIAITE.get(), 4f, 100, "oiiaite");

        stairBuilder(ModBlocks.OIIA_STAIRS.get(), Ingredient.of(ModItems.OIIAITE)).group("oiiaite")
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OIIA_SLAB.get(), ModItems.OIIAITE.get());
        buttonBuilder(ModBlocks.OIIA_BUTTON.get(), Ingredient.of(ModItems.OIIAITE.get())).group("oiiaite")
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE.get())).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.OIIA_PRESSURE_PLATE.get(), ModItems.OIIAITE.get());

        fenceBuilder(ModBlocks.OIIA_FENCE.get(), Ingredient.of(ModItems.OIIAITE.get())).group("oiiaite")
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.OIIA_FENCE_GATE.get(), Ingredient.of(ModItems.OIIAITE.get())).group("oiiaite")
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE.get())).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OIIA_WALL.get(), ModItems.OIIAITE.get());

        doorBuilder(ModBlocks.OIIA_DOOR.get(), Ingredient.of(ModItems.OIIAITE.get())).group("oiiaite")
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.OIIA_TRAPDOOR.get(), Ingredient.of(ModItems.OIIAITE.get())).group("oiiaite")
                .unlockedBy("has_oiiaite", has(ModItems.OIIAITE.get())).save(recipeOutput);

        //carne care se degateste!!!
    }
}
