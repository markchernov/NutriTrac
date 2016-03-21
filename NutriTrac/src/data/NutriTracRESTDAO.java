package data;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import entities.Food;
import entities.Measure;
import entities.Nutrient;

@Transactional

public class NutriTracRESTDAO {

	@PersistenceContext
    //@Autowired
	private EntityManager em;

	// ------------ FOOD ----------------------------------------------------
	// ----GET-----

	public Food getFoodById(int ndbnoParameter) {             

		Food food = em.find(Food.class, ndbnoParameter);
		System.out.print(food);
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

	public ArrayList<Food> getAllFoodsWithNutrientName(String nutrientName) {

		ArrayList<Food> allFoodsByNutrientName = new ArrayList<Food>(em.createNamedQuery("Food.getAllFoodsWithNutrientName").setParameter("nutrient", nutrientName).getResultList());

		return allFoodsByNutrientName;

	}
	
	public ArrayList<Food> getTenHighestEnergyCounts() {

		ArrayList<Food> tenHighestEnergyCounts = new ArrayList<Food>(em.createNamedQuery("Food.getTenHighestEnergyCounts").setMaxResults(10).getResultList());

		return tenHighestEnergyCounts;

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

	public ArrayList<Nutrient> getAllNutrientsByGroupId(int groupIdParameter) {
		
		ArrayList<Nutrient> allNutrientsByNutrientGroupId = new ArrayList<Nutrient>(em.createNamedQuery("Nutrient.getAllNutrientsByGroupId").setParameter("nutrientId", groupIdParameter)
				.getResultList());

		return allNutrientsByNutrientGroupId;

	}
	
    public ArrayList<Nutrient> getAllNutrientsByNutrientName(String nameParameter) {
		
		ArrayList<Nutrient> allNutrientsByNutrientName = new ArrayList<Nutrient>(em.createNamedQuery("Nutrient.getAllNutrientsByName").setParameter("name", nameParameter)
				.getResultList());

		return allNutrientsByNutrientName;

	}
	
	
	
	public ArrayList<Nutrient> getAllNutrients() {

		ArrayList<Nutrient> allNutrients = new ArrayList<Nutrient>(em.createNamedQuery("Nutrient.getAllNutrients")
				.getResultList());

		return allNutrients;

	}

	// ------------------------------------ MEASURE

	// ----GET-----

	public Measure getMeasureById(int measureIdParameter) {

		Measure myMeasure = em.find(Measure.class,measureIdParameter);

		return myMeasure;

	}

	public ArrayList<Measure> getAllMeasuresByLabel(String labelParameter) {

		ArrayList<Measure> allMeasuresByLabel = new ArrayList<Measure>(em.createNamedQuery("Measure.getAllMeasuresByLabel").setParameter("label", labelParameter)
				.getResultList());

		return allMeasuresByLabel;

	}
	
	
	public ArrayList<Measure> getAllMeasures() {

		ArrayList<Measure> allMeasures = new ArrayList<Measure>(em.createNamedQuery("Measure.getAllMeasures")
				.getResultList());

		return allMeasures;

	}

	// ----POST-----
	// ----PUT-----
	// ----DELETE-----
}