package com.pertemuan11.pertemuan11.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pertemuan11.pertemuan11.models.Drink;
import com.pertemuan11.pertemuan11.services.DrinkService;

@Controller
public class DrinkController {
    @Autowired
    private DrinkService drinkService;

    @GetMapping("/list-drink")
    public String list(Model model) {
        List<Drink> drink = drinkService.getAllDrink();
        model.addAttribute("drink", drink);
        return "list-drink";
    }

    @GetMapping("/add-drink")
    public String addDrink(Model model) {
        Drink drink = new Drink();
        model.addAttribute("drink", drink);
        return "add-drink";
    }

    @PostMapping("save-drink")
    public String saveDrink(@ModelAttribute("drink") Drink drink) {
        drinkService.save(drink);
        return "redirect:/list-drink";
    }

    
}
