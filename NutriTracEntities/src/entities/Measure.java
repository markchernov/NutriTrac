package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
	private int measureId;
	
	@Column(name = "ndbno_id")
	private int food;
	
	@Column(name = "nutrient_id")
	private int nutrient;
	
	
	private String label;
	
	private double eqv;
	
	private double qty;
	
	private String value;
	
	
	public Measure () {}


	
	
	public int getMeasureId() {
		return measureId;
	}




	public void setMeasureId(int measureId) {
		this.measureId = measureId;
	}




	public Integer getNutrient() {
		return nutrient;
	}



	public void setNutrient(int nutrient) {
		this.nutrient = nutrient;
	}




	public int getId() {
		return measureId;
	}


	public Integer getFood() {
		return food;
	}


	public String getLabel() {
		return label;
	}


	public double getEqv() {
		return eqv;
	}


	public double getQty() {
		return qty;
	}


	public String getValue() {
		return value;
	}

	public void setFood(int food) {
		this.food = food;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public void setEqv(double eqv) {
		this.eqv = eqv;
	}


	public void setQty(double qty) {
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
