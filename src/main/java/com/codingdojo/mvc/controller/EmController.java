package com.codingdojo.mvc.controller;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.mvc.services.EmService;

	

	@Controller
public class EmController {

	


		@Autowired
		private EmService emServ;

		@GetMapping("/")
		public String mainPage(Model model) {
			model.addAttribute("employees", emServ.findEmployees());
			model.addAttribute("mangers", emServ.findManagers());
			
			
			return "index.jsp";
		}


	
}
