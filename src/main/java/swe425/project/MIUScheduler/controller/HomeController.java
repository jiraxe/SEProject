package swe425.project.MIUScheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import swe425.project.MIUScheduler.model.User;
import swe425.project.MIUScheduler.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	@RequestMapping(value="/home/index", method = RequestMethod.GET)
	public String home(Model model,HttpSession session){
		if (session.getAttribute("role") =="student")
		{
			model.addAttribute("student",true);
		}
		else if (session.getAttribute("role") =="faculty"){
			model.addAttribute("faculty",true);
		}
		else{
			model.addAttribute("admin",true);
		}
		return "home/index";
	}
}
