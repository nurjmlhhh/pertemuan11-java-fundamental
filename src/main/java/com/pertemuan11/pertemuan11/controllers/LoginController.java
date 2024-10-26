package com.pertemuan11.pertemuan11.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pertemuan11.pertemuan11.models.Login;
import com.pertemuan11.pertemuan11.services.LoginService;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("registrasi")
    public String registrasi(Model model){
        Login login = new Login();
        model.addAttribute("regis", login);
        return "registrasi";
    }


    @PostMapping("save-regis")
    public String saveRegis(@ModelAttribute ("regis") Login login){
        loginService.save(login);
        return "redirect:registrasi";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @PostMapping("cek-login")
    public String login(@RequestParam ("username") String username, 
                        @RequestParam ("password") String password, Model model){
        Login login = loginService.findByUsernameAndPassword(username, password);
        if(login != null){
            model.addAttribute("login", login);
            return "home";
        }else{
            return "redirect:/login";
        }
    }

    @GetMapping("delete-akun/{id}")
    public String deleteAkun(@PathVariable (value = "id") Integer id){
        loginService.deleteById(id);
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model){
        List <Login> login = loginService.getAllLogin();
        model.addAttribute("login", login);
        return "home";
    }
}
