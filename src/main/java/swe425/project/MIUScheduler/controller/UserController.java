package swe425.project.MIUScheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import swe425.project.MIUScheduler.model.Admin;
import swe425.project.MIUScheduler.model.Faculty;
import swe425.project.MIUScheduler.model.Student;
import swe425.project.MIUScheduler.model.User;
import swe425.project.MIUScheduler.service.UserService;

import javax.servlet.http.HttpSession;


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
    public String verify(@ModelAttribute("login") User login, HttpSession session){
        User verifiedUser  = userService.verify(login);
        if(verifiedUser == null){
            return "login";
        }
        else if(verifiedUser instanceof Student){
            session.setAttribute("role","student");
        }
        else if(verifiedUser instanceof Faculty){
            session.setAttribute("role","faculty");
        }
        else{
            session.setAttribute("role","admin");
        }
        session.setAttribute("id", verifiedUser.getUserId());
        return "redirect:/home/index";

    }


}
