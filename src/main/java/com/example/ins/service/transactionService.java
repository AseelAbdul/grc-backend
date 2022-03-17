package com.example.ins.service;


import com.example.ins.entity.category;
import com.example.ins.entity.department;
import com.example.ins.entity.transaction;
import com.example.ins.repository.transactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class transactionService {
    @Autowired
    private transactionRepository repository;

    public transaction saveRecord(transaction t) {
        return repository.save(t);
    }

    public List<transaction> saveRecords(List<transaction> t) {
        return repository.saveAll(t);
    }

    public List<transaction> getRecord() {
        return repository.findAll();
    }

    public transaction getByRiskId(int riskId) {
        return repository.findByRiskId(riskId);
    }

    public long countHighHigh(){return repository.highHigh();}
    public long countHighMedium(){return repository.highMedium();}
    public long countHighLow(){return repository.highLow();}
    public long countMediumHigh(){return repository.mediumHigh();}
    public long countMediumMedium(){return repository.mediumMedium();}
    public long countMediumLow(){return repository.mediumLow();}
    public long countHLowHigh(){return repository.lowHigh();}
    public long countLowMedium(){return repository.lowMedium();}
    public long countLowLow(){return repository.lowLow();}


    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;}

    public List<transaction> getByCategory(category riskCategory){
        return repository.findByRiskCategory(riskCategory);}

    public List<transaction> getByRiskSource(department riskSourceBu){
        return repository.findByRiskSourceBu(riskSourceBu);}

    public List<transaction> getByResolutionOwner(department resolutionOwner){
        return repository.findByResolutionOwnerBu(resolutionOwner);
    }

        public transaction updateTransact(transaction t) {
        transaction existingProduct = repository.findByRiskId(t.getRiskId());
        existingProduct.setAssignedTo(t.getAssignedTo());
        existingProduct.setCostImpact(t.getCostImpact());
        existingProduct.setProbability(t.getProbability());
        existingProduct.setDate(t.getDate());
        existingProduct.setRiskDescription(t.getRiskDescription());
        existingProduct.setOverallRiskRating(t.getOverallRiskRating());
        existingProduct.setRiskCategory(t.getRiskCategory());
        existingProduct.setRiskSourceBu(t.getRiskSourceBu());
        existingProduct.setResolutionOwnerBu(t.getResolutionOwnerBu());
        existingProduct.setImpact(t.getImpact());
        existingProduct.setProjectId(t.getProjectId());
        return repository.save(existingProduct);
    }
}