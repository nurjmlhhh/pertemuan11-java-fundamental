package com.pertemuan11.pertemuan11.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pertemuan11.pertemuan11.models.Food;
import com.pertemuan11.pertemuan11.repositories.FoodRepository;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    public void save(Food food) {
        foodRepository.save(food);
    }

    public void deleteById(Integer id) {
        foodRepository.deleteById(id);
    }

    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    public Food findById(Integer id) {
        return foodRepository.findById(id).orElse(null);
    }
}
