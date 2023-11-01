package com.simplilearn.SportyShoes.controller;

import com.simplilearn.SportyShoes.model.Shoe;
import com.simplilearn.SportyShoes.service.ShoeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShoeController {
    @Autowired
    private ShoeServiceImpl shoeservice;

    //display list of shoes

    @GetMapping("/welcome")
    public String viewHomePage(Model model)
    {
        model.addAttribute("listShoes", shoeservice.getAllShoes());
        return "welcome";
    }

    @GetMapping("/addNewShoe")
    public String ShowNewEmployeeForm(Model model) {
        //create model attribute to bind form data
        Shoe shoes=new Shoe();
        model.addAttribute("shoe",shoes);
        return "shoenew";
    }

    @PostMapping("/saveShoe")
    public String saveShoe(@ModelAttribute("shoe") Shoe shoes)
    {
        //save shoe to database
        shoeservice.saveShoes(shoes);
        return "redirect:/welcome";
    }


    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value ="id" ) long id, Model model)
    {
        //get shoe from the service
        Shoe Shoes=shoeservice.getShoebyId(id);

        //set shoe as a model attribute to pre-populate the form
        model.addAttribute("shoes",Shoes);
        return "updatePage";
    }

    @GetMapping("/deleteShoe/{id}")
    public String deleteShoe(@PathVariable( value ="id" ) long id)
    {
        //call delete shoe method
        this.shoeservice.deleteShoeById(id);
        return "redirect:/welcome";
    }
}
