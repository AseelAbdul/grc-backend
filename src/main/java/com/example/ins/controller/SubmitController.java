package com.example.ins.controller;

import com.example.ins.entity.*;
import com.example.ins.service.SubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SubmitController {
    @Autowired
    private SubmitService service;
    @PostMapping("addSubmit")
    public Submit addSubmit(@RequestBody Submit submit){return service.saveRecord(submit);}
    @PostMapping("addSubmits")
    public List<Submit> addSubmits(@RequestBody List<Submit> submits){
        return service.saveRecords(submits);
    }
    @DeleteMapping("deleteSubmit/{id}")
    public String deleteSubmit(@PathVariable int id){return service.deleteRecord(id);}
    @GetMapping("Submit/{riskId}")
    public Submit findbyRiskId(@PathVariable int id){return service.getById(id);}
    @GetMapping("Submits")
    public List<Submit> findAll(){return service.getRecord();}
    @GetMapping("Submit/category/{category}")
    public  List<Submit> findByRiskCategory(@PathVariable category category){return service.getByCategory(category);}
    @GetMapping("Submit/risksource/{riskSource}")
    public List<Submit> findByRiskSource(@PathVariable department riskSource){return service.getByRiskSource(riskSource);}
    @GetMapping("Submit/resolutionowner/{resolutionOwner}")
    public List<Submit> findByResolutionOwner(@PathVariable department resolutionOwner){return service.getByResolutionOwner(resolutionOwner);}
    @GetMapping("Submit/sourcedepartment/{sourceDepartment}")
    public List<Submit> findBySourceDepartment(@PathVariable Source sourceDepartment){return service.getBySourceDepartment(sourceDepartment);}
    @GetMapping("Submit/controlregulation/{controlRegulation}")
    public List<Submit> findByControlRegulation(@PathVariable Regulations controlRegulation){return service.getByControlRegulation(controlRegulation);}
    @GetMapping("Submit/riskscoring/{riskScoringMethod}")
    public List<Submit> findByRiskScoring(@PathVariable Scoring riskScoringMethod){return service.getByRiskScoringMethod(riskScoringMethod);}
    @GetMapping("Submit/probability/{probability}")
    public List<Submit> findByProbability(@PathVariable Risk probability){return service.getByProbability(probability);}
    @GetMapping("Submit/impact/{impact}")
    public List<Submit> findByImpact(@PathVariable Risk impact){return service.getByImpact(impact);}
    @GetMapping("count")
    public Map<String, Object > getCombination(){
        Map<String, Object> map=new HashMap<>();
        map.put("High_High",service.countHighHigh());
        map.put("High_Medium",service.countHighMedium());
        map.put("High_Low",service.countHighLow());
        map.put("Medium_High",service.countMediumHigh());
        map.put("Medium_Medium",service.countMediumMedium());
        map.put("Medium_Low",service.countMediumLow());
        map.put("Low_High",service.countHLowHigh());
        map.put("Low_Medium",service.countLowMedium());
        map.put("Low_Low",service.countLowLow());
        return map;
    }
    @PutMapping("updateSubmit")
    public Submit updateSubmit(@RequestBody Submit submit) {
        return service.updateRecord(submit);
    }

}
