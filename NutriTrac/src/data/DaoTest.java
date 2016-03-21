package data;

import static org.junit.Assert.*;

import org.junit.Test;

import entities.Food;

public class DaoTest {



	@Test
	public void testDao() {

		NutriTracRESTDAO nutDao = new NutriTracRESTDAO(); // ARRANGE
		
		Food myFood = nutDao.getFoodById(1225);
		

		assertNotNull(myFood); // ACT // ASSERT

		//assertEquals(nutDao.getFoodById(1225).getNdbno(), 1225);

	}

}
