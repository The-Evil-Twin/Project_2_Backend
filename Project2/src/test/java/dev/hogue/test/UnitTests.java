package dev.hogue.test;

import javax.transaction.Transactional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
public class UnitTests {

//	@Autowired
//	@Qualifier("RecipeServiceSpring")
//	RecipeService rs;
//
//	@Autowired
//	@Qualifier("IngredientServiceSpring")
//	IngredientService ingred;
//
//	@Autowired
//	@Qualifier("InstructionServiceSpring")
//	InstructionService instru;
//
//	@Autowired
//	@Qualifier("UserServiceSpring")
//	UserService us;
//
//	public static User user = new User();
//	public static User user2 = new User();
//	public static Recipe recipe = new Recipe();
//	public static Ingredient ingredient = new Ingredient();
//	public static Ingredient ingredient2 = new Ingredient();
//	public static Ingredient ingredient3 = new Ingredient();
//	public static Instruction instruction = new Instruction();
//
//	@Test
//	@Commit
//	@Order(1)
//	public void createUser() {
//		user.setUsername("cc");
//		user.setPassword("passsword");
//		System.out.println("step 1");
//		us.createUser(user);
//		user2.setUsername("cc");
//		user2.setPassword("newpassword");
//		System.out.println(us.createUser(user2));
//	}
//
//	@Test
//	@Order(2)
//	public void getAllUser() {
//		System.out.println("step 2");
//		us.getAllUsers();
//	}
//
//	@Test
//	@Commit
//	@Order(3)
//	public void createRecipe() {
//		System.out.println("step 3");
//		recipe.setName("WHAT THE HELL IS THIS");
//		recipe = rs.saveRecipe(recipe);
//		System.out.println(recipe.getId());
//	}
//
//	@Test
//	@Commit
//	@Order(4)
//	public void createIngredient() {
//		//ingredient.setName("1");
//		//ingredient.setUsedIn(null);
//		ingredient2.setName("222222222222");
//		ingredient2.addRecipe(recipe);
//		ingredient3.addRecipe(recipe);
//		ingredient3.setName("riceFakeAGAINAGAIN1111111");
//		//recipe.addIngredient(ingredient);
//		recipe.addIngredient(ingredient2);
//		recipe.addIngredient(ingredient3);
//		System.out.println(recipe.getId());
//		recipe = rs.saveRecipe(recipe);
//	}
//	
//	@Test
//	@Commit
//	@Order(5)
//	public void creatingInstruction() {
//		instruction.setDescription("faking the rice");
//		instruction.setStepId(1);
//		recipe.addStep(instruction);
//		System.out.println(recipe.getId());
//		//recipe = rs.updateRecipe(recipe);
//	}
//	
//	@Test
//	@Commit
//	@Order(6)
//	public void updateuser() {
//		System.out.println(recipe.getId());
//		rs.saveRecipe(recipe);
//		user.addRecipe(recipe);
//		user.setUsername("cc");
//		user.setPassword("new password");
//		us.update(user);
//	}
	
//	@Test
//	@Commit
//	@Order(7)
//	public void deleteIngredient() {
//		ingred.deleteIngredient(ingredient);
//	}
//	
//	@Test
//	@Commit
//	@Order(8)
//	public void deleteInstruction() {
//		instru.deleteInstruction(instruction);
//	}
//	
//	@Test
//	@Commit
//	@Order(9)
//	public void testDdeleteRecipe() {
//		rs.deleteRecipe(recipe);
//	}
//
//	@Test
//	@Commit
//	@Order(10)
//	public void deleteUser() {
//		us.deleteUser(user);
//		us.deleteUser(user2);
//	}

}
