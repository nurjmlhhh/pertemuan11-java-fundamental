package com.pertemuan11.pertemuan11.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pertemuan11.pertemuan11.models.Chef;

public interface ChefRepository extends JpaRepository<Chef, Integer> {
    
}
