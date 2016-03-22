package data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import entities.Food;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="test-servlet.xml")

public class DaoTest {                         //  Integration testing for DAO JPQL methods
	
	@Autowired
	private NutriTracRESTDAO NutDAO;

	@Test
	   public void testAdd() {
	      String str= "Junit is working fine";
	      assertEquals("Junit is working fine",str);
	}
	
	
	@Test
	public void testgetFoodById() {


		System.out.println(" My NutDAO print out    " + NutDAO);

		Food myFood = NutDAO.getFoodById(1225);  // ARRANGE  ACT

		assertNotNull(myFood); // ASSERT
		
		System.out.println(" My Food print out    " + myFood);
		
		int myInt = new Integer(NutDAO.getFoodById(1225).getNdbno());

		assertEquals(myInt, 1225);   // ASSERT

		
	}
		
	@Test
	public void getAllFoods() {
		
		ArrayList<Food> myFoods = NutDAO.getAllFoods();
		assertNotNull(myFoods);

		
		
	}
		
	/*@Test
	public void getTenHighestEnergyCounts() {
		
		 ArrayList<Food> tenFoods = NutDAO.getTenHighestEnergyCounts();
		 ArrayList<Food> expectedFoods = new ArrayList<Food>();
		 assertNotNull(tenFoods);
		  
		 Food myLeche = NutDAO.getFoodById(1225); 
		 Food myIceCream = NutDAO.getFoodById(19095);
		 
		 expectedFoods.add(myLeche); 
		 expectedFoods.add(myIceCream);
		 

		

		  assertArrayEquals(expectedFoods.toArray(),tenFoods.toArray());

	}*/



	

}
