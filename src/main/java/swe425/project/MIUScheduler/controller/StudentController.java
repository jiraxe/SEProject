package swe425.project.MIUScheduler.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import swe425.project.MIUScheduler.model.Block;
import swe425.project.MIUScheduler.model.Schedule;
import swe425.project.MIUScheduler.model.Section;
import swe425.project.MIUScheduler.model.Student;
import swe425.project.MIUScheduler.service.BlockService;
import swe425.project.MIUScheduler.service.SectionService;
import swe425.project.MIUScheduler.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	private StudentService studentService;
	private SectionService sectionService;
	private BlockService blockService;


	@Autowired
	public StudentController(StudentService studentService,SectionService sectionService, BlockService blockService) {
		this.studentService = studentService;
		this.sectionService = sectionService;
		this.blockService = blockService;
	}

	@GetMapping("/list")
	public ModelAndView students() {
		List<Student> students = studentService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("students", students);
		modelAndView.addObject("size", students.size());
		modelAndView.setViewName("student/list");

		return modelAndView;
	}

	@GetMapping("/new")
	public String create(Model model) {
		model.addAttribute("student", new Student());
		return "student/new";
	}

	@PostMapping("/new")
	public String edit(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {

		
		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "student/new";
		}

	    student = studentService.save(student);
		return "redirect:/student/list";
	}

	@GetMapping(value = "/{studentId}")
	public String view(@PathVariable Long studentId, Model model) {
		model.addAttribute("student", studentService.findOne(studentId));
		return "student/edit";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		studentService.delete(id);
		return "redirect:/student/list";

	}

	@GetMapping("/register/{studentId}")
	public String getScheduleForRegistration(@PathVariable Long studentId, Model model){
		Student student = studentService.findOne(studentId);
		if(student.getSections().size()>0)  return "register/list";
		List<Block> blocks = blockService.findAll();
		Schedule schedule = new Schedule();
		model.addAttribute("blocks", blocks);
		model.addAttribute("schedule", schedule);
		model.addAttribute("studentId",studentId);


		return "register/create";

	}

	@PostMapping(value = "/register/{studentId}")
	public String postScheduleForRegistration(@PathVariable Long studentId,@ModelAttribute("schedule")  Schedule schedule ,
					   BindingResult result, Model model)  {

		Student student = studentService.findOne(studentId);
		model.addAttribute("student",student);
		HashMap<String,List<Section>> results = this.studentService.register(student,schedule.getSections());

		if (results.get("prerequisite").size()>1) {
			model.addAttribute("prerequisites", results.get("prerequisite"));
			List<Block> blocks = blockService.findAll();
			model.addAttribute("blocks", blocks);
			model.addAttribute("schedule", new Schedule());
			model.addAttribute("studentId",studentId);

			return "register/create";
		}

		this.studentService.save(student);
		return "redirect:/student/register/list/"+studentId;
	}

	@GetMapping(value = "/register/list/{studentId}")
	public String showEnrolledSections(@PathVariable Long studentId,Model model,HttpSession session) {
		Student student = this.studentService.findOne(studentId);
		model.addAttribute("student",student);
		if (session.getAttribute("role") =="student")
		{
			model.addAttribute("studentrole",true);
		}
		else if (session.getAttribute("role") =="faculty"){
			model.addAttribute("facultyrole",true);
		}
		else{
			model.addAttribute("adminrole",true);
		}
	return "register/list";
	}
}
