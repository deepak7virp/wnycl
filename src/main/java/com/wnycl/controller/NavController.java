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
		model.addAttribute("displayTeams",true);
		model.addAttribute("teams", teamService.findAllTeams());
		return "home";
	}
	
	@RequestMapping(value = {"/listTeams"}, method = RequestMethod.GET)
	public String listTeams(ModelMap model) {
		model.addAttribute("teams", teamService.findAllTeams());
		model.addAttribute("displayTeams",true);
		return "home";
	}
	
	
	@RequestMapping(value = {"/TeamsList"}, method = RequestMethod.GET)
	public String teamsList(ModelMap model) {
		return "teamList";
	}
	
	@RequestMapping(value = {"/playersList"}, method = RequestMethod.GET)
	public String playersList(ModelMap model) {
		return "playersList";
	}
	
	@RequestMapping(value = {"/AddTeam"}, method = RequestMethod.GET)
	public String addTeam(ModelMap model) {
		return "addTeam";
	}
}