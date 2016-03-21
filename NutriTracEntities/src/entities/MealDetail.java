package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
}
