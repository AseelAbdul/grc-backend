package com.example.ins.repository;

import com.example.ins.entity.Regulations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegulationsRepository extends JpaRepository<Regulations,Integer> {
    Regulations findById(int id);
}
