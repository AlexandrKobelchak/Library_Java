package com.example.controllers;

import com.example.domain.models.Identity.AppUser;
import com.example.domain.services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class LoginController {

    private final AppUserService userService;

    @GetMapping("/login")
    public String getLogin(){


        return "/user/login";
    }

    @PostMapping("/login")
    public String postLogin(Model model){

        model.addAttribute("user", new AppUser());
        return "/home/index";
    }
}
