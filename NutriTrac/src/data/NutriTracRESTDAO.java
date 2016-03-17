package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import entities.Food;
import entities.Measure;
import entities.Nutrient;


@Transactional

public class NutriTracRESTDAO {

	@PersistenceContext

	private EntityManager em;
	
	
	
	
	
	
	
	
	// ------------ FOOD
	
	public Food getFoodById(String ndbnoParameter) {

		int ndbno = Integer.parseInt(ndbnoParameter.trim());

		Food food = em.find(Food.class, ndbno);

		System.out.println(food);

		return food;

	}
	
	public List<Food> getAllFoodsByName (String nameParameter) {

		String name = nameParameter.trim();

		List<Food> getAllFoodsByName = em.createNamedQuery("Food.getAllFoodsByName").setParameter("name", name).getResultList();

		return getAllFoodsByName;

	}
	
	
	

	public  List<Food> getAllFoods() {

		List<Food> allFoods = em.createNamedQuery("Food.getAllFoods").getResultList();

		return allFoods;

	}
	
	
	
	public Food createFood(Food f) {

		em.merge(f);

		em.persist(f);

		Food persistedFood = (Food) em.createNamedQuery("Food.getLastFoodById").getSingleResult();

		return persistedFood;

	}
	
	public Food updateFood(Food f) {

		em.merge(f);

		//em.persist(e);

		int ndbno = f.getNdbno();

		Food persistedFood = em.find(Food.class, ndbno);

		return persistedFood;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	//  ---------------------------------  NUTRIENT
	
	
	
	public Nutrient getNutrientById(String idParameter) {

		int id = Integer.parseInt(idParameter.trim());

		Nutrient nutrient = em.find(Nutrient.class, id);

		System.out.println(nutrient);

		return nutrient;

	}
	
	
   public  List<Nutrient> getAllNutrients() {

	List<Nutrient> allNutrients = em.createNamedQuery("Nutrient.getAllNutrients").getResultList();

	return allNutrients;

}
   
   
   //------------------------------------ MEASURE
   
	public Measure getMeasureById(String measureIdParameter) {

		int measureId = Integer.parseInt(measureIdParameter.trim());

		Measure measure = em.find(Measure.class, measureId);

		System.out.println(measure);

		return measure;

	}
   
   public  List<Measure> getAllMeasures() {

	List<Measure> allMeasures = em.createNamedQuery("Measure.getAllMeasures").getResultList();

	return allMeasures;

}	
}