package com.example.ins.service;

import com.example.ins.entity.Risk;
import com.example.ins.repository.RiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskService {
    @Autowired
    private RiskRepository repository;

    public Risk saveRisk(Risk r) {
        return repository.save(r);
    }
    public List<Risk> saveRisks(List<Risk> Risks) {
        return repository.saveAll(Risks);
    }

    public List<Risk> getRisks() {
        return repository.findAll();
    }
    public Risk getById(int id){return repository.findById(id);}

    public String deleteRisk(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public Risk updateRisk(Risk r) {
        Risk existingProduct = repository.findById(r.getId());
        existingProduct.setRiskName(r.getRiskName());
        return repository.save(existingProduct);
    }
}
