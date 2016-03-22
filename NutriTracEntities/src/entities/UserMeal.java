package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_meal")

public class UserMeal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "meal_date")
	private Date mealDate;

	@Column(name = "meal_category")
	private Type mealCategory;

	@ManyToOne
	@JoinColumn(name = "user_email", referencedColumnName = "email")
	private User user;

	@ManyToOne
	@JoinColumn(name = "meal_id", referencedColumnName = "id")
	private Meal meal;

	public UserMeal() {
	}

	public enum Type {
		BREAKFAST, LUNCH, DINNER, SNACK
	}

	public Integer getId() {
		return id;
	}

	public Date getMealDate() {
		return mealDate;
	}

	public Type getMealCategory() {
		return mealCategory;
	}

	public User getUser() {
		return user;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMealDate(Date mealDate) {
		this.mealDate = mealDate;
	}

	public void setMealCategory(Type mealCategory) {
		this.mealCategory = mealCategory;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

}
