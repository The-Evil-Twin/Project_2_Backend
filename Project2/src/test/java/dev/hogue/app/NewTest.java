package dev.hogue.app;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.hogue.entities.Ingredient;
import dev.hogue.entities.Instruction;
import dev.hogue.entities.Recipe;
import dev.hogue.entities.User;
import dev.hogue.service.IngredientService;
import dev.hogue.service.InstructionService;
import dev.hogue.service.RecipeService;
import dev.hogue.service.UserService;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(classes = dev.hogue.app.Project2Application.class)
@SpringBootTest
@Transactional
public class NewTest {

	@Autowired
	@Qualifier("RecipeServiceSpring")
	RecipeService rs;

	@Autowired
	@Qualifier("IngredientServiceSpring")
	IngredientService ingred;

	@Autowired
	@Qualifier("InstructionServiceSpring")
	InstructionService instru;

	@Autowired
	@Qualifier("UserServiceSpring")
	UserService us;

	public User user = new User("admintest", "passwordtest");
	public User user2 = new User("user2", "password2");
	public Recipe recipe = new Recipe();
	public Ingredient ingredient = new Ingredient();
	public Instruction instruction = new Instruction();

	@Test
	@Commit
	@Order(1)
	public void createUser() {
		System.out.println("step 1");
		us.createUser(user);
		us.createUser(user2);
	}



	@Test
	@Order(2)
	public void getAllUser() {
		System.out.println("step 2");
		us.getAllUsers();
	}


	@Test
	@Commit
	@Order(3)
	public void createRecipe() {
	System.out.println("step 3");
		recipe.setName("testing2");
		rs.createRecipe(recipe);
	}

	@Test
	@Commit
	@Order(4)
	public void createIngredient() {
		ingredient.setName("riceFake");
		ingred.createIngredient(ingredient);
		recipe.addIngredient(ingredient);
		System.out.println(recipe);
	}
	
	@Test
	@Commit
	@Order(5)
	public void creatingInstruction() {
		instruction.setDescription("faking the rice");
		instruction.setStepId(1);
		instru.createInstruction(instruction);
		recipe.addStep(instruction);
		System.out.println(recipe);
	}
	@Test
	@Commit
	@Order(6)
	public void updateuser() {
		user.addRecipe(recipe);
		user.setPassword("new password");
		us.update(user);
	}
	
	@Test
	@Commit
	@Order(7)
	public void deleteIngredient() {
		ingred.deleteIngredient(ingredient);
	}
	
	@Test
	@Commit
	@Order(8)
	public void deleteInstruction() {
		instru.deleteInstruction(instruction);
	}
	
	@Test
	@Commit
	@Order(9)
	public void testDdeleteRecipe() {
		rs.deleteRecipe(recipe);
	}

	@Test
	@Commit
	@Order(10)
	public void deleteUser() {
		us.deleteUser(user);
		us.deleteUser(user2);
	}

}
