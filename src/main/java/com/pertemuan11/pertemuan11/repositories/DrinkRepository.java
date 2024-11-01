package com.pertemuan11.pertemuan11.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pertemuan11.pertemuan11.models.Drink;

public interface DrinkRepository extends JpaRepository<Drink, Integer> {
    
}
