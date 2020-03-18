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

import swe425.project.MIUScheduler.model.Section;
import swe425.project.MIUScheduler.service.BlockService;
import swe425.project.MIUScheduler.service.CourseService;
import swe425.project.MIUScheduler.service.FacultyService;
import swe425.project.MIUScheduler.service.LocationService;
import swe425.project.MIUScheduler.service.SectionService;

@Controller
public class SectionController {

	@Autowired
	private SectionService sectionService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private BlockService blockService;
	
	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private LocationService locationService;

	@RequestMapping(value = "/section/list", method = RequestMethod.GET)
	public ModelAndView sections() {
		List<Section> sections = sectionService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("sections", sections);
		modelAndView.addObject("size", sections.size());
		
		modelAndView.setViewName("section/list");
		
		return modelAndView;
	}

	@RequestMapping(value = "/section/new", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("section", new Section());
		model.addAttribute("courses", courseService.findAll());
		model.addAttribute("blocks", blockService.findAll());
		model.addAttribute("faculties", facultyService.findAll());
		model.addAttribute("locations", locationService.findAll());
		return "section/new";
	}

	@RequestMapping(value = "/section/new", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("section") Section section, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "section/new";
		}
		section.setCapacity(50);
		section = sectionService.save(section);
		return "redirect:/section/list";
	}

	@GetMapping(value = "/section/{sectionId}")
	public ModelAndView view(@PathVariable Integer sectionId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("section", new Section());
		modelAndView.addObject("courses", courseService.findAll());
		modelAndView.addObject("blocks", blockService.findAll());
		modelAndView.addObject("faculties", facultyService.findAll());
		modelAndView.addObject("locations", locationService.findAll());
		modelAndView.addObject("section", sectionService.findOne(sectionId));
		modelAndView.setViewName("section/edit");
		return modelAndView;
	}

	@RequestMapping(value = "/section/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Integer id, Model model) {
		sectionService.delete(id);
		return "redirect:/section/list";
	}
}
