package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import data.NutriTracRESTDAO;
import entities.Food;
import entities.Measure;
import entities.Nutrient;

@RestController
//@SessionAttributes("loginCred")
public class NutriController {


		@Autowired
		private NutriTracRESTDAO NutDAO;
		

//		@ModelAttribute("loginCred")
//		public Object setPersonLoggedIn() {
//			Object logIn = new Object();
//			//LogInItems logIn = new LogInItems();
//			return logIn;
//		}
//		

		@ResponseBody
		@RequestMapping(path="ping")
		public String ping() {
			return "PONG";
		}
		
		@ResponseBody
		@RequestMapping(path="foodObj", method = RequestMethod.POST)
		public boolean addNewFoodObj(@RequestBody Food foodJson) {
			System.out.println(foodJson);
		
			System.out.println("Food Number : " + foodJson.getNdbno() +
							"\n Food Name : " + foodJson.getName() +
							"\n Food Nutrient 2 : " + foodJson.getNutrients().get(2) +
							"\n Nutrient Name : " + foodJson.getNutrients().get(2).getName() +
							"\n Nutrient NutrientID : " + foodJson.getNutrients().get(2).getNutrientId() +
							"\n Nutrient Unit : " + foodJson.getNutrients().get(2).getUnit() +
							"\n Nutrient Value : " + foodJson.getNutrients().get(2).getValue() +
							"\n Nutrient Measure : " + foodJson.getNutrients().get(2).getMeasures().get(0) + 
							"\n Measure Eqv : " + foodJson.getNutrients().get(2).getMeasures().get(0).getEqv() +
							"\n Measure Label: " + foodJson.getNutrients().get(2).getMeasures().get(0).getLabel() +
							"\n Measure Qty : " + foodJson.getNutrients().get(2).getMeasures().get(0).getQty() +
							"\n Measure Value : " + foodJson.getNutrients().get(2).getMeasures().get(0).getValue());
			System.out.println("xxxxxxxxxxxxx");
			System.out.println("nutrient food id " + foodJson.getNutrients().get(2).getFood());
			System.out.println("measures food id " + foodJson.getNutrients().get(2).getMeasures().get(0).getFood());
			System.out.println("nutrient nutrient id " + foodJson.getNutrients().get(2).getMeasures().get(0).getNutrient());
			System.out.println("nutrient id PK " + foodJson.getNutrients().get(2).getId());
			System.out.println("xxxxxxxxxxxxx");
		    Food ret = NutDAO.createFood(foodJson);
//			for (Nutrient nut : foodJson.getNutrients()) {
//				nut.setFood(foodJson);
//				for(Measure meas : nut.getMeasures()) {
//					meas.setFood(foodJson);
//				}
//			}
			System.out.println(ret);
			//TODO fix return to return true if object was successfully added to database...
			if(ret != null) {
				return true;
			} else return false;
//			return true;
		}

}
