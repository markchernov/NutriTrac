package controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@RestController
//@SessionAttributes("loginCred")
public class NutriController {


//		@Autowired
//		private Left2SpendDAO leftDAO;
		

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
