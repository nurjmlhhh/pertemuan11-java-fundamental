package com.pertemuan11.pertemuan11.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pertemuan11.pertemuan11.models.Chef;
import com.pertemuan11.pertemuan11.services.ChefService;

import java.util.List;

@Controller
public class ChefController {
    @Autowired
    private ChefService chefService;

    @GetMapping("/add-chef")
    public String addChef(Model model) {
        Chef chef = new Chef();
        model.addAttribute("chef", chef);
        model.addAttribute("foodList", chefService.getAllFood());
        model.addAttribute("drinkList", chefService.getAllDrink());
        return "add-chef";
    }

    @PostMapping("/save-chef")
    public String saveChef(@ModelAttribute("chef") Chef chef) {
        chefService.save(chef);
        return "redirect:/list-chef"; 
    }

    @GetMapping("/list-chef")
    public String listChef(Model model) {
        List<Chef> chefs = chefService.getAllChefs(); 
        model.addAttribute("chefs", chefs);
        return "list-chef"; 
    }
}
