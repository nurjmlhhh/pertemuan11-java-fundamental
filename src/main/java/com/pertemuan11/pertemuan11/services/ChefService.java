package com.pertemuan11.pertemuan11.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pertemuan11.pertemuan11.models.Chef;
import com.pertemuan11.pertemuan11.repositories.ChefRepository;
import com.pertemuan11.pertemuan11.models.Food;
import com.pertemuan11.pertemuan11.models.Drink;
import com.pertemuan11.pertemuan11.repositories.FoodRepository;
import com.pertemuan11.pertemuan11.repositories.DrinkRepository;

@Service
public class ChefService {
    @Autowired
    private ChefRepository chefRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private DrinkRepository drinkRepository;

    public void save(Chef chef) {
        chefRepository.save(chef);
    }

    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    public List<Drink> getAllDrink() {
        return drinkRepository.findAll();
    }

    public List<Chef> getAllChefs() { 
        return chefRepository.findAll();
    }
}
