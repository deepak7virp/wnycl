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
public class AppController {

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
		model.addAttribute("teams", teamService.findAllTeams());
		return "home";
	}
	
	@RequestMapping(value = {"/listTeams"}, method = RequestMethod.GET)
	public String listTeams(ModelMap model) {
		model.addAttribute("teams", teamService.findAllTeams());
		model.addAttribute("displayTeams",true);
		return "home";
	}
	
	@RequestMapping(value="/addNewTeam", method=RequestMethod.POST, consumes="application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody String addNewTeam(@RequestBody String ab) throws JSONException{
		JSONObject json = new JSONObject(ab);
		String name = json.getString("name");
		String city = json.getString("city");
		Team team = new Team();
		team.setName(name);
		team.setCity(city);
		teamService.saveTeam(team);
		JSONObject ret = new JSONObject();
		ret.append("success", true);
		return ret.toString();
	}
	
	@RequestMapping(value="/teaminfo", method=RequestMethod.POST, consumes="application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody String getTeamInfo(@RequestBody String ab) throws JSONException{
		JSONObject json = new JSONObject(ab);
		Integer tid = Integer.parseInt(json.getString("tid"));
		Team team = teamService.findById(tid);
		List<Player> players = playerService.findPlayersByTeam(tid);
		JSONArray jsonArray = new JSONArray();
	    JSONObject teamJson = new JSONObject();
	    teamJson.put("teamname", team.getName());
	    jsonArray.put(teamJson);
		Iterator<Player> itr = players.iterator();
//	    while(itr.hasNext()){
//	    	Player p = (Player)itr.next();
//	    	JSONObject playerJson = new JSONObject();
//	    	playerJson.put("playerdid", p.getId());
//	    	playerJson.put("teamid", p.getTeam().getId());
//	    	playerJson.put("firstname", p.getFirstname());
//	    	playerJson.put("lastname", p.getLastname());
//	    	playerJson.put("dob", p.getDob());
//	    	playerJson.put("email", p.getEmail());
//	    	playerJson.put("phone", p.getPhone());
//	    	jsonArray.put(playerJson);
//	    }
	    return jsonArray.toString();
	}

}