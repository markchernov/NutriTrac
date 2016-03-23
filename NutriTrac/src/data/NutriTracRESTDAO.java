package data;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import entities.Food;
import entities.Meal;
import entities.Measure;
import entities.Nutrient;
import entities.User;
import entities.UserMeal;

@Transactional

public class NutriTracRESTDAO {

	@PersistenceContext
	// @Autowired
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

		ArrayList<Food> getAllFoodsByName = new ArrayList<Food>(
				em.createNamedQuery("Food.getAllFoodsByName").setParameter("name", name).getResultList());

		return getAllFoodsByName;

	}

	public ArrayList<Food> getAllFoodsByChar(String character) {

		ArrayList<Food> getAllFoodsByChar = new ArrayList<Food>(em.createNamedQuery("Food.getAllFoodsByChar")
				.setParameter("character", "%" + character + "%").getResultList());

		return getAllFoodsByChar;

	}

	public ArrayList<Food> getAllFoods() {

		ArrayList<Food> allFoods = new ArrayList<Food>(em.createNamedQuery("Food.getAllFoods").getResultList());

		return allFoods;

	}

	public ArrayList<Food> getAllFoodsWithNutrientName(String nutrientName) {

		ArrayList<Food> allFoodsByNutrientName = new ArrayList<Food>(
				em.createNamedQuery("Food.getAllFoodsWithNutrientName").setParameter("nutrient", nutrientName)
						.getResultList());

		return allFoodsByNutrientName;

	}

	public ArrayList<Food> getTenHighestEnergyCounts() {

		ArrayList<Food> tenHighestEnergyCounts = new ArrayList<Food>(
				em.createNamedQuery("Food.getTenHighestEnergyCounts").setMaxResults(10).setParameter("energy", "energy")
						.getResultList());

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

	// --------------------------------- NUTRIENT
	// -----------------------------------------------------

	// ----GET-----

	public Nutrient getNutrientById(int idParameter) {

		Nutrient nutrient = em.find(Nutrient.class, idParameter);

		return nutrient;

	}

	public ArrayList<Nutrient> getAllNutrientsByGroupId(int groupIdParameter) {

		ArrayList<Nutrient> allNutrientsByNutrientGroupId = new ArrayList<Nutrient>(
				em.createNamedQuery("Nutrient.getAllNutrientsByGroupId").setParameter("nutrientId", groupIdParameter)
						.getResultList());

		return allNutrientsByNutrientGroupId;

	}

	public ArrayList<Nutrient> getAllNutrientsByNutrientName(String nameParameter) {

		ArrayList<Nutrient> allNutrientsByNutrientName = new ArrayList<Nutrient>(
				em.createNamedQuery("Nutrient.getAllNutrientsByName").setParameter("name", nameParameter)
						.getResultList());

		return allNutrientsByNutrientName;

	}

	public ArrayList<Nutrient> getAllNutrients() {

		ArrayList<Nutrient> allNutrients = new ArrayList<Nutrient>(
				em.createNamedQuery("Nutrient.getAllNutrients").getResultList());

		return allNutrients;

	}

	// ------------------------------------ MEASURE

	// ----GET-----

	public Measure getMeasureById(int measureIdParameter) {

		Measure myMeasure = em.find(Measure.class, measureIdParameter);

		return myMeasure;

	}

	public ArrayList<Measure> getAllMeasuresByLabel(String labelParameter) {

		ArrayList<Measure> allMeasuresByLabel = new ArrayList<Measure>(
				em.createNamedQuery("Measure.getAllMeasuresByLabel").setParameter("label", labelParameter)
						.getResultList());

		return allMeasuresByLabel;

	}

	public ArrayList<Measure> getAllMeasures() {

		ArrayList<Measure> allMeasures = new ArrayList<Measure>(
				em.createNamedQuery("Measure.getAllMeasures").getResultList());

		return allMeasures;

	}

	// ----POST-----
	// ----PUT-----
	// ----DELETE-----

	// ------------------------------------ USER

	// ----GET-----

	public User getUserByEmail(String email) {

		User myUser = em.find(User.class, email);

		return myUser;

	}

	public User getUserLoginByEmailAndPassword(String email, String password) {

		User myUser = em.find(User.class, email);

		if (myUser == null) {

			return null;

		}

		else if

		(!myUser.getPassword().equals(password) ) {

			return null;

		}

		else {

			return myUser;

		}
	}

	// ----POST-----

	public User createUser(User u) {

		User us = em.find(User.class, u.getEmail());

		if (us == null) {

			em.merge(u);

			em.persist(u);
			User persistedUser = em.find(User.class, u.getEmail());

			return persistedUser;

		}

		else
			return null;

	}

	// ------------------------------------ USER MEAL

	// ----GET-----

	public UserMeal getUserMealById(int id) {

		UserMeal myUserMeal = em.find(UserMeal.class, id);

		return myUserMeal;

	}
	
	public UserMeal getLatestUserMealById() {

		UserMeal userMeal = (UserMeal) em.createNamedQuery("UserMeal.getLatestUserMealById").getSingleResult();
				

		return userMeal;

	}
	
	
	
	
	public ArrayList<UserMeal> getUserMealsByCategory(String mealCategory) {

		ArrayList<UserMeal> getUserMealsByCategory = new ArrayList<UserMeal>(em.createNamedQuery("UserMeal.getUserMealsByCategory")
				.setParameter("mealCategory", mealCategory).getResultList());

		return getUserMealsByCategory;

	}
	
	public ArrayList<UserMeal> getAllUserMeals() {

		ArrayList<UserMeal> getAllUserMeals = new ArrayList<UserMeal>(em.createNamedQuery("UserMeal.getAllUserMeals").getResultList());

		return getAllUserMeals;

	}
	
	public ArrayList<UserMeal> getAllUserMealsByUser(User user) {

		ArrayList<UserMeal> getAllUserMealsByUser = new ArrayList<UserMeal>(em.createNamedQuery("UserMeal.getAllUserMealsByUser")
				.setParameter("user", user).getResultList());

		return getAllUserMealsByUser;

	}
	
	public ArrayList<UserMeal> getAllMealsByDate(Date date) {

		ArrayList<UserMeal> getAllMealsByDate = new ArrayList<UserMeal>(em.createNamedQuery("UserMeal.getAllMealsByDate")
				.setParameter("mealDate", date).getResultList());

		return getAllMealsByDate;

	}
	
	
	
	// --------- POST -------
	
	public UserMeal createUserMeal(UserMeal um) {

		em.merge(um);

		em.persist(um);

		UserMeal persistedUserMeal = (UserMeal) em.createNamedQuery("UserMeal.getLastUserMealById").getSingleResult();

		return persistedUserMeal;

	}
	
	
	// ------------ MEAL----------------------------------------------------
	// ----GET-----

	public ArrayList<Meal> getAllMealsByChar(String character) {

		ArrayList<Meal> getAllMealsByChar = new ArrayList<Meal>(em.createNamedQuery("Meal.getAllMealsByChar")
				.setParameter("character", "%" + character + "%").getResultList());

		return getAllMealsByChar;

	}

	// ----POST-----

	public Meal createMeal(Meal m) {

		em.merge(m);

		em.persist(m);

		Meal persistedMeal = (Meal) em.createNamedQuery("Meal.getLastMealById").getSingleResult();

		return persistedMeal;

	}

}// end of DAO