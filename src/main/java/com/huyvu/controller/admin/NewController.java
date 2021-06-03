package com.huyvu.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("newControllerOfAdmin")
@RequestMapping("/quan-tri")
public class NewController {

	@GetMapping("/bai-viet")
	public ModelAndView newPage() {
		ModelAndView mav = new ModelAndView("admin/new");
		return mav;
	}
}
