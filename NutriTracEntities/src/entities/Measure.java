package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.eclipse.persistence.jpa.config.Cascade;

@Entity
@Table(name = "measure")

@NamedQueries({ @NamedQuery(name = "Measure.getAllMeasures", query = "select m from Measure m")})

public class Measure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int measureId;
	
	@Column(name = "ndbno_id")
	private Integer food;
	
	@Column(name = "nutrient_id")
	private Integer nutrient;
	
	
	private String label;
	
	private double eqv;
	
	private double qty;
	
	private String value;
	
	
	public Measure () {}


	
	
	public int getMeasureId() {
		return measureId;
	}




	public Integer getNutrient() {
		return nutrient;
	}



	public void setNutrient(Integer nutrient) {
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

	public void setFood(Integer food) {
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
