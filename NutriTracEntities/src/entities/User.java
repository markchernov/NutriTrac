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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@Table(name = "user")

@NamedQueries({
		@NamedQuery(name = "User.getUserByUsername", query = "select u from User u where u.email = :email"),
		@NamedQuery(name = "User.getUserByPassword", query = "select u from User u where u.password = :password"),
		@NamedQuery(name = "User.getUserbyUsernameAndPassword", query = "select u from User u where u.email = :email and u.password = :password") })

public class User {

	@Id
	private String email;

	private String firstname;
	
	private String lastname;

	private Date birthdate;

	private String password;

	private String sex;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="email", referencedColumnName="user_email")
	private ArrayList<UserMeal> userMeals;
	
	
	
	/*@ManyToMany
	@JoinTable(name = "user_meal", joinColumns = @JoinColumn (name = "user_email"), inverseJoinColumns = @JoinColumn(name = "meal_id"))
	private ArrayList<Meal> meals;*/
	
	

	public User() {
	};

	
}
