package com.example.ins.repository;

import com.example.ins.entity.Scoring;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoringRepository extends JpaRepository<Scoring,Integer> {
    Scoring findById(int id);
}
