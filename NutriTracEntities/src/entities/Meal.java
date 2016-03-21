package entities;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
		@NamedQuery(name = "Meal.getAllCategories", query = "select distinct m.name from Meal m") })

public class Meal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int mealId;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "meal", cascade = CascadeType.ALL)
	private ArrayList<UserMeal> userMeals;

	@OneToMany(mappedBy = "meal", cascade = CascadeType.ALL)
	private ArrayList<MealDetail> mealDetails;

	public Meal() {
	}

	public int getMealId() {
		return mealId;
	}

	public String getName() {
		return name;
	}

	public ArrayList<UserMeal> getUserMeals() {
		return userMeals;
	}

	public ArrayList<MealDetail> getMealDetails() {
		return mealDetails;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUserMeals(ArrayList<UserMeal> userMeals) {
		this.userMeals = userMeals;
	}

	public void setMealDetails(ArrayList<MealDetail> mealDetails) {
		this.mealDetails = mealDetails;
	}

	
	
}
