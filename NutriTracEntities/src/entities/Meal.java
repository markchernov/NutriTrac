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

		@NamedQuery(name = "Meal.getMealsByCategory", query = "select m from Meal m where m.category = :category"),
		@NamedQuery(name = "Meal.getLastMealById", query = "select m from Meal m where m.mealid = (SELECT MAX(m2.mealid)from Meal m2)"),
		@NamedQuery(name = "Meal.getAllMeals", query = "select e from Meal e"),
		@NamedQuery(name = "Meal.getAllCategories", query = "select distinct m.name from Meal m") })

public class Meal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mealid")
	private int mealid;

	@Column(name = "name")
	private String name;
	private String description;
	private double amount;
	private Type category;
	private Date mealdate;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "mealid", referencedColumnName = "mealid")
	private ArrayList<Food> foods;

	public Meal() {
	}

	public Meal(int mealid, String name, String description, double amount, Type category, Date mealdate) {
		super();
		this.mealid = mealid;
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.category = category;
		this.mealdate = mealdate;
	}

	public enum Type {
		BREAKFAST, LUNCH, DINNER, SNACK
	}

}
