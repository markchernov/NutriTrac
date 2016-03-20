package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "users")

@NamedQueries({
	@NamedQuery(name="User.getUserByUsername", query="select u from User u where u.username = :username"),
	@NamedQuery(name="User.getUserByPassword", query="select u from User u where u.password = :password"),
	@NamedQuery(name="User.getUserbyUsernameAndPassword", query="select u from User u where u.username = :username and u.password = :password")})

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;

	private String firstname;
	private String lastname;
	private String email;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;
	
	
	public User() {};





}




