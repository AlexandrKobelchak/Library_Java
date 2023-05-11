package com.example.controllers;

import com.example.domain.dao.IAuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    //@Autowired
    private final IAuthorRepository _repo;

    @RequestMapping("/Author/List")
    public ModelAndView Author(){

        return new ModelAndView(
               "author/list",
               "authors",
                _repo.findAuthorsByBooks(1));
    }
}
