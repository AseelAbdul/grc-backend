package com.example.ins.service;

import com.example.ins.entity.category;
import com.example.ins.repository.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class categoryService {

    @Autowired
    private categoryRepository repository;

    public category saveProduct(category c) {
        return repository.save(c);
    }
    public List<category> saveProducts(List<category> categories) {
        return repository.saveAll(categories);
    }

    public List<category> getProducts() {
        return repository.findAll();
    }
    public List<category> getByCategory(int riskCategoryId){return  repository.findByriskCategoryId(riskCategoryId);}

    public String deleteProduct(int riskCategoryId) {
        repository.deleteById(riskCategoryId);
        return "product removed !! " + riskCategoryId;
    }

    public category updateCategory(category c) {
        category existingProduct = repository.findById(c.getRiskCategoryId()).orElse(null);
        existingProduct.setRiskCategory(c.getRiskCategory());
        return repository.save(existingProduct);
    }
}


