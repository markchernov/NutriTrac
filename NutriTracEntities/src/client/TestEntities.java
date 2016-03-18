package client;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
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

	
		System.out.println(createFood());
		
		
		
		//System.out.println(getFoodById("1225")); 
		
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
	public static Food getFoodById(String ndbnoParameter) {

		int ndbno = Integer.parseInt(ndbnoParameter.trim());

		Food food = em.find(Food.class, ndbno);

		System.out.println(food);

		return food;

	}

public static Food createFood() {
	
	EntityTransaction et = em.getTransaction();
	et.begin();

		
	Food fu = new Food();
	Measure myMeasure = new Measure();
	Nutrient myNutrient = new Nutrient();
	ArrayList<Measure> myListOfMeasures = new ArrayList<Measure>();
	ArrayList<Nutrient> myListOfNutrients = new ArrayList<Nutrient>();
	
	
	fu.setName("breakfast tea");
	fu.setNdbno(4330);
	
	myNutrient.setFood(fu.getNdbno());
	myNutrient.setName("Protein");
	myNutrient.setGroup("Proximates");
	myNutrient.setUnit("cup");
	myNutrient.setValue("0.234");
	myNutrient.setMeasures(myListOfMeasures);
	myNutrient.setNutrientId(207);
	
	
	//em.merge(myNutrient);
	//em.persist(myNutrient);
	
	
	//Nutrient persistedNutrient = (Nutrient) em.createNamedQuery("Nutrient.getLastNutrientById").getSingleResult();
	
	//Integer nutId= persistedNutrient.getId();
	
    /*Measure persistedMeasure = (Measure) em.createNamedQuery("Measure.getLastMeasureById").getSingleResult();
	
	Integer mesId= persistedMeasure.getId();*/
	
	//myMeasure.setMeasureId(mesId);
	myMeasure.setEqv(12.5);
	myMeasure.setFood(fu.getNdbno());
	myMeasure.setLabel("myLabel");
	//myMeasure.setNutrient(nutId);
	myMeasure.setQty(5.5);
	myMeasure.setValue("0.045");
	

	myListOfMeasures.add(myMeasure);
	myListOfNutrients.add(myNutrient);
		
	fu.setMeasures(myListOfMeasures);
	fu.setNutrients(myListOfNutrients);
	
		//Food f = em.find(Food.class, f.getNdbno())
		String ndbno = fu.getNdbno() + " ";
		Food myfood = getFoodById(ndbno);
		
	
 
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
		
		else return null;
	}
	
}
