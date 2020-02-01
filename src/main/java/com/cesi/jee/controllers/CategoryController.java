package com.cesi.jee.controllers;

import java.util.List;

import com.cesi.jee.entities.Category;
import com.cesi.jee.entities.Website;
import com.cesi.jee.repositories.CategoryRepository;
import com.cesi.jee.repositories.WebsiteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private WebsiteRepository websiteRepository;

  @GetMapping("/categories")
  public List<Category> getAll() {
    return categoryRepository.findAll();
  }

  @GetMapping(path = "/categories/{id}", produces="application/json")
  public ResponseEntity<Category> getOne(@PathVariable(value = "id") Long id) {
    Category categ = categoryRepository.findById(id).orElse(null);
    if(categ == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(categ, HttpStatus.OK);
  }

  @PostMapping(path = "/categories", consumes = "application/json", produces="application/json")
  public ResponseEntity<Category> post(@RequestBody Category categ) {
    categ = categoryRepository.saveAndFlush(categ);

    return new ResponseEntity<>(categ, HttpStatus.CREATED);
  }

  @PutMapping(path = "/categories/{id}", consumes = "application/json", produces="application/json")
  public ResponseEntity<Category> put(@RequestBody Category categ) {
    categ = categoryRepository.saveAndFlush(categ);

    return new ResponseEntity<>(categ, HttpStatus.OK);
  }

  @DeleteMapping(path = "/categories/{id}", produces="application/json")
  public ResponseEntity<Category> delete(@PathVariable(value = "id") Long id) {
    try {
      categoryRepository.deleteById(id);
    } catch (EmptyResultDataAccessException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping(path = "/categories/{id}/websites", produces="application/json")
  public ResponseEntity<List<Website>> getOneByCategory(@PathVariable(value = "id") Long id) {
    List<Website> websites = websiteRepository.findByCategoryId(id);
    if(websites.size() == 0) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(websites, HttpStatus.OK);
  }
}