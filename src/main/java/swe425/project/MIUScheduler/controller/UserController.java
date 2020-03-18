package swe425.project.MIUScheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import swe425.project.MIUScheduler.model.User;
import swe425.project.MIUScheduler.service.UserService;


@Controller

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = {"/login","/"})
    public String displayLoginForm(Model model) {
        model.addAttribute("login", new User());
        return "login";
    }

    @PostMapping(value = {"/login","/"})
    public String verify(@ModelAttribute("login") User login){
        boolean verified  = userService.verify(login);
        if(verified){
            return "redirect:/home/index";
        }else{
            return "login";
        }
    }


}
