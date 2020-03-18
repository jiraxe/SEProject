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

import swe425.project.MIUScheduler.model.Admin;
import swe425.project.MIUScheduler.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/admin/list", method = RequestMethod.GET)
	public ModelAndView admins() {
		List<Admin> admins = adminService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("admins", admins);
		modelAndView.addObject("size", admins.size());
		modelAndView.setViewName("admin/list");
		return modelAndView;
	}

	@RequestMapping(value = "/admin/new", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("admin", new Admin());
		return "admin/new";
	}

	@RequestMapping(value = "/admin/new", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("admin") Admin admin, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "admin/new";
		}
		admin = adminService.save(admin);
		return "redirect:/admin/list";
	}

	@GetMapping(value = "/admin/{adminId}")
	public String view(@PathVariable Long adminId, Model model) {
		model.addAttribute("admin", adminService.findOne(adminId));
		return "admin/edit";
	}

	@RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model) {
		adminService.delete(id);
		return "redirect:/admin/list";
	}
}
