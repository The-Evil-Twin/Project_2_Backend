package dev.hogue.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.hogue.entities.Recipe;


@Repository
public interface RecipeRepository extends CrudRepository<Recipe,Integer>{
	Recipe findByName(String name);
	Recipe findById(int id);
	//Set<Recipe> findByNameInIngredients
}
