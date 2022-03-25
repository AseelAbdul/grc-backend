package com.example.ins.repository;

import com.example.ins.entity.Risk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskRepository extends JpaRepository<Risk,Integer> {
    Risk findById(int id);
}
