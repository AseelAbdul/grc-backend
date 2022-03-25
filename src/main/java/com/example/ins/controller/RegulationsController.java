package com.example.ins.controller;

import com.example.ins.entity.Regulations;
import com.example.ins.service.RegulationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegulationsController {
    @Autowired
    private RegulationsService service;

    @PostMapping("/addRegulation")
    public Regulations addRegulation(@RequestBody Regulations r){
        return service.saveRegulation(r);
    }
    @PostMapping("/addRegulations")
    public List<Regulations> addRegulations(@RequestBody List<Regulations> regulations){
        return service.saveRegulations(regulations);
    }
    @GetMapping("/Regulation/{id}")
    public Regulations findByRegulation(@PathVariable int id){return service.getById(id);}
    @GetMapping("/Regulations")
    public List<Regulations> findAllRegulations(){
        return service.getRegulations();
    }

    @PutMapping("/updateRegulation")
    public Regulations updateRegulation(@RequestBody Regulations r){
        return service.updateRegulation(r);
    }
    @DeleteMapping("/deleteRegulation/{id}")
    public String deleteRegulation(@PathVariable int id){
        return service.deleteRegulation(id);
    }

}
