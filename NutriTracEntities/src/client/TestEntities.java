package client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import entities.Food;
import entities.Measure;
import entities.Nutrient;

public class TestEntities {
	
	

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("NutriPU");
	static EntityManager em = emf.createEntityManager();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		List<Food> myFoods = getAllFoods(); 
		
		for (Food food : myFoods) {
			System.out.println(food);
			System.out.println(food.getName());
			System.out.println(food.getMeasures());
			System.out.println(food.getNutrients());
		}
		
        List<Nutrient> myNutrients = getAllNutrients(); 
		
		for (Nutrient n : myNutrients) {
			System.out.println(n);
			System.out.println(n.getName());
			System.out.println(n.getMeasures());
			System.out.println(n.getGroup());
		}
		
       List<Measure> myMeasures = getAllMeasures(); 
		
		for (Measure m : myMeasures) {
			System.out.println(m);
			System.out.println(m.getLabel());
			System.out.println(m.getNutrient());
			System.out.println(m.getValue());
		}
		
		
	   CriteriaQuery<Food> cq = em.getCriteriaBuilder().createQuery(Food.class);
       cq.select(cq.from(Food.class));
       List<Food> foods = em.createQuery(cq).getResultList();
       for(Food food : foods) {
           System.out.println(food.getName());
           System.out.println(food.getNutrients());
           System.out.println(food.getMeasures());
}
		
		
		
		
		
	}

	public static List<Food> getAllFoods() {

			List<Food> allFoods = em.createNamedQuery("Food.getAllFoods").getResultList();

			return allFoods;

		}
		
	public static List<Nutrient> getAllNutrients() {

		List<Nutrient> allNutrients = em.createNamedQuery("Nutrient.getAllNutrients").getResultList();

		return allNutrients;

	}
	public static List<Measure> getAllMeasures() {

		List<Measure> allMeasures = em.createNamedQuery("Measure.getAllMeasures").getResultList();

		return allMeasures;

	}

}
