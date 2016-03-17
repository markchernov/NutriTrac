package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import data.NutriTracRESTDAO;
import entities.Food;

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
			System.out.println("Food Number : " + foodJson.getNdbno() +
							"\n Food Name : " + foodJson.getName() +
							"\n Food Class : " + foodJson.getNutrients());
			
			//TODO fix return to return true if object was successfully added to database...
			return true;
		}

}
