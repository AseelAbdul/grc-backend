package com.example.ins.controller;


import com.example.ins.entity.category;
import com.example.ins.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class categoryController {
    @Autowired
    private categoryService service;

    @PostMapping("/addCategory")
    public category addProduct(@RequestBody category c){
        return service.saveProduct(c);
    }
    @PostMapping("/addCategories")
    public List<category> addProducts(@RequestBody List<category> categories){
        return service.saveProducts(categories);
    }
    @GetMapping("/category/{riskCategoryId}")
    public  List<category> findbycategory(@PathVariable int riskCategoryId){return service.getByCategory(riskCategoryId);}
    @GetMapping("/categories")
    public List<category> findAllProducts(){
        return service.getProducts();
    }

    @PutMapping("/updateCategory")
    public category updateProduct(@RequestBody category c){
        return service.updateCategory(c);
    }
    @DeleteMapping("/deleteCategory/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }

    @RequestMapping("home")
    @ResponseBody
    public String home() {
        return "hello world";
    }
}


