package dev.hogue.service;

import java.util.List;
import java.util.Set;

import dev.hogue.entities.Ingredient;
import dev.hogue.entities.Instruction;
import dev.hogue.entities.Recipe;

public interface RecipeService {
	

	/*
	 * DBService for Recipe
	 */
	Recipe saveRecipe(Recipe recipe);
	Recipe getRecipeById(int id);
	Recipe getRecipeByTitle(String name);
	//Recipe updateRecipe(Recipe recipe);
	Recipe addIngredient(Recipe recipe, Ingredient ingredient);
	Recipe addInstruction(Recipe recipe, Instruction instruction);
	List<Recipe> getAllRecipes();
	//Set<Recipe> getRecipesByIngredient(Ingredient ingredient);
	boolean deleteRecipe(Recipe recipe);
//	boolean recipeExists(Recipe recipe);
	


}
