package com.example.ins.controller;

import com.example.ins.entity.Scoring;
import com.example.ins.service.ScoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoringController {
    @Autowired
    private ScoringService service;

    @PostMapping("/addScoring")
    public Scoring addScoring(@RequestBody Scoring r){
        return service.saveScoring(r);
    }
    @PostMapping("/addScorings")
    public List<Scoring> addScorings(@RequestBody List<Scoring> Scorings){
        return service.saveScorings(Scorings);
    }
    @GetMapping("/Scoring/{id}")
    public Scoring findByScoring(@PathVariable int id){return service.getById(id);}
    @GetMapping("/Scorings")
    public List<Scoring> findAllScorings(){
        return service.getScorings();
    }

    @PutMapping("/updateScoring")
    public Scoring updateScoring(@RequestBody Scoring r){
        return service.updateScoring(r);
    }
    @DeleteMapping("/deleteScoring/{id}")
    public String deleteScoring(@PathVariable int id){
        return service.deleteScoring(id);
    }
}
