package controllers;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import data.NutriTracRESTDAO;
import entities.Food;
import entities.Meal;
import entities.Measure;
import entities.Nutrient;
import entities.User;
import entities.UserMeal;

@RestController
// @SessionAttributes("loginCred")
public class NutriController {

	@Autowired
	private NutriTracRESTDAO NutDAO;

	// @ModelAttribute("loginCred")
	// public Object setPersonLoggedIn() {
	// Object logIn = new Object();
	// //LogInItems logIn = new LogInItems();
	// return logIn;
	// }
	//

	// -----------------------------------------REST
	// PATHs--------------------------------

	// ----TEST
	@ResponseBody
	@RequestMapping(path = "ping", method = RequestMethod.POST)
	public String ping() {
		return "PONG";
	}

	// --------------- FOOD ----------------------------------

	// ----GET ----
	@RequestMapping(path = "food/{foodid}", method = RequestMethod.GET)

	public Food getFoodById(@PathVariable("foodid") int foodId) {

		Food myFood = NutDAO.getFoodById(foodId);

		return myFood;
	}

	@RequestMapping(path = "foods", method = RequestMethod.GET)

	public ArrayList<Food> getAllFoods() {

		ArrayList<Food> allFoods = NutDAO.getAllFoods();

		return allFoods;
	}

	@RequestMapping(path = "foods/{foodname}", method = RequestMethod.GET)

	public ArrayList<Food> getAllFoodsByName(@PathVariable("foodname") String foodname) {

		ArrayList<Food> allFoodsByName = NutDAO.getAllFoodsByName(foodname);

		return allFoodsByName;
	}

	@RequestMapping(path = "foodsbychar/{char}", method = RequestMethod.GET)

	public ArrayList<Food> getAllFoodsByChar(@PathVariable("char") String character) {
		System.out.println(character);
		//char firstChar = character.charAt(0);
		
		String firstChar = character.substring(0, 1);
		String firstCharUpper = firstChar.toUpperCase();
		
		String theRest = character.substring(1);
		String theRestLower = theRest.toLowerCase();
		
		ArrayList<Food> allFoodsByChar = NutDAO.getAllFoodsByChar(firstCharUpper+theRestLower);

		return allFoodsByChar;
	}
	
	
	
	
	@RequestMapping(path = "foodswithnutrient/{nutrientname}", method = RequestMethod.GET)

	public ArrayList<Food> getAllFoodsWithNutrientName(@PathVariable("nutrientname") String nutrientname) {

		ArrayList<Food> allFoodsWithNutrientName = NutDAO.getAllFoodsWithNutrientName(nutrientname);

		return allFoodsWithNutrientName;
	}

	@RequestMapping(path = "tenhighestfoods", method = RequestMethod.GET)

	public ArrayList<Food> getTenHighestEnergyCounts() {

		ArrayList<Food> tenHighestEnergyCounts = NutDAO.getTenHighestEnergyCounts();

		return tenHighestEnergyCounts;
	}

	// ----POST ----

	@ResponseBody
	@RequestMapping(path = "foodObj", method = RequestMethod.POST)
	public boolean addNewFoodObj(@RequestBody Food foodJson) {
		System.out.println(foodJson);

		// System.out.println("Food Number : " + foodJson.getNdbno() + "\n Food
		// Name : " + foodJson.getName()
		// + "\n Food Nutrient 2 : " + foodJson.getNutrients().get(2) + "\n
		// Nutrient Name : "
		// + foodJson.getNutrients().get(2).getName() + "\n Nutrient NutrientID
		// : "
		// + foodJson.getNutrients().get(2).getNutrientId() + "\n Nutrient Unit
		// : "
		// + foodJson.getNutrients().get(2).getUnit() + "\n Nutrient Value : "
		// + foodJson.getNutrients().get(2).getValue() + "\n Nutrient Measure :
		// "
		// + foodJson.getNutrients().get(2).getMeasures().get(0) + "\n Measure
		// Eqv : "
		// + foodJson.getNutrients().get(2).getMeasures().get(0).getEqv() + "\n
		// Measure Label: "
		// + foodJson.getNutrients().get(2).getMeasures().get(0).getLabel() +
		// "\n Measure Qty : "
		// + foodJson.getNutrients().get(2).getMeasures().get(0).getQty() + "\n
		// Measure Value : "
		// + foodJson.getNutrients().get(2).getMeasures().get(0).getValue());
		// System.out.println("xxxxxxxxxxxxx");
		// System.out.println("nutrient food id " +
		// foodJson.getNutrients().get(2).getFood());
		// System.out.println("measures food id " +
		// foodJson.getNutrients().get(2).getMeasures().get(0).getFood());
		// System.out.println("nutrient nutrient id " +
		// foodJson.getNutrients().get(2).getMeasures().get(0).getNutrient());
		// System.out.println("nutrient id PK " +
		// foodJson.getNutrients().get(2).getId());
		// System.out.println("xxxxxxxxxxxxx");
		Food ret = NutDAO.createFood(foodJson);
		// for (Nutrient nut : foodJson.getNutrients()) {
		// nut.setFood(foodJson);
		// for(Measure meas : nut.getMeasures()) {
		// meas.setFood(foodJson);
		// }
		// }
		System.out.println(ret);
		// TODO fix return to return true if object was successfully added to
		// database...
		if (ret != null) {
			return true;
		} else
			return false;
		// return true;
	}

