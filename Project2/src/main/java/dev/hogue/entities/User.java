package dev.hogue.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Recipe> recipes;

	public User() {
		super();
		recipes = new HashSet<Recipe>();
	}

	
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



	public User(String username, String password, Set<Recipe> recipes) {
		super();
		this.username = username;
		this.password = password;
		this.recipes = recipes;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Recipe> getRecipes() {
		return recipes;
	}
	
	public Set<Recipe> addRecipe(Recipe recipe){
		recipes.add(recipe);
		return recipes;
	}

	public void setRecipes(Set<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", recipes=" + recipes + "]";
	}
	
	

}
