package com.example.exchange.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value="/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @RequestMapping(value = "/addCategory")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }
}
