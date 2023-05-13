package com.example.controllers;

import com.example.domain.models.Identity.AppUser;
import com.example.domain.services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final AppUserService userService;

    @GetMapping("/registration")
    public String registration(Model model){

        model.addAttribute("user", new AppUser());
        return "/user/registration";
    }
}
