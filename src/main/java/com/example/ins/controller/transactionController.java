package com.example.ins.controller;

import com.example.ins.entity.category;
import com.example.ins.entity.department;
import com.example.ins.entity.transaction;
import com.example.ins.service.transactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class transactionController {

    @Autowired
    private transactionService service;

    @PostMapping("addTransaction")
    public transaction addProduct(@RequestBody transaction t){return service.saveRecord(t);}
    @PostMapping("addTransactions")
    public List<transaction> addProducts(@RequestBody List<transaction> t){
        return service.saveRecords(t);
    }
    @DeleteMapping("deleteTransaction/{id}")
    public String deleteProduct(@PathVariable int id){return service.deleteProduct(id);}
    @GetMapping("transaction/{riskId}")
    public transaction findbyriskId(@PathVariable int riskId){return service.getByRiskId(riskId);}
    @GetMapping("transactions")
    public List<transaction> findAll(){return service.getRecord();}
    @GetMapping("transaction/category/{riskCategory}")
    public  List<transaction> findByRiskcategory(@PathVariable category riskCategory){return service.getByCategory(riskCategory);}
    @GetMapping("transaction/risksource/{riskSourceBu}")
    public List<transaction> findByRiskSource(@PathVariable department riskSourceBu){return service.getByRiskSource(riskSourceBu);}
    @GetMapping("transaction/resolutionowner/{resolutionOwnerBu}")
    public List<transaction> findByResolutionOwner(@PathVariable department resolutionOwnerBu){return service.getByResolutionOwner(resolutionOwnerBu);}
    @GetMapping("count")
    public long findHigh(){
         return service.countHighHigh();
    }
    @GetMapping("count1")
    public long findMedium(){
        return service.countHighMedium();
    }
@GetMapping("count2")
    public Map<String, Object > get(){
    Map<String, Object> map=new HashMap<>();
    map.put("HighHigh",service.countHighHigh());
    map.put("HighMedium",service.countHighMedium());
    map.put("HighLow",service.countHighLow());
    map.put("MediumHigh",service.countMediumHigh());
    map.put("MediumMedium",service.countMediumMedium());
    map.put("MediumLow",service.countMediumLow());
    map.put("LowHigh",service.countHLowHigh());
    map.put("LowMedium",service.countLowMedium());
    map.put("LowLow",service.countLowLow());
        return map;
    }
    @PutMapping("updateTransaction")
    public transaction updateTransaction(@RequestBody transaction t) {
        return service.updateTransact(t);
    }



    }
