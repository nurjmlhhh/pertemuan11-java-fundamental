package com.pertemuan11.pertemuan11.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pertemuan11.pertemuan11.models.Food;
import com.pertemuan11.pertemuan11.services.FoodService;

@Controller
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/list-food")
    public String list(Model model) {
        List<Food> food = foodService.getAllFood();
        model.addAttribute("food", food);
        return "list-food";
    }

    @GetMapping("/add-food")
    public String addFood(Model model) {
        Food food = new Food();
        model.addAttribute("food", food);
        return "add-food";
    }

    @PostMapping("save-food")
    public String saveFood(@ModelAttribute("food") Food food) {
        foodService.save(food);
        return "redirect:/list-food";
    }

    @GetMapping("delete-food/{id}")
    public String deleteFood(@PathVariable(value = "id") Integer id) {
        foodService.deleteById(id);
        return "redirect:/list-food";
    }
}
