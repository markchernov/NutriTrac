package data;

import java.util.ArrayList;
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

	// ------------ FOOD ----------------------------------------------------
	// ----GET-----

	public Food getFoodById(int ndbnoParameter) {

		Food food = em.find(Food.class, ndbnoParameter);

		return food;

	}

	public ArrayList<Food> getAllFoodsByName(String nameParameter) {

		String name = nameParameter.trim();

		ArrayList<Food> getAllFoodsByName =  new ArrayList<Food>(em.createNamedQuery("Food.getAllFoodsByName")
				.setParameter("name", name).getResultList());

		return getAllFoodsByName;

	}

	public ArrayList<Food> getAllFoods() {

		ArrayList<Food> allFoods = new ArrayList<Food>(em.createNamedQuery("Food.getAllFoods").getResultList());

		return allFoods;

	}

	public ArrayList<Food> getAllFoodsByNuttrient(String nutrient) {

		ArrayList<Food> allFoodsByNutrientName = new ArrayList<Food>(em.createNamedQuery("Food.getAllFoodsByNutrientName").setParameter("nutrient", nutrient).getResultList());

		return allFoodsByNutrientName;

	}
	
	
	
	
	// ----POST-----

	public Food createFood(Food f) {

		Food fu = em.find(Food.class, f.getNdbno());

		if (fu == null) {

			em.merge(f);

			em.persist(f);
			Food persistedFood = em.find(Food.class, f.getNdbno());

			return persistedFood;

		}

		else
			return null;

	}

	// ----PUT-----
	public Food updateFood(Food f) {

		em.merge(f);

		// em.persist(e);

		int ndbno = f.getNdbno();

		Food updatedFood = em.find(Food.class, ndbno);

		return updatedFood;

	}

	// ----DELETE-----
	public Food deleteFood(Food f) {

		Food fu = em.find(Food.class, f.getNdbno());

		em.remove(fu);

		return fu;

	}

	// --------------------------------- NUTRIENT -----------------------------------------------------
	
	// ----GET-----

	public Nutrient getNutrientById(int idParameter) {

		Nutrient nutrient = em.find(Nutrient.class, idParameter);

		return nutrient;

	}

	public ArrayList<Nutrient> getNutrientByNutrientGroupId(int GroupIdParameter) {
		
		ArrayList<Nutrient> allNutrientsByNutrientGroupId = new ArrayList<Nutrient>(em.createNamedQuery("Nutrient.getAllNutrientsByName")
				.getResultList());

		return allNutrientsByNutrientGroupId;

	}
	
	
	
	
	
	public ArrayList<Nutrient> getAllNutrients() {

		ArrayList<Nutrient> allNutrients = new ArrayList<Nutrient>(em.createNamedQuery("Nutrient.getAllNutrients")
				.getResultList());

		return allNutrients;

	}

	// ------------------------------------ MEASURE

	// ----GET-----

	public Measure getMeasureById(String measureIdParameter) {

		int measureId = Integer.parseInt(measureIdParameter.trim());

		Measure measure = em.find(Measure.class, measureId);

		System.out.println(measure);

		return measure;

	}

	public ArrayList<Measure> getAllMeasures() {

		ArrayList<Measure> allMeasures = new ArrayList<Measure>(em.createNamedQuery("Measure.getAllMeasures")
				.getResultList());

		return allMeasures;

	}

	// ----GET-----
	// ----GET-----
	// ----GET-----
}