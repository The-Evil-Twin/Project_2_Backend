package dev.hogue.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.hogue.entities.Recipe;
import dev.hogue.entities.User;
import dev.hogue.repositories.UserRepository;

@Component
@Service("UserServiceSpring")
public class UserServiceSpring implements UserService{

	@Autowired
	UserRepository repoUser;
	
	@Override
	public User createUser(User user) {
		if(userExists(user))
			return null;
		return repoUser.save(user);
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		//Search for the user, if it doesn't exist return null
		// TODO
		User temp = repoUser.save(user);
		return temp;
	}

	@Override
	public boolean deleteUser(User user) {
		repoUser.delete(user);
		return true;
	}

	@Override
	public Set<Recipe> getRecipesByUser(User user) {
		Iterable<Recipe> recipesIterable = repoUser.findByUsername(user.getUsername());
		Set<Recipe> recipeSet = new HashSet<Recipe>((Collection<? extends Recipe>) recipesIterable);
		return recipeSet;

	}
	
	@Override
	public List<User> getAllUsers(){
		Iterable<User> users = repoUser.findAll();
		List<User> userList = new ArrayList<User>((Collection<? extends User>) users);
		return userList;
	}

	@Override
	public User addRecipeToUser(User user, Recipe recipe) {
		user.addRecipe(recipe);
		return user;
	}

	@Override
	public User login(User user) {
		User temp = repoUser.findUserByUsername(user.getUsername());
		if(temp.getPassword() == user.getPassword()) {
			return temp;
		}
		return null;
	}
	
	@Override
	public boolean userExists(User user) {
		if(repoUser.findUserByUsername(user.getUsername()) == null) {
			return false;
		}
		return true;
	}
}




