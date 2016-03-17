package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import data.NutriTracRESTDAO;

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

}
