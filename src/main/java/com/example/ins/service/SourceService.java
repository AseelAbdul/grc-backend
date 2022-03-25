package com.example.ins.service;

import com.example.ins.entity.Source;
import com.example.ins.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceService {
    @Autowired
    private SourceRepository repository;

    public Source saveSource(Source s) {
        return repository.save(s);
    }
    public List<Source> saveSources(List<Source> Sources) {
        return repository.saveAll(Sources);
    }

    public List<Source> getSources() {
        return repository.findAll();
    }
    public Source getById(int id){return repository.findById(id);}

    public String deleteSource(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public Source updateSource(Source s) {
        Source existingProduct = repository.findById(s.getId());
        existingProduct.setSourceName(s.getSourceName());
        return repository.save(existingProduct);
    }
}
