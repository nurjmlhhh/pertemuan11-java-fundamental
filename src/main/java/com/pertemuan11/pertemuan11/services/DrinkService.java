package com.pertemuan11.pertemuan11.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pertemuan11.pertemuan11.models.Drink;
import com.pertemuan11.pertemuan11.repositories.DrinkRepository;

@Service
public class DrinkService {
    @Autowired
    private DrinkRepository drinkRepository;

    public void save(Drink drink) {
        drinkRepository.save(drink);
    }

    public void deleteById(Integer id){
         drinkRepository.deleteById(id);
    }

    public List<Drink> getAllDrink(){
        return drinkRepository.findAll();
    }

    public Drink findById(Integer id){
        return drinkRepository.findById(id).orElse(null);
    }
    
}
