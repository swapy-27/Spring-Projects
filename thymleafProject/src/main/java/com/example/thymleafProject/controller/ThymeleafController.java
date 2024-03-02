package com.example.thymleafProject.controller;

import com.example.thymleafProject.model.ColorForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf-template")
    public String getTemplate(Model model, @RequestParam(name = "name",defaultValue = "World") String name
    ){
        model.addAttribute("name",name);
        return "thymeLeaf";
    }
    @GetMapping("/drag-drop")
    public String dragDrop(Model model){


        return "drag-drop";
    }

    @GetMapping("/drop-down")
    public String dropDown(Model model){
        model.addAttribute("selectedColor",new ColorForm());
        return "drop-down";
    }

    @PostMapping("/submit")
    public String submitForm(Model model){
        return "redirect:/thymeleaf-template";
    }

}
