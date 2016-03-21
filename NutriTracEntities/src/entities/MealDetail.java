package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "meal_details")


public class MealDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idmeal_details")
	private Integer mealDetailId;
	
	@Column(name="meal_id")
	private Integer mealId;
	
	@Column(name="food_id")
	private Integer foodId;
	
	@Column(name="measure_id")
	private Integer measureId;
	
	@ManyToOne
	@JoinColumn(name ="food_id", referencedColumnName="ndbno")
	private Food food; 
	
	@ManyToOne
	@JoinColumn(name ="meal_id", referencedColumnName="id")
	private Meal meal;
	
	@ManyToOne
	@JoinColumn(name ="measure_id", referencedColumnName="id")
	private Measure measure;

	
	
	
	public MealDetail() {}
	
	
	public Integer getMealDetailId() {
		return mealDetailId;
	}

	public Integer getMealId() {
		return mealId;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public Integer getMeasureId() {
		return measureId;
	}

	public Food getFood() {
		return food;
	}

	public Meal getMeal() {
		return meal;
	}

	public Measure getMeasure() {
		return measure;
	}

	public void setMealDetailId(Integer mealDetailId) {
		this.mealDetailId = mealDetailId;
	}

	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public void setMeasureId(Integer measureId) {
		this.measureId = measureId;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public void setMeasure(Measure measure) {
		this.measure = measure;
	}
	
	
	
	
}
