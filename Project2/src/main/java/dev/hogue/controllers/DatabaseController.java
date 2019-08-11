package dev.hogue.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import dev.hogue.entities.Ingredient;
import dev.hogue.entities.Recipe;
import dev.hogue.entities.User;
import dev.hogue.service.IngredientService;
import dev.hogue.service.InstructionService;
import dev.hogue.service.RecipeService;
import dev.hogue.service.UserService;

@RestController
@Controller
public class DatabaseController {

	@Autowired
	//@Qualifier("RecipeServiceSpring")
	RecipeService rs;

	@Autowired
	//@Qualifier("IngredientServiceSpring")
	IngredientService ingred;

	@Autowired
	//@Qualifier("InstructionServiceSpring")
	InstructionService instru;

	@Autowired
	//@Qualifier("UserServiceSpring")
	UserService us;

	//	@RequestMapping(value="/hello", method = RequestMethod.GET)
	//	public String sayHello() {
	//		return "Hello";
	//	}
	//	
	//	@RequestMapping(value = "/testRecipe", method = RequestMethod.GET)
	//	public Set<Recipe> getOneRecipe() {
	//		return rs.getAllRecipes();
	//	}
	//	
	//	@RequestMapping(value="/testingUser", method = RequestMethod.GET)
	//	public List<User> getallUsers(){
	//		return us.getAllUsers();
	//	}



	public static final String ACC_SID = "AC78d6b0c27a1fcd2ae8807954854bd0d6";
	public static final String AUTH_TOKEN = "19ab9fe0b1872eede5e87bee57f31c5e";

//	@RequestMapping(value="/keyTest", method = RequestMethod.GET)
//	public boolean testKey(){
//		Instruction instruction = new Instruction();
//		instruction.setDescription("Should not have been able to add this");
//		instru.createInstruction(instruction);
//		return false;
//	}

	@CrossOrigin
	@RequestMapping(value="/createRecipe", method = RequestMethod.POST, consumes={"application/json"})
	public boolean addRecipe(@RequestBody Recipe recipe) {
		System.out.println("GOOOOOOOOOOOOOOOOOOOOOOOTTT AAAAAAAAAAAA RESPPPPPPPPPPPPPPPONNNNNNNNNNSEEEEEEEE");
		Gson gson = new Gson();
		System.out.println(recipe);
		System.out.println(gson.toJson(recipe));
		rs.saveRecipe(recipe);
		return true;
	}
	@RequestMapping(value="/updateRecipe", method = RequestMethod.PUT)
	public Recipe updateRecipe(@RequestBody Recipe recipe) {
		return rs.saveRecipe(recipe);
	}
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public User userLogin(@RequestBody User user) {
		//Mmove most of this logic to the service
		User userData = us.login(user);
		if(userData == null)
			return null;
		return userData;
	}
	@RequestMapping(value="/ingredients", method = RequestMethod.GET)
	public Set<Ingredient> getIngredients(){
		for(Ingredient ingredient : ingred.getAllIngredient()) {
			System.out.println(ingredient.getName());
			for(Recipe recipe : ingredient.getUsedIn()) {
				System.out.println(recipe.getTitle());
			}
		}
		return ingred.getAllIngredient();
	}
	@CrossOrigin
	@RequestMapping(value="/recipes", method = RequestMethod.GET)
	public Set<Recipe> getRecipes(){
		return rs.getAllRecipes();
	}
	
	@RequestMapping(value="/createUser", method = RequestMethod.POST, consumes={"application/json"})
	public User createUser(@RequestBody User user) {
		return us.createUser(user);
	}
	@RequestMapping(value= "/updateUser", method = RequestMethod.PUT, consumes={"application/json"})
	public User updateUser(@RequestBody User user) {
		return us.update(user);
	}
	@RequestMapping(value ="/sendSMS", method = RequestMethod.GET)
	public void sendSMS() {
		Twilio.init(ACC_SID, AUTH_TOKEN);
		Message message = Message.creator(new PhoneNumber("+13106514137"),
				new PhoneNumber("+19893490856"), 
				"THIS IS A SMS FROM THE MASTER CONTROLLER, BOW DOWN AND BRING THE JOJO").create();

		System.out.println(message.getSid());
		return;
	}
	
	@RequestMapping(value="/deleteUser", method = RequestMethod.DELETE, consumes={"application/json"})
	public boolean removeUser(@RequestBody User user) {
		return us.deleteUser(user);
	}
	@RequestMapping(value="/deleteRecipe", method = RequestMethod.DELETE, consumes={"application/json"})
	public boolean removeRecipe(@RequestBody Recipe recipe) {
		return rs.deleteRecipe(recipe);
	}

}
