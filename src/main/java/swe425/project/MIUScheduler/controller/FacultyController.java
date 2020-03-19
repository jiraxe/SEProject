package swe425.project.MIUScheduler.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import swe425.project.MIUScheduler.model.Faculty;
import swe425.project.MIUScheduler.service.FacultyService;

@Controller
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	@RequestMapping(value = "/faculty/list", method = RequestMethod.GET)
	public ModelAndView faculties(HttpSession session) {
		List<Faculty> faculties = facultyService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("faculties", faculties);
		modelAndView.addObject("size", faculties.size());
		if (session.getAttribute("role") =="student")
		{
			modelAndView.addObject("student",true);
		}
		else if (session.getAttribute("role") =="faculty"){
			modelAndView.addObject("facultyrole",true);
		}
		else{
			modelAndView.addObject("admin",true);
		}
		modelAndView.setViewName("faculty/list");
		return modelAndView;
	}

	@RequestMapping(value = "/faculty/new", method = RequestMethod.GET )
	public String create(Model model) {
		model.addAttribute("faculty", new Faculty());
		return "faculty/new";
	}

	@RequestMapping(value = "/faculty/new", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("faculty") Faculty faculty, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "faculty/new";
		}
		faculty = facultyService.save(faculty);
		return "redirect:/faculty/list";
	}

	@GetMapping(value = "/faculty/{facultyId}")
	public String view(@PathVariable Long facultyId, Model model, HttpSession session) {
		if (session.getAttribute("role") =="student")
		{
			model.addAttribute("student",true);
		}
		else if (session.getAttribute("role") =="faculty"){
			model.addAttribute("facultyrole",true);
		}
		else{
			model.addAttribute("admin",true);
		}
		model.addAttribute("faculty", facultyService.findOne(facultyId));
		return "faculty/edit";
	}

	@RequestMapping(value = "/faculty/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model) {
		facultyService.delete(id);
		return "redirect:/faculty/list";
	}
}
