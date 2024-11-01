package com.pertemuan11.pertemuan11.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pertemuan11.pertemuan11.models.Login;
import com.pertemuan11.pertemuan11.repositories.LoginRepository;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public void save(Login login){
        loginRepository.save(login);
    }

    public Login findByUsernameAndPassword(String username, String password){
        List <Login> login = loginRepository.findByUsernameAndPassword(username, password);
        return login.stream()
                    .findFirst()
                    .orElse(null);
    }

    public void deleteById(Integer id){
         loginRepository.deleteById(id);
    }

    public List<Login> getAllLogin(){
        return loginRepository.findAll();
    }

    public Login findById(Integer id){
        return loginRepository.findById(id).orElse(null);
    }
}
