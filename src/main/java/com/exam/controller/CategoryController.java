package com.exam.controller;

import com.exam.entity.exam.Category;
import com.exam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    //add category
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category category1 = this.categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }

    @GetMapping("/{cid}")
    public ResponseEntity<Category> getCategory(@PathVariable("cid") long cid){
        Category category = this.categoryService.getCategory(cid);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/")
    public ResponseEntity<?> getCategories(){
        return ResponseEntity.ok(this.categoryService.getCategories());
    }

    @PutMapping("/")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){
        Category category1 = this.categoryService.updateCategory(category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{cid}")
    public void deleteCategory(@PathVariable("cid") long cid){
        this.categoryService.deleteCategory(cid);
    }
}
