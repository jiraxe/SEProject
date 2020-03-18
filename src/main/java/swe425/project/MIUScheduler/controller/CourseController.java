package swe425.project.MIUScheduler.controller;

import java.util.List;

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

import swe425.project.MIUScheduler.model.Course;
import swe425.project.MIUScheduler.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/course/list", method = RequestMethod.GET)
	public ModelAndView courses() {
		List<Course> courses = courseService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("courses", courses);
		modelAndView.addObject("size", courses.size());
		modelAndView.setViewName("course/list");
		return modelAndView;
	}

	@RequestMapping(value = "/course/new", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("course", new Course());
		return "course/new";
	}

	@RequestMapping(value = "/course/new", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("course") Course course, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "course/new";
		}
		course = courseService.save(course);
		return "redirect:/course/list";
	}

	@GetMapping(value = "/course/{courseId}")
	public String view(@PathVariable Integer courseId, Model model) {
		model.addAttribute("course", courseService.findOne(courseId));
		return "course/edit";
	}

	@RequestMapping(value = "/course/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Integer id, Model model) {
		courseService.delete(id);
		return "redirect:/course/list";
	}
}
