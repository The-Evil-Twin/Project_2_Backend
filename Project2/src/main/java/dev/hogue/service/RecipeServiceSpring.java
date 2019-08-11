package dev.hogue.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.hogue.entities.Ingredient;
import dev.hogue.entities.Instruction;
import dev.hogue.entities.Recipe;
import dev.hogue.repositories.RecipeRepository;



@Component
@Service("RecipeServiceSpring")
public class RecipeServiceSpring implements RecipeService{

	@Autowired
	RecipeRepository repoRecipe;

	@Override
	public Recipe saveRecipe(Recipe recipe) {
		return repoRecipe.save(recipe);
	}

	@Override
	public Recipe getRecipeById(int id) {
		Recipe recipe = repoRecipe.findById(id);
		return recipe;
	}

	@Override
	public Recipe getRecipeByName(String name) {
		Recipe recipe = repoRecipe.findByName(name);
		return recipe;
	}

//	@Override
//	public Recipe updateRecipe(Recipe recipe) {
//		return repoRecipe.save(recipe);
//	}

	@Override
	public Set<Recipe> getAllRecipes() {
		Iterable<Recipe> recipes = repoRecipe.findAll();
		Set<Recipe> recipeSet = new HashSet<Recipe>((Collection<? extends Recipe>) recipes);
		return recipeSet;
	}

	@Override
	public boolean deleteRecipe(Recipe recipe) {
		repoRecipe.delete(recipe);
		return true;
	}

	@Override
	public Recipe addIngredient(Recipe recipe, Ingredient ingredient) {
		recipe.addIngredient(ingredient);
		return recipe;
	}

	@Override
	public Recipe addInstruction(Recipe recipe, Instruction instruction) {
		recipe.addStep(instruction);
		return recipe;
	}

//	@Override
//	public boolean recipeExists(Recipe recipe) {
//		if(repoRecipe.findByName(recipe.getName()) == null ) {
//			return false;
//		}
//		return true;
//	}



	


}
