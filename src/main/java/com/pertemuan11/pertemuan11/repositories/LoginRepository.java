package com.pertemuan11.pertemuan11.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pertemuan11.pertemuan11.models.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {
    List <Login> findByUsernameAndPassword(String username, String password);
   
}
