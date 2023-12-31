package com.simplilearn.SportyShoes.controller;

import com.simplilearn.SportyShoes.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    LoginService service;

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String showLoginPage(ModelMap model)
    {
        return "login";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password)
    {
        boolean isValidUser=service.ValidateUser(name,password);

        if(!isValidUser)
        {
            model.put("errorMessage","Invalid Credentials");
            return "login";

        }
        model.put("name", name);
        model.put("password", password);

        return "redirect:/welcome";
    }

}
