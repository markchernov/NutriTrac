package entities;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_meal")

@NamedQueries({

	@NamedQuery(name = "UserMeal.getUserMealsByCategory", query = "select um from UserMeal um where um.mealCategory = :mealCategory"),
	@NamedQuery(name = "UserMeal.getLastUserMealById", query = "select um from UserMeal um where um.id = (SELECT MAX(um2.id)from UserMeal um2)"),
	@NamedQuery(name = "UserMeal.getAllUserMeals", query = "select um from UserMeal um"),
	@NamedQuery(name = "UserMeal.getAllUserMealsByUser", query = "select um from UserMeal um where um.user = :user"),
	@NamedQuery(name = "UserMeal.getAllMealsByDate", query = "select um from UserMeal um JOIN User u ON u.email= um.user where um.mealDate = :mealDate")})


public class UserMeal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "meal_date")
	private Date mealDate;

	@Column(name = "meal_category")
	private Type mealCategory;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_email", referencedColumnName = "email")
	private User user;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "meal_id") //, referencedColumnName = "id")
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

	@Override
	public String toString() {
		return "UserMeal [id=" + id + ", mealDate=" + mealDate + ", +  user=" + user.getEmail() +"]" + " " 
				+ meal.getName();
	
	}

	
	
}
