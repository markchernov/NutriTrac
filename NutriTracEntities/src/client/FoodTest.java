package client;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entities.Food;

public class FoodTest {

	@Test
	   public void testAdd() {
	      String str= "Junit is working fine";
	      assertEquals("Junit is working fine",str);
	   }
	
	
	@Test
	public void test() {
		fail("Not many tests yet implemented");
	}
	
	
	
	@Test
	   public void testFood() {

		  
          Food food = new Food();        // ARRANGE
		
	      assertNotNull(food);             // test object 
	      
	      assertEquals(food.getNdbno(),0); // test initial empty id 
	      
	      food.setNdbno(1);              // ACT
	      assertEquals(food.getNdbno(),1);  // ASSERT           test set for id 
	
	      
	      
	}
	
	
	
	
/*	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}*/

	
}
