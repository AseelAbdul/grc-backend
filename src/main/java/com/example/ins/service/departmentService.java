package com.example.ins.service;

import com.example.ins.entity.department;
import com.example.ins.repository.departmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class departmentService {

    @Autowired
    private departmentRepository repository;

    public department saveProduct(department d) {
        return repository.save(d);
    }
    public List<department> saveProducts(List<department> departments) {
        return repository.saveAll(departments);
    }

    public List<department> getProducts() {
        return repository.findAll();
    }
    public department getById(int businessUnitId){return  repository.findByBusinessUnitId(businessUnitId);}

    public String deleteProduct(int businessUnitId) {
        repository.deleteById(businessUnitId);
        return "product removed !! " + businessUnitId;
    }

    public department updateDepartment(department d) {
        department existingProduct = repository.findByBusinessUnitId(d.getBusinessUnitId());
        existingProduct.setBusinessUnit(d.getBusinessUnit());
        return repository.save(existingProduct);
    }
}
