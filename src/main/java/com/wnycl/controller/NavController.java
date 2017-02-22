package com.wnycl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wnycl.service.PlayerService;
import com.wnycl.service.TeamService;
import com.wnycl.service.UserService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class NavController {

	@Autowired
	UserService userService;
	
	@Autowired
	TeamService teamService;
	
	@Autowired
	PlayerService playerService;
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "home";
	}
	
	@RequestMapping(value = {"/teamsList"}, method = RequestMethod.GET)
	public String teamsList(ModelMap model) {
		return "teamsList";
	}
	
	@RequestMapping(value = {"/playersList"}, method = RequestMethod.GET)
	public String playersList(ModelMap model) {
		return "playersList";
	}
	
	@RequestMapping(value = {"/AddTeam"}, method = RequestMethod.GET)
	public String addTeam(ModelMap model) {
		return "addTeam";
	}
	
	@RequestMapping(value = {"/toursList"}, method = RequestMethod.GET)
	public String toursList(ModelMap model) {
		return "tourList";
	}
	
	@RequestMapping(value = {"/tourInfo"}, method = RequestMethod.GET)
	public String tourInfo(ModelMap model) {
		return "tourInfo";
	}
	
	@RequestMapping(value = {"/AddTour"}, method = RequestMethod.GET)
	public String addTour(ModelMap model) {
		return "addTour";
	}
}