package swe425.project.MIUScheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import swe425.project.MIUScheduler.model.Login;
import swe425.project.MIUScheduler.service.LoginService;


@Controller

public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping(value = {"/login","/"})
    public String displayLoginForm(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping(value = {"/login","/"})
    public String verify(@ModelAttribute("login")Login login){
        boolean verified  = loginService.verify(login);
        if(verified){
            return "redirect:/home/index";
        }else{
            return "login";
        }
    }


}
