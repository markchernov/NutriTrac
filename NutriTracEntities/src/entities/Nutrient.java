package entities;

import java.util.ArrayList;

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
@Table(name = "nutrient")

@NamedQueries({ @NamedQuery(name = "Nutrient.getAllNutrients", query = "select n from Nutrient n"),
	@NamedQuery(name = "Nutrient.getAllNutrientsByName", query = "select n from Nutrient n where n.name = :name"),
	@NamedQuery(name = "Nutrient.getLastNutrientById", query = "select n from Nutrient n where n.id = (SELECT MAX(n2.id)from Nutrient n2)")})

public class Nutrient {

	
	



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="ndbno")
	private int food;
	
	@Column(name="nutrient_id")
	private int nutrientId;
	
	private String name;
	
	@Column(name="grp")
	private String group;
	
	private String unit;
	
	private String value;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="nutrient_id",
	referencedColumnName="id")
	private ArrayList<Measure> measures;
	
	
	
	
	
	
	
	public Nutrient () {}



	public int getNutrientId() {
		return nutrientId;
	}


	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Measure> getMeasures() {
		return measures;
	}





	



	public void setNutrientId(int nutrientId) {
		this.nutrientId = nutrientId;
	}





	public void setMeasures(ArrayList<Measure> measures) {
		this.measures = measures;
	}





	public int getId() {
		return this.id;
	}


	public int getFood() {
		return food;
	}


	public String getName() {
		return name;
	}


	public String getGroup() {
		return group;
	}


	public String getUnit() {
		return unit;
	}


	public String getValue() {
		return value;
	}


	public void setFood(int food) {
		this.food = food;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setGroup(String group) {
		this.group = group;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public void setValue(String value) {
		this.value = value;
	}





	@Override
	public String toString() {
		return "Nutrient [id=" + id + ", food=" + food + ", nutrientId=" + nutrientId + ", name=" + name + ", group="
				+ group + ", unit=" + unit + ", value=" + value + "]";
	}

	
	

	
	
}	
	
	

