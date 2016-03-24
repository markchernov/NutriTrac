package data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Ignore;
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

	 @Ignore
	 @Test public void testCreateUser() {
	 
	 User testUser = new User(); testUser.setEmail("jeffrey.leupp@gmail.com");
	 testUser.setPassword("rowcol"); testUser.setFirstname("Jeffrey");
	 testUser.setLastname("Leupp"); testUser.setBirthdate(new Date(2016, 3, 29));
	 testUser.setSex("M");
	 testUser.setWeight(210);
	 testUser.setHeight(183);
	 testUser.setActive(3);
	  
	  
	 User createdUser = NutDAO.createUser(testUser);
	 
	 assertNotNull(createdUser); // ASSERT
	  
	 assertEquals(createdUser.getEmail(), "jeffrey.leupp@gmail.com"); // ASSERT
	  
	  
	 
	  
	 User loggedInUser =
	 NutDAO.getUserLoginByEmailAndPassword(testUser); //ARRANGE ACT
	 
	 assertNotNull(loggedInUser); // ASSERT
	 
	 System.out.println(" My loggedInUser print out    " + loggedInUser);
	  
	  
	  
	  assertEquals(loggedInUser.getPassword(), "rowcol"); // ASSERT
	  
	 
	 }
	 

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

	 
	    @Test
		public void testCreateUserMeal() {
	
			UserMeal testUserMeal = new UserMeal();
			
			
			ArrayList <Meal> myMeal = NutDAO.getAllMealsByChar("burrito");
			
			testUserMeal.setMeal(myMeal.get(0));
			
			MealDetail testMealDetail = new MealDetail();
			
			
			testUserMeal.setMealDate(new Date(2016, 12, 15));
			
			User myUser = NutDAO.getUserByEmail("jeffrey.leupp@gmail.com");
			
			testUserMeal.setUser(myUser);
			
			testUserMeal.setMealCategory(Type.LUNCH);
			
	        UserMeal persistedUserMeal = NutDAO.createUserMeal(testUserMeal);
	        
	        assertNotNull(persistedUserMeal); // ASSERT
	        
	        System.out.println("This is my UserMeal:   " + persistedUserMeal.getId() + persistedUserMeal.getMealDate()+ 
	        		persistedUserMeal.getMealCategory() + persistedUserMeal.getUser() );
	        		
}
}
