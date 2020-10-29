package com.spring.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ImplementaionPurpose {

	private String message = "Hello World";

	@GetMapping("/getMessage")
	public String getMessage(Model model) {
		model.addAttribute("message", message);
		return "show";
	}

	@GetMapping("/getMessage2")
	public ModelAndView getMessage() {

		ModelAndView mav = new ModelAndView();
		mav.addObject("message", message);
		mav.setViewName("show");

		return mav;
	}
}
