package com.pertemuan11.pertemuan11.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pertemuan11.pertemuan11.models.Food;

public interface FoodRepository extends JpaRepository<Food, Integer> {
    
}
