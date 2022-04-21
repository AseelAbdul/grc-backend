package com.example.ins.controller;

import com.example.ins.entity.Source;
import com.example.ins.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SourceController {
    @Autowired
    private SourceService service;

    @PostMapping("/addSource")
    public Source addSource(@RequestBody Source s){
        return service.saveSource(s);
    }
    @PostMapping("/addSources")
    public List<Source> addSources(@RequestBody List<Source> Sources){
        return service.saveSources(Sources);
    }
    @GetMapping("/Source/{id}")
    public Source findBySource(@PathVariable int id){return service.getById(id);}
    @GetMapping("/Sources")
    public List<Source> findAllSources(){
        return service.getSources();
    }

    @PutMapping("/updateSource")
    public Source updateSource(@RequestBody Source s){
        return service.updateSource(s);
    }
    @DeleteMapping("/deleteSource/{id}")
    public String deleteSource(@PathVariable int id){
        return service.deleteSource(id);
    }
}
