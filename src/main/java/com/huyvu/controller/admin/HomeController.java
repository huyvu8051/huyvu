package com.huyvu.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
	@GetMapping(value = "/quan-tri/trang-chu")
	public ModelAndView homePage() {
		return new ModelAndView("admin/home");
	}
	
}
