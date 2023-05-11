package com.example.controllers;

import com.example.domain.dao.IAuthorRepository;
import com.example.domain.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ApiController {

    @Autowired
    private IAuthorRepository _repo;
    @GetMapping("/api/Authors")
    public Iterable<Author> AllAuthors(){

        return _repo.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/Authors/{id}")
    public Author GetAuthor(@PathVariable Long id){

        return _repo.findById(id).get();
    }
    @PostMapping("/api/Authors")
    public void AddAuthor(@RequestBody Author author){

        _repo.save(author);
    }

    @PutMapping("/api/Authors")
    public void ChangeAuthor(@RequestBody Author author){

        Author candidate = _repo.findById(author.getId()).get();
        candidate.setFirstName(author.getFirstName());
        candidate.setLastName(author.getLastName());
        _repo.save(candidate);
    }
    @DeleteMapping("/api/Authors/{id}")
    public void DeleteAuthor(@PathVariable Long id){

        _repo.delete(_repo.findById(id).get());
    }
}
