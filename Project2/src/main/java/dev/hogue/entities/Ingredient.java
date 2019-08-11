package dev.hogue.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ingredients")
public class Ingredient {
	
	@Id
	@Column(name="name")
	private String name;
	
	@JsonIgnore
	@ManyToMany(mappedBy ="ingredients",fetch = FetchType.LAZY)
	@Column(name="recipes")
	private Set<Recipe> usedIn;

	public Ingredient() {
		super();
		usedIn = new HashSet<Recipe>();
	}

	public Ingredient(String name, Set<Recipe> usedIn) {
		super();
		this.name = name;
		this.usedIn = usedIn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Recipe> getUsedIn() {
		return usedIn;
	}

	public void setUsedIn(Set<Recipe> usedIn) {
		this.usedIn = usedIn;
	}
	public void addRecipe(Recipe recipe) {
		usedIn.add(recipe);
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", usedIn=" + usedIn + "]";
	}
}
