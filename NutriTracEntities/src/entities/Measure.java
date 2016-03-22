package entities;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "measure")

@NamedQueries({ @NamedQuery(name = "Measure.getAllMeasures", query = "select m from Measure m"),
	@NamedQuery(name = "Measure.getAllMeasuresByLabel", query = "select m from Measure m where m.label = :label"),
	@NamedQuery(name = "Measure.getLastMeasureById", query = "select m from Measure m where m.measureId = (SELECT MAX(m2.measureId)from Measure m2)")})

public class Measure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer measureId;
	
	@Column(name = "ndbno_id")
	private Integer food;
	
	@Column(name = "nutrient_id")
	private Integer nutrient;
	
	
	private String label;
	
	private Double eqv;
	
	private Double qty;
	
	private String value;
	
	
	/*@OneToMany(mappedBy = "measure", cascade = CascadeType.ALL)
	private ArrayList<MealDetail> mealDetails;
	*/
	
	
	public Measure () {}


	
	
/*	public ArrayList<MealDetail> getMealDetails() {
		return mealDetails;
	}




	public void setMealDetails(ArrayList<MealDetail> mealDetails) {
		this.mealDetails = mealDetails;
	}*/




	public Integer getMeasureId() {
		return measureId;
	}




	public void setMeasureId(Integer measureId) {
		this.measureId = measureId;
	}




	public Integer getNutrient() {
		return nutrient;
	}



	public void setNutrient(Integer nutrient) {
		this.nutrient = nutrient;
	}




	public Integer getId() {
		return measureId;
	}


	public Integer getFood() {
		return food;
	}


	public String getLabel() {
		return label;
	}


	public Double getEqv() {
		return eqv;
	}


	public Double getQty() {
		return qty;
	}


	public String getValue() {
		return value;
	}

	public void setFood(Integer food) {
		this.food = food;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public void setEqv(Double eqv) {
		this.eqv = eqv;
	}


	public void setQty(Double qty) {
		this.qty = qty;
	}


	public void setValue(String value) {
		this.value = value;
	}




	@Override
	public String toString() {
		return "Measure [measureId=" + measureId + ", food=" + food + ", nutrient=" + nutrient + ", label=" + label
				+ ", eqv=" + eqv + ", qty=" + qty + ", value=" + value + "]";
	}

	
	
}
