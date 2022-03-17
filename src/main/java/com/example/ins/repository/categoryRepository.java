package com.example.ins.repository;

import com.example.ins.entity.category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface categoryRepository extends JpaRepository<category, Integer> {
    List<category> findByriskCategoryId(int riskCategoryId);
}
