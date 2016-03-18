package entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "food")


@NamedQueries({ @NamedQuery(name = "Food.getAllFoods", query = "select f from Food f"),
	@NamedQuery(name = "Food.getAllFoodsByName", query = "select f from Food f where f.name = :name"),
	@NamedQuery(name = "Food.getLastFoodById", query = "select f from Food f where f.ndbno = (SELECT MAX(f2.ndbno)from Food f2)")
})



public class Food {

	@Id
	private int ndbno;
    
    private String name;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "food")
	private ArrayList<Nutrient> nutrients;

	@OneToMany( fetch = FetchType.EAGER, mappedBy = "food")
	private ArrayList<Measure> measures;

	
	
	public Food() {
	}



	public int getNdbno() {
		return ndbno;
	}



	public String getName() {
		return name;
	}



	public ArrayList<Nutrient> getNutrients() {
		return nutrients;
	}



	public ArrayList<Measure> getMeasures() {
		return measures;
	}



	public void setNdbno(int ndbno) {
		this.ndbno = ndbno;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setNutrients(ArrayList<Nutrient> nutrients) {
		this.nutrients = nutrients;
	}



	public void setMeasures(ArrayList<Measure> measures) {
		this.measures = measures;
	}



	@Override
	public String toString() {
		return "Food [ndbno=" + ndbno + ", name=" + name + "]";
	}
	
	
	
	
	
}
