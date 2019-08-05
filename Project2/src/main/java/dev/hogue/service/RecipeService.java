package dev.hogue.service;

import java.util.Set;

import dev.hogue.entities.Recipe;

public interface RecipeService {
	

	/*
	 * DBService for Recipe
	 */
	Recipe createRecipe(Recipe recipe);
	Recipe getRecipeById(int id);
	Recipe getRecipeByName(String name);
	Recipe updateRecipe(Recipe recipe);
	
	Set<Recipe> getAllRecipes();
	boolean deleteRecipe(Recipe recipe);
	


}
