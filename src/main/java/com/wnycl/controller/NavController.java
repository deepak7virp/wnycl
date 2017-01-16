package com.wnycl.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wnycl.model.Player;
import com.wnycl.model.Team;
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
	
	

}