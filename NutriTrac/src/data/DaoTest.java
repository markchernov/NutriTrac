package data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import entities.Food;
import entities.Meal;
import entities.MealDetail;
import entities.Measure;
import entities.User;
import entities.UserMeal;
import entities.UserMeal.Type;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "test-servlet.xml")

public class DaoTest { // Integration testing for DAO JPQL methods

	@Autowired
	private NutriTracRESTDAO NutDAO;

	@Test
	public void testAdd() {
		String str = "Junit is working fine";
		assertEquals("Junit is working fine", str);
	}

	@Test
	public void testgetFoodById() {

		System.out.println(" My NutDAO print out    " + NutDAO);

		Food myFood = NutDAO.getFoodById(1225); // ARRANGE ACT

		assertNotNull(myFood); // ASSERT

		System.out.println(" My Food print out    " + myFood);

		int myInt = new Integer(NutDAO.getFoodById(1225).getNdbno());

		assertEquals(myInt, 1225); // ASSERT

	}

	@Test
	public void testGetAllFoodsByChar() {

		ArrayList<Food> myFoods = NutDAO.getAllFoodsByChar("jelly");

		for (Food food : myFoods) {

			System.out.println(food);

		}

		assertNotNull(myFoods);
		assertNotNull(myFoods.get(0).getName());

	}

	@Test
	public void getTenHighestEnergyCounts() {

		ArrayList<Food> tenFoods = NutDAO.getTenHighestEnergyCounts();
		ArrayList<Food> expectedFoods = new ArrayList<Food>();
		assertNotNull(tenFoods);

		Food myLeche = NutDAO.getFoodById(1225);
		Food myIceCream = NutDAO.getFoodById(19095);

		expectedFoods.add(myLeche);
		expectedFoods.add(myIceCream);

		// assertArrayEquals(expectedFoods.toArray(),tenFoods.toArray());

	}

	
	 /*@Test public void testCreateUser() {
	 
	 User testUser = new User(); testUser.setEmail("yy@gmail.com");
	 testUser.setPassword("12345"); testUser.setFirstname("YY");
	 testUser.setLastname("M"); testUser.setBirthdate(new Date());
	 testUser.setSex("F");
	 testUser.setWeight(150);
	 testUser.setHeight(200);
	 testUser.setActive(1);
	  
	  
	 User createdUser = NutDAO.createUser(testUser);
	 
	 assertNotNull(createdUser); // ASSERT
	  
	 assertEquals(createdUser.getEmail(), "ss@gmail.com"); // ASSERT
	  
	  
	 
	  
	 User loggedInUser =
	 NutDAO.getUserLoginByEmailAndPassword("user@gmail.com", "12345"); //ARRANGE ACT
	 
	 assertNotNull(loggedInUser); // ASSERT
	 
	 System.out.println(" My loggedInUser print out    " + loggedInUser);
	  
	  
	  
	  assertEquals(loggedInUser.getPassword(), "12345"); // ASSERT
	  
	 
	 }*/
	 

//	@Test
//	public void testCreateMeal() {
//
//		Meal testMeal = new Meal();
//		
//		MealDetail testMealDetail = new MealDetail();
//		
//		
//		
//		testMealDetail.setMeal(testMeal);
//		
//		Food myFood = NutDAO.getFoodById(1225);
//		
//		testMealDetail.setMeasure(NutDAO.getMeasureById(13446));
//		
//		testMealDetail.setFood(myFood);
//		
//		
//		
//		testMeal.setName("breakfast burrito");
//		
//		ArrayList<MealDetail> mealDetails = new ArrayList<>();
//		mealDetails.add(testMealDetail);
//		
//		
//		
//		
//		testMeal.setMealDetails(mealDetails);
//
//		Meal createdMeal = NutDAO.createMeal(testMeal);
//		
//		User myUser = NutDAO.getUserByEmail("user@gmail.com");
//		
//		UserMeal myUserMeal = new UserMeal();
//		myUserMeal.setMeal(createdMeal);
//		myUserMeal.setMealDate(new Date());
//		myUserMeal.setUser(myUser);
//		myUserMeal.setMealCategory(Type.BREAKFAST);
//		
//		UserMeal createdUserMeal = NutDAO.createUserMeal(myUserMeal);
//		
//		assertNotNull(createdUserMeal); // ASSERT
//		assertEquals(createdUserMeal.getUser().getEmail(), "user@gmail.com"); // ASSERT
//		
//		assertNotNull(createdMeal); // ASSERT
//
//		assertEquals(createdMeal.getName(), "breakfast burrito"); // ASSERT
//
//		System.out.println("This is my meal:  " + createdMeal.getName());
//		System.out.println("This is my meal:  " + createdMeal.getMealId());
//		System.out.println("This is my meal details:  " + createdMeal.getMealDetails());
//		System.out.println("This is my UserMeal Date :  " + createdUserMeal.getMealDate());
//		System.out.println("This is my meal details:  " + createdUserMeal.getUser());
//	}

}
