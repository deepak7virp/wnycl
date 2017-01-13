package com.wnycl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class NavController {

	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.addAttribute("displayTeams", true);
		return "home";
	}
}
