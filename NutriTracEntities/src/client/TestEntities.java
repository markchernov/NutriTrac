package client;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import entities.Food;
import entities.Measure;
import entities.Nutrient;

public class TestEntities {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("NutriPU");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		
		//EntityTransaction et = em.getTransaction();
		//et.begin();
		
		//System.out.println(createFood());           // test create food

		
		
		System.out.println(getFoodById(1225));

		ArrayList<Food> myFoods = getAllFoods();

		for (Food food : myFoods) {
			System.out.println("My foods:  "+ food);
			
		}

		ArrayList<Nutrient> myNutrients = getAllNutrients();

		for (Nutrient n : myNutrients) {
			System.out.println("My nutrients:  " + n);
			
		}

		ArrayList<Measure> myMeasures = getAllMeasures();

		for (Measure m : myMeasures) {
			System.out.println("My measures:  " + m);
			
		}

		ArrayList<Food> myFoodsByNutrient = getAllFoodsByNuttrient("Water");

		for (Food food : myFoodsByNutrient) {
			System.out.println(food  + "  with Water");
			
		}
		
		
		Food f = new Food();
		f.setNdbno(4339);
		f.setName("My taco");
		
		
		//System.out.println(deleteFood(f));
		
		System.out.println(updateFood(f));

		
		//et.commit();
	} // end of main

	// ---------------------------- METHODS TO BE TESTED

	public static ArrayList<Food> getAllFoods() {

		ArrayList<Food> allFoods = new ArrayList<Food>(em.createNamedQuery("Food.getAllFoods").getResultList());

		return allFoods;

	}

	public static ArrayList<Nutrient> getAllNutrients() {

		ArrayList<Nutrient> allNutrients = new ArrayList<Nutrient>(em.createNamedQuery("Nutrient.getAllNutrients")
				.getResultList());

		return allNutrients;

	}

	public static ArrayList<Measure> getAllMeasures() {

		ArrayList<Measure> allMeasures = new ArrayList<Measure>(em.createNamedQuery("Measure.getAllMeasures")
				.getResultList());

		return allMeasures;

	}

	public static Food getFoodById(int ndbnoParameter) {

		Food food = em.find(Food.class, ndbnoParameter);

		return food;

	}

	public static Food updateFood(Food f) {

		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(f);
		//em.persist(f);    don't need persist because of duplicate key error , em.merge updates the database record
		
		et.commit();

		int ndbno = f.getNdbno();

		Food updatedFood = em.find(Food.class, ndbno);

		return updatedFood;

	}
	
	
	
	public static Food deleteFood(Food f) {

		Food fu = em.find(Food.class, f.getNdbno());
		
		EntityTransaction et = em.getTransaction();
		//et.begin();
		
		//em.merge(f);

		em.remove(fu);
		
		et.commit();

		return fu;

	}
	
	public static ArrayList<Food> getAllFoodsByNuttrient(String nutrient) {

		ArrayList<Food> allFoodsByNutrientName = new ArrayList<Food>(em.createNamedQuery("Food.getAllFoodsByNutrientName")
				.setParameter("nutrient", nutrient).getResultList());

		return allFoodsByNutrientName;

	}

	public static Food createFood() {

		EntityTransaction et = em.getTransaction();
		et.begin();

		Food fu = new Food();
		Measure myMeasure = new Measure();
		Measure myMeasure2 = new Measure();
		Nutrient myNutrient = new Nutrient();
		ArrayList<Measure> myListOfMeasures = new ArrayList<Measure>();
		ArrayList<Nutrient> myListOfNutrients = new ArrayList<Nutrient>();

		fu.setName("cake");
		fu.setNdbno(4332);

		myNutrient.setFood(fu.getNdbno());
		myNutrient.setName("Protein");
		myNutrient.setGroup("Proximates");
		myNutrient.setUnit("cup");
		myNutrient.setValue("0.234");
		myNutrient.setMeasures(myListOfMeasures);
		myNutrient.setNutrientId(207);

		// em.merge(myNutrient);
		// em.persist(myNutrient);

		/*
		 * Nutrient persistedNutrient = (Nutrient)
		 * em.createNamedQuery("Nutrient.getLastNutrientById").getSingleResult();
		 *  System.out.println("Persisted nutrient is: " + persistedNutrient);
		 *  Integer nutId= persistedNutrient.getId();
		 */

		/*
		 * Measure persistedMeasure = (Measure)
		 * em.createNamedQuery("Measure.getLastMeasureById").getSingleResult();
		 *  System.out.println("Persisted measure is: " + persistedMeasure);
		 *  Integer mesId= persistedMeasure.getId();
		 */

		// myMeasure.setMeasureId(mesId);
		myMeasure.setEqv(12.5);
		myMeasure.setFood(fu.getNdbno());
		myMeasure.setLabel("myLabel");
		//myMeasure.setNutrient(myNutrient.getId());
		myMeasure.setQty(5.5);
		myMeasure.setValue("0.045");

		myMeasure2.setEqv(22.5);
		myMeasure2.setFood(fu.getNdbno());
		myMeasure2.setLabel("myLabel2");
		//myMeasure2.setNutrient(myNutrient.getId());
		myMeasure2.setQty(6.6);
		myMeasure2.setValue("0.056");

		myListOfMeasures.add(myMeasure);
		myListOfMeasures.add(myMeasure2);

		myListOfNutrients.add(myNutrient);

		

		//fu.setMeasures(myListOfMeasures);
		//fu.setNutrients(myListOfNutrients);

		// Food f = em.find(Food.class, f.getNdbno())
	
		Food myfood = getFoodById(fu.getNdbno());

		System.out.println("Printing myfood which supposed to be null");
		System.out.println(myfood);

		if (myfood == null) {

			em.merge(fu);
			System.out.println("Merged!");
			System.out.println(fu);

			em.persist(fu);
			System.out.println("Persisted!");
			System.out.println(fu);

			et.commit();

			Food persistedFood = (Food) em.createNamedQuery("Food.getLastFoodById").getSingleResult();

			System.out.println("Print out persisted food");
			System.out.println(persistedFood);

			return persistedFood;

		}

		else
			return null;
	}

}
