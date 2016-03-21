package entities;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@Table(name = "user")

@NamedQueries({ @NamedQuery(name = "User.getUserByUsername", query = "select u from User u where u.email = :email"),
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

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private ArrayList<UserMeal> userMeals;

	public User() {
	}

	public String getEmail() {
		return email;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public String getPassword() {
		return password;
	}

	public String getSex() {
		return sex;
	}

	public ArrayList<UserMeal> getUserMeals() {
		return userMeals;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setUserMeals(ArrayList<UserMeal> userMeals) {
		this.userMeals = userMeals;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", firstname=" + firstname + ", lastname=" + lastname + ", birthdate="
				+ birthdate + ", password=" + password + ", sex=" + sex + ", userMeals=" + userMeals + "]";
	};

	
}
