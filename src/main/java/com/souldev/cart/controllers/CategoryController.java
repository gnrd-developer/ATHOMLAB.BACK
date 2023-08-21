package com.souldev.cart.controllers;

import com.souldev.cart.entities.Category;
import com.souldev.cart.entities.Message;
import com.souldev.cart.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(this.categoryService.getAllCategories(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Message> create(@RequestBody Category category){
        this.categoryService.createCategory(category);
        return new ResponseEntity<>(new Message("Creado"),HttpStatus.OK);
    }
    
}
