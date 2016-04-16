package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "meal")

@NamedQueries({

		@NamedQuery(name = "Meal.getMealsByCategory", query = "select m from Meal m where m.name = :name"),
		@NamedQuery(name = "Meal.getLastMealById", query = "select m from Meal m where m.mealId = (SELECT MAX(m2.mealId)from Meal m2)"),
		@NamedQuery(name = "Meal.getAllMeals", query = "select e from Meal e"),
		@NamedQuery(name = "Meal.getAllCategories", query = "select distinct m.name from Meal m"),
		@NamedQuery(name = "Meal.getAllMealsByChar", query = "select m from Meal m where m.name LIKE :character")})

public class Meal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer mealId;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "meal", cascade = CascadeType.ALL)
	private List<UserMeal> userMeals = new ArrayList<UserMeal>();

	@OneToMany(mappedBy = "meal", cascade = CascadeType.ALL)
	private List<MealDetail> mealDetails = new ArrayList<MealDetail>();

	public Meal() {
	}

	public Integer getMealId() {
		return mealId;
	}

	public String getName() {
		return name;
	}

	public List<UserMeal> getUserMeals() {
		return userMeals;
	}

	public List<MealDetail> getMealDetails() {
		return mealDetails;
	}

	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUserMeals(ArrayList<UserMeal> userMeals) {
		this.userMeals = userMeals;
	}
	
	public void addUserMeal(UserMeal um) {
		if(userMeals.isEmpty()) {
			System.out.println("empty");
			userMeals.add(0, um);
		}
		this.userMeals.add(um);
	}
	
	public void addMealDetail(MealDetail md) {
		this.mealDetails.add(md);
	}

	public void setMealDetails(ArrayList<MealDetail> mealDetails) {
		this.mealDetails = mealDetails;
	}

	@Override
	public String toString() {
		return "Meal [mealId=" + mealId + ", name=" + name + ", userMeals=" + userMeals + ", mealDetails=" + mealDetails
				+ "]";
	}

	
	
}
