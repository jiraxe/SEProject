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

import swe425.project.MIUScheduler.model.Schedule;
import swe425.project.MIUScheduler.service.ScheduleService;
import swe425.project.MIUScheduler.service.SectionService;

@Controller
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private SectionService sectionService;

	@RequestMapping(value = "/schedule/list", method = RequestMethod.GET)
	public ModelAndView schedules() {
		List<Schedule> schedules = scheduleService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("schedules", schedules);
		modelAndView.addObject("size", schedules.size());
		modelAndView.addObject("sections", sectionService.findAll());
		modelAndView.setViewName("schedule/list");
		return modelAndView;
	}

	@RequestMapping(value = "/schedule/new", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("schedule", new Schedule());
		return "schedule/new";
	}

	@RequestMapping(value = "/schedule/new", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("schedule") Schedule schedule, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "schedule/new";
		}
		schedule = scheduleService.save(schedule);
		return "redirect:/schedule/list";
	}

	@GetMapping(value = "/schedule/{scheduleId}")
	public String view(@PathVariable Long scheduleId, Model model) {
		model.addAttribute("schedule", scheduleService.findOne(scheduleId));
		return "schedule/edit";
	}

	@RequestMapping(value = "/schedule/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model) {
		scheduleService.delete(id);
		return "redirect:/schedule/list";
	}
}
