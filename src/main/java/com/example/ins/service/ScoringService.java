package com.example.ins.service;

import com.example.ins.entity.Scoring;
import com.example.ins.repository.ScoringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoringService {
    @Autowired
    private ScoringRepository repository;

    public Scoring saveScoring(Scoring r) {
        return repository.save(r);
    }
    public List<Scoring> saveScorings(List<Scoring> Scorings) {
        return repository.saveAll(Scorings);
    }

    public List<Scoring> getScorings() {
        return repository.findAll();
    }
    public Scoring getById(int id){return repository.findById(id);}

    public String deleteScoring(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public Scoring updateScoring(Scoring r) {
        Scoring existingProduct = repository.findById(r.getId());
        existingProduct.setScoringName(r.getScoringName());
        return repository.save(existingProduct);
    }
}
