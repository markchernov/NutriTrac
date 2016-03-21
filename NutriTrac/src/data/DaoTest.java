package data;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import entities.Food;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/rest-servlet.xml"})

public class DaoTest {
	
	@Autowired
	private NutriTracRESTDAO NutDAO;

	/*
	 * EntityManagerFactory emf =
	 * Persistence.createEntityManagerFactory("NutriPU"); EntityManager em =
	 * emf.createEntityManager();
	 */

	/*
	 * @Autowired private NutriTracRESTDAO NutDAO;
	 */

	@Test
	public void testDao() {
//		NutriTracRESTDAO nutDAO = new NutriTracRESTDAO(); // ARRANGE

		System.out.println(" My NUtDAO print out    " + NutDAO);

		/*Food myFood = nutDAO.getFoodById(1225);

		assertNotNull(myFood); // ACT // ASSERT

		assertEquals(nutDAO.getFoodById(1225).getNdbno(), 1225);*/

		ArrayList<Food> myFoods = NutDAO.getAllFoods();
		assertNotNull(myFoods);

		/*
		 * ArrayList<Food> tenFoods = nutDao.getTenHighestEnergyCounts();
		 * ArrayList<Food> expectedFoods = new ArrayList();
		 * assertNotNull(tenFoods);
		 * 
		 * Food myLeche= nutDao.getFoodById(1225); Food myIceCream=
		 * nutDao.getFoodById(19095);
		 * 
		 * expectedFoods.add(myLeche); expectedFoods.add(myIceCream);
		 */

		/*
		 * Food[] arrayActual; Food[] arrayExpected;
		 * 
		 * arrayExpected[0] = myLeche; arrayExpected[1] = myIceCream;
		 */

		// assertArrayEquals(expectedFoods.toArray() ,tenFoods.toArray());

	}

}
