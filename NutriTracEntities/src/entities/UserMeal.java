package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_meal")


public class UserMeal {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="meal_id")
	private Integer mealId;
	
	@Column(name ="user_email")
	private String email;

	@Column(name ="meal_date")
	private Date mealDate;
	@Column(name ="meal_category")
	private String mealCategory;
}
