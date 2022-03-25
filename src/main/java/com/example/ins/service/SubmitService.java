package com.example.ins.service;

import com.example.ins.entity.*;
import com.example.ins.repository.SubmitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmitService {
    @Autowired
    private SubmitRepository repository;
    public Submit saveRecord(Submit submit) {
        return repository.save(submit);
    }

    public List<Submit> saveRecords(List<Submit> submits) {
        return repository.saveAll(submits);
    }

    public List<Submit> getRecord() {
        return repository.findAll();
    }

    public Submit getById(int id) {
        return repository.findById(id);
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


    public String deleteRecord(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;}

    public List<Submit> getByCategory(category category){
        return repository.findByCategory(category);}

    public List<Submit> getByRiskSource(department riskSource){
        return repository.findByRiskSource(riskSource);}

    public List<Submit> getByResolutionOwner(department resolutionOwner){
        return repository.findByResolutionOwner(resolutionOwner);
    }
    public List<Submit> getBySourceDepartment(Source sourceDepartment){
        return repository.findBySourceDepartment(sourceDepartment);
    }
    public List<Submit> getByControlRegulation(Regulations controlRegulation){
        return repository.findByControlRegulation(controlRegulation);
    }
    public List<Submit> getByRiskScoringMethod(Scoring riskScoringMethod){
        return repository.findByRiskScoringMethod(riskScoringMethod);
    }
    public List<Submit> getByProbability(Risk probability){
        return repository.findByProbability(probability);
    }
    public List<Submit> getByImpact(Risk impact){
        return repository.findByImpact(impact);
    }

    public Submit updateRecord(Submit submit) {
        Submit existingProduct = repository.findById(submit.getId());
        existingProduct.setDate(submit.getDate());
        existingProduct.setSourceDepartment(submit.getSourceDepartment());
        existingProduct.setProbability(submit.getProbability());
        existingProduct.setCategory(submit.getCategory());
        existingProduct.setDescription(submit.getDescription());
        existingProduct.setControlRegulation(submit.getControlRegulation());
        existingProduct.setRiskSource(submit.getRiskSource());
        existingProduct.setRiskScoringMethod(submit.getRiskScoringMethod());
        existingProduct.setResolutionOwner(submit.getResolutionOwner());
        existingProduct.setImpact(submit.getImpact());
        existingProduct.setAssignedTo(submit.getAssignedTo());
        existingProduct.setAdditionalNotes(submit.getAdditionalNotes());
        existingProduct.setSupportingDocument(submit.getSupportingDocument());
        return repository.save(existingProduct);
    }
}
