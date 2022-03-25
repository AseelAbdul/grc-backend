package com.example.ins.controller;

import com.example.ins.entity.Risk;
import com.example.ins.service.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RiskController {
    
    @Autowired
    private RiskService service;

    @PostMapping("/addRisk")
    public Risk addRisk(@RequestBody Risk r){
        return service.saveRisk(r);
    }
    @PostMapping("/addRisks")
    public List<Risk> addRisks(@RequestBody List<Risk> Risks){
        return service.saveRisks(Risks);
    }
    @GetMapping("/Risk/{id}")
    public Risk findByRisk(@PathVariable int id){return service.getById(id);}
    @GetMapping("/Risks")
    public List<Risk> findAllRisks(){
        return service.getRisks();
    }

    @PutMapping("/updateRisk")
    public Risk updateRisk(@RequestBody Risk r){
        return service.updateRisk(r);
    }
    @DeleteMapping("/deleteRisk/{id}")
    public String deleteRisk(@PathVariable int id){
        return service.deleteRisk(id);
    }
}
