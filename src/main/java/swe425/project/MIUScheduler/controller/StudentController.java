package swe425.project.MIUScheduler.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import swe425.project.MIUScheduler.model.Section;
import swe425.project.MIUScheduler.model.Student;
import swe425.project.MIUScheduler.service.SectionService;
import swe425.project.MIUScheduler.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;
	private SectionService sectionService;

	@Autowired
	public StudentController(StudentService studentService,SectionService sectionService) {
		this.studentService = studentService;
		this.sectionService = sectionService;
	}

	@RequestMapping(value = "/student/list", method = RequestMethod.GET)
	public ModelAndView students() {
		List<Student> students = studentService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("students", students);
		modelAndView.addObject("size", students.size());
		modelAndView.setViewName("student/list");
		return modelAndView;
	}

	@RequestMapping(value = "/student/new", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("student", new Student());
		return "student/new";
	}

	@RequestMapping(value = "/student/new", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "student/new";
		}
		student = studentService.save(student);
		return "redirect:/student/list";
	}

	@GetMapping(value = "/student/{studentId}")
	public String view(@PathVariable Long studentId, Model model) {
		model.addAttribute("student", studentService.findOne(studentId));
		return "student/edit";
	}

	@RequestMapping(value = "/student/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model) {
		studentService.delete(id);
		return "redirect:/student/list";

	}

	@GetMapping(value="/register")
	public ModelAndView getScheduleForRegistration(){
		List<Section> sections = sectionService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("sections", sections);
		modelAndView.addObject("selected", new ArrayList<Section>());
		modelAndView.setViewName("student/register");
		return modelAndView;
	}
	@PostMapping(value = "/register")
	public String postScheduleForRegistration(@Valid @ModelAttribute("student") Student student,
					   BindingResult result, Model model)  {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "student/edit";
		}
		student = studentService.save(student);
		return "redirect:/student/list";
	}
}
