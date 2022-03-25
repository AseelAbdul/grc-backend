package com.example.ins.repository;

import com.example.ins.entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceRepository extends JpaRepository<Source,Integer> {
    Source findById(int id);
}
