package dev.project2.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class User {
	
	private String username;
	private String password;
	private Set<Recipe> recipe = new HashSet<Recipe>();
	public User() {
		super();
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(String username, String password, Set<Recipe> recipe) {
		super();
		this.username = username;
		this.password = password;
		this.recipe = recipe;
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
	public Set<Recipe> getRecipe() {
		return recipe;
	}
	public void setRecipe(Set<Recipe> recipe) {
		this.recipe = recipe;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", recipe=" + recipe + "]";
	}

	
}