	// ----PUT ----

	@RequestMapping(path = "updatefood", method = RequestMethod.PUT)

	public Food updateFood(@RequestBody Food food) {

		Food updatedFood = NutDAO.updateFood(food);

		return updatedFood;
	}

	// ----DELETE ----

	@RequestMapping(path = "deletefood", method = RequestMethod.DELETE)

	public Food deleteFood(@RequestBody Food food) {

		Food deletedFood = NutDAO.deleteFood(food);

		return deletedFood;
	}

	// --------------- NUTRIENT ----------------------------------

	// ----GET ----

	@RequestMapping(path = "nutrientsbyid/{nutrientid}", method = RequestMethod.GET)

	public ArrayList<Nutrient> getAllNutrientsByGroupId(@PathVariable("nutrientid") int nutrientid) {

		ArrayList<Nutrient> nutrientsByGroupId = NutDAO.getAllNutrientsByGroupId(nutrientid);

		return nutrientsByGroupId;
	}

	@RequestMapping(path = "nutrientsbyname/{nutrientname}", method = RequestMethod.GET)

	public ArrayList<Nutrient> getAllNutrientsByNutrientName(@PathVariable("nutrientname") String nutrientname) {

		ArrayList<Nutrient> nutrientsByName = NutDAO.getAllNutrientsByNutrientName(nutrientname);

		return nutrientsByName;
	}

	// --------------- USER----------------------------------

	// ----GET ----

	@RequestMapping(path = "user/{email}", method = RequestMethod.GET)

	public User getUserByEmail(@PathVariable("email") String email) {

		User myUser = NutDAO.getUserByEmail(email);

		return myUser;
	}
	
	// ----POST ----
//	@ResponseBody
//	@RequestMapping(path = "ping", method = RequestMethod.POST)
//	public String ping() {
//		return "PONG";
//	}
	@ResponseBody
	@RequestMapping(path = "login", method = RequestMethod.POST)
	public User getUserLoginByEmailAndPassword(@RequestBody User jsonUser) {
//		System.out.println("IN LOGIN METHOD");
		System.out.println(jsonUser);
		 User myUser = NutDAO.getUserLoginByEmailAndPassword(jsonUser);
//		User myUser = new User();
//		myUser.setEmail("JEEEF");
		return myUser;
	}

	@RequestMapping(path = "createuser", method = RequestMethod.POST)

	public User createUser(@RequestBody User user) {
		
		User createdUser = NutDAO.createUser(user);

		return createdUser;
	}
	
	// --------------- USER MEAL ----------------------------------

		// ----GET ----
	
	@RequestMapping(path = "usermealbyid/{usermealid}", method = RequestMethod.GET)

	public UserMeal getUserMealById(@PathVariable("usermealid") int usermealid) {

		UserMeal myUserMeal = NutDAO.getUserMealById(usermealid);

		return myUserMeal;
	}
	
	@RequestMapping(path = "latestusermeal", method = RequestMethod.GET)

	public UserMeal getLatestUserMealById() {

		UserMeal latestUserMealById = NutDAO.getLatestUserMealById();

		return latestUserMealById;
	}
	
	@RequestMapping(path = "usermealbycategory/{category}", method = RequestMethod.GET)

	public ArrayList<UserMeal> getUserMealsByCategory(@PathVariable("category") String category) {

		ArrayList<UserMeal> userMealsByCategory = NutDAO.getUserMealsByCategory(category);

		return userMealsByCategory;
	}
	
	@RequestMapping(path = "allusermeals/", method = RequestMethod.GET)

	public ArrayList<UserMeal> getAllUserMeals() {

		ArrayList<UserMeal> allUserMeals = NutDAO.getAllUserMeals();

		return allUserMeals;
	}
	
	
	
	
	
	
	// --- POST ----
	
	@RequestMapping(path = "usermealsbyuser", method = RequestMethod.POST)

	public ArrayList <UserMeal> getAllUserMealsByUser(@RequestBody User user) {
		
		ArrayList <UserMeal> allUserMealsByUser = NutDAO.getAllUserMealsByUser(user);

		return allUserMealsByUser;
	}
	
	@RequestMapping(path = "usermealsbydate", method = RequestMethod.POST)

	public ArrayList <UserMeal> getAllMealsByDate(@RequestBody Date date) {
		
		ArrayList <UserMeal> allMealsByDate = NutDAO.getAllMealsByDate(date);

		return allMealsByDate;
	}
	
	
	// --------------- MEAL ----------------------------------

			// ----GET ----
	
	@RequestMapping(path = "meals/{char}", method = RequestMethod.GET)

	public ArrayList<Meal> getAllMealsByChar(@PathVariable("char") String character) {

		//char firstChar = character.charAt(0);
		
		
		
		ArrayList<Meal> allMealsByChar = NutDAO.getAllMealsByChar(character);

		return allMealsByChar ;
	}
	
	    // ---------POST ---------
	
	@RequestMapping(path = "createmeal", method = RequestMethod.POST)
    public Meal createMeal(@RequestBody Meal meal) {
		
		Meal createdMeal = NutDAO.createMeal(meal);

		return createdMeal;
	}
	
} // end of controller
