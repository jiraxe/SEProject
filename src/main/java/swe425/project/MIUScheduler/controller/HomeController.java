package swe425.project.MIUScheduler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {


	@RequestMapping(value="/home/index", method = RequestMethod.GET)
	public String home(Model model){
		model.addAttribute("admin",false);
		model.addAttribute("faculty",true);

		return "home/index";
	}
}
