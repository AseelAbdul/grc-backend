package com.example.ins.controller;

import com.example.ins.entity.department;
import com.example.ins.service.departmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class departmentController {

    @Autowired
    private departmentService service;

    @PostMapping("/addDepartment")
    public department addProduct(@RequestBody department d){
        return service.saveProduct(d);
    }
    @PostMapping("/addDepartments")
    public List<department> addProducts(@RequestBody List<department> departments){
        return service.saveProducts(departments);
    }
    @GetMapping("/department/{businessUnitId}")
    public  department findbydepartment(@PathVariable int businessUnitId){return service.getById(businessUnitId);}
    @GetMapping("/departments")
    public List<department> findAllProducts(){
        return service.getProducts();
    }

    @PutMapping("/updateDepartment")
    public department updateProduct(@RequestBody department d){
        return service.updateDepartment(d);
    }
    @DeleteMapping("/deleteDepartment/{businessUnitId}")
    public String deleteProduct(@PathVariable int businessUnitId){
        return service.deleteProduct(businessUnitId);
    }
}
