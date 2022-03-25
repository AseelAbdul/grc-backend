package com.example.ins.service;

import com.example.ins.entity.Regulations;
import com.example.ins.repository.RegulationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegulationsService {
    @Autowired
    private RegulationsRepository repository;

    public Regulations saveRegulation(Regulations r) {
        return repository.save(r);
    }
    public List<Regulations> saveRegulations(List<Regulations> regulations) {
        return repository.saveAll(regulations);
    }

    public List<Regulations> getRegulations() {
        return repository.findAll();
    }
    public Regulations getById(int id){return  repository.findById(id);}

    public String deleteRegulation(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public Regulations updateRegulation(Regulations r) {
        Regulations existingProduct = repository.findById(r.getId());
        existingProduct.setRegulationName(r.getRegulationName());
        return repository.save(existingProduct);
    }


}
