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

	// ------------ FOOD

	public Food getFoodById(String ndbnoParameter) {

		int ndbno = Integer.parseInt(ndbnoParameter.trim());

		Food food = em.find(Food.class, ndbno);

		System.out.println(food);

		return food;

	}

	public ArrayList<Food> getAllFoodsByName(String nameParameter) {

		String name = nameParameter.trim();

		ArrayList<Food> getAllFoodsByName = (ArrayList<Food>) em.createNamedQuery("Food.getAllFoodsByName")
				.setParameter("name", name).getResultList();

		return getAllFoodsByName;

	}

	public ArrayList<Food> getAllFoods() {

		ArrayList<Food> allFoods = (ArrayList<Food>) em.createNamedQuery("Food.getAllFoods").getResultList();

		return allFoods;

	}

	public Food createFood(Food f) {

		System.out.println(f);

		Food fu = em.find(Food.class, f.getNdbno());

		if (fu == null) {
//			for (Nutrient nut : f.getNutrients()) {
//				em.persist(nut);
//				for (Measure meas : nut.getMeasures()) {
//					em.persist(meas);
//				}
//			}
			em.merge(f);

			em.persist(f);
			Food returned = em.find(Food.class, f.getNdbno());
			// Food persistedFood = (Food)
			// em.createNamedQuery("Food.getLastFoodById").getSingleResult();

			return returned;

		}

		else
			return null;

	}

	public Food updateFood(Food f) {

		em.merge(f);

		// em.persist(e);

		int ndbno = f.getNdbno();

		Food persistedFood = em.find(Food.class, ndbno);

		return persistedFood;

	}

	// --------------------------------- NUTRIENT

	public Nutrient getNutrientById(String idParameter) {

		int id = Integer.parseInt(idParameter.trim());

		Nutrient nutrient = em.find(Nutrient.class, id);

		System.out.println(nutrient);

		return nutrient;

	}

	public ArrayList<Nutrient> getAllNutrients() {

		ArrayList<Nutrient> allNutrients = (ArrayList<Nutrient>) em.createNamedQuery("Nutrient.getAllNutrients")
				.getResultList();

		return allNutrients;

	}

	// ------------------------------------ MEASURE

	public Measure getMeasureById(String measureIdParameter) {

		int measureId = Integer.parseInt(measureIdParameter.trim());

		Measure measure = em.find(Measure.class, measureId);

		System.out.println(measure);

		return measure;

	}

	public ArrayList<Measure> getAllMeasures() {

		ArrayList<Measure> allMeasures = (ArrayList<Measure>) em.createNamedQuery("Measure.getAllMeasures")
				.getResultList();

		return allMeasures;

	}
}