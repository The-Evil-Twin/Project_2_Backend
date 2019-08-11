package dev.hogue.ControllMocks;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.google.gson.Gson;

import dev.hogue.entities.Ingredient;
import dev.hogue.entities.Instruction;
import dev.hogue.entities.Recipe;
import dev.hogue.entities.User;
import dev.hogue.service.IngredientService;
import dev.hogue.service.InstructionService;
import dev.hogue.service.RecipeService;
import dev.hogue.service.UserService;

//@ExtendWith(SpringExtension.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//@ContextConfiguration(classes = dev.hogue.app.Project2Application.class)
//public class Mocks {
//	
//	@Autowired
//	MockMvc mockmvc;
//	
//	@MockBean
//	@Qualifier("RecipeServiceSpring")
//	RecipeService rs;
//
//	@MockBean
//	@Qualifier("IngredientServiceSpring")
//	IngredientService ingred;
//
//	@MockBean
//	@Qualifier("InstructionServiceSpring")
//	InstructionService instru;
//
//	@MockBean
//	@Qualifier("UserServiceSpring")
//	UserService us;
//	
//	@Test
//	public void addRecipe() throws Exception {
////		Recipe fake1 = new Recipe();
////		fake1.setName("testing");		
////		Instruction fake1step = new Instruction();
////		fake1step.setDescription("testing this shit out");
////		fake1.addStep(fake1step);
////		
////		
////		Ingredient fake1In = new Ingredient();
////		fake1In.setName("testing");
////		fake1In.setUsedIn(null);
////		fake1.addIngredient(fake1In);
////		
////		Gson gson = new Gson();
////		String json = gson.toJson(fake1);
////		System.out.println(json);
//		String json = "{\"id\":0,\"name\":\"testing\"}";
//		Gson gson = new Gson();
//		//creating an recipe object off of the json
//		Recipe recipe = gson.fromJson(json, Recipe.class);
//		Mockito.when(rs.saveRecipe(recipe)).thenReturn(recipe);
//		ResultActions ra = mockmvc.perform(post("/createRecipe").contentType(MediaType.APPLICATION_JSON_VALUE).content(json));
//		ra.andExpect(status().isOk());
//	}
//	
//	
//	@Test
//	public void adduser() throws Exception {
//		User fake = new User();
//		fake.setUsername("hui");
//		fake.setPassword("password");
//		Recipe fake1 = new Recipe();
//		fake1.setName("testing");		
//		Instruction fake1step = new Instruction();
//		fake1step.setDescription("testing this out");
//		fake1.addStep(fake1step);
//		Ingredient fake1In = new Ingredient();
//		fake1In.setName("testing");
//		fake1In.setUsedIn(null);
//		fake1.addIngredient(fake1In);
//		fake.addRecipe(fake1);
//		Gson gson = new Gson();
//		String json = gson.toJson(fake);
//		System.out.println(json);
////		String json = "{\"username\":\"hui\",\"password\":\"password\"}";
////		Gson gson = new Gson();
//		User user = gson.fromJson(json, User.class);
//		Mockito.when(us.createUser(user)).thenReturn(user);
//		ResultActions ra = mockmvc.perform(post("/createUser").contentType(MediaType.APPLICATION_JSON_VALUE).content(json));
//		ra.andExpect(status().isOk());
//	}
//	
//	@Test
//	public void updateUser() throws Exception {
//		User fake1 = new User();
//		fake1.setUsername("hui");
//		fake1.setPassword("oldpassword");
//		String json = "{\"username\":\"hui\",\"password\":\"password\"}";
//		Gson gson = new Gson();
//		User user = gson.fromJson(json, User.class);
//		Mockito.when(us.createUser(user)).thenReturn(user);
//		ResultActions ra = mockmvc.perform(put("/updateUser").contentType(MediaType.APPLICATION_JSON_VALUE).content(json));
//		ra.andExpect(status().isOk());
//	}
//	
//	@Test
//	public void deleteUser() throws Exception {
//		User fake = new User();
//		Recipe fake1 = new Recipe();
//		fake1.setName("deletingtest");
//		Ingredient ingredient = new Ingredient();
//		Instruction instruction = new Instruction();
//		ingredient.setName("fake ingredient");
//		instruction.setDescription("fake instruction");
//		instruction.setStepId(1);
//		fake1.addStep(instruction);
//		fake1.addIngredient(ingredient);
//		fake.addRecipe(fake1);
//		fake.setUsername("testing");
//		fake.setPassword("password");
//		Gson gson = new Gson();
//		String json = gson.toJson(fake);
//		us.createUser(fake);
//		Mockito.when(us.deleteUser(fake)).thenReturn(true);
//		ResultActions ra = mockmvc.perform(delete("/deleteUser").contentType(MediaType.APPLICATION_JSON_VALUE).content(json));
//		ra.andExpect(status().isOk());
//		
//	}
//	
//	@Test
//	public void deleteRecipe() throws Exception {
//		Recipe fake1 = new Recipe();
//		fake1.setName("deletingtest");
//		Ingredient ingredient = new Ingredient();
//		Instruction instruction = new Instruction();
//		ingredient.setName("fake ingredient");
//		instruction.setDescription("fake instruction");
//		instruction.setStepId(1);
//		fake1.addStep(instruction);
//		fake1.addIngredient(ingredient);
//		Gson gson = new Gson();
//		String json = gson.toJson(fake1);
//		rs.saveRecipe(fake1);
//		Mockito.when(rs.deleteRecipe(fake1)).thenReturn(true);
//		ResultActions ra = mockmvc.perform(delete("/deleteRecipe").contentType(MediaType.APPLICATION_JSON_VALUE).content(json));
//		ra.andExpect(status().isOk());
//	}
//	
//	
//	@Test
//	public void getAllRecipe() throws Exception {
//		Recipe fake1 = new Recipe();
//		Recipe fake2 = new Recipe();
//		fake1.setName("test1");
//		fake1.setIngredients(null);
//		fake1.setIngredients(null);
//		fake2.setName("test1");
//		fake2.setIngredients(null);
//		fake2.setIngredients(null);
//		Set<Recipe> recipes = new HashSet<Recipe>();
//		recipes.add(fake1);
//		recipes.add(fake2);
//		Gson gson = new Gson();
//		String json = gson.toJson(recipes);
//		System.out.println(json);
//		
//		Mockito.when(rs.getAllRecipes()).thenReturn(recipes);
//		ResultActions rs = mockmvc.perform(get("/recipes"));
//		rs.andExpect(status().isOk());
//		rs.andExpect(content().json(json));
//	}
//	
//	@Test
//	public void getAllIngredient() throws Exception {
//		Ingredient fake1 = new Ingredient();
//		fake1.setName("rice");
//		fake1.setUsedIn(null);
//		Ingredient fake2 = new Ingredient();
//		fake2.setName("rice2");
//		fake2.setUsedIn(null);
//		Set<Ingredient> ingredients = new HashSet<Ingredient>();
//		ingredients.add(fake1);
//		ingredients.add(fake2);
//		Gson gson = new Gson();
//		String json = gson.toJson(ingredients);
//		System.out.println(json);
//		
//		Mockito.when(ingred.getAllIngredient()).thenReturn(ingredients);
//		ResultActions rs = mockmvc.perform(get("/ingredients"));
//		rs.andExpect(status().isOk());
//		rs.andExpect(content().json(json));
//	}
//}
