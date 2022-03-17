package com.example.ins.repository;

import com.example.ins.entity.category;
import com.example.ins.entity.department;
import com.example.ins.entity.transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface transactionRepository extends JpaRepository<transaction,Integer> {
    @Query("select count(riskId) from transaction where probability='high' AND impact='high'")
    long highHigh();
    @Query("select count(riskId) from transaction where probability='high' AND impact='medium'")
    long highMedium();
    @Query("select count(riskId) from transaction where probability='high' AND impact='low'")
    long highLow();
    @Query("select count(riskId) from transaction where probability='medium' AND impact='high'")
    long mediumHigh();
    @Query("select count(riskId) from transaction where probability='medium' AND impact='medium'")
    long mediumMedium();
    @Query("select count(riskId) from transaction where probability='medium' AND impact='low'")
    long mediumLow();
    @Query("select count(riskId) from transaction where probability='low' AND impact='high'")
    long lowHigh();
    @Query("select count(riskId) from transaction where probability='low' AND impact='medium'")
    long lowMedium();
    @Query("select count(riskId) from transaction where probability='low' AND impact='low'")
    long lowLow();
    transaction findByRiskId(int riskId);
    List<transaction> findByRiskCategory(category riskCategory);
    List<transaction> findByRiskSourceBu(department riskSourceBu);
    List<transaction> findByResolutionOwnerBu(department resolutionOwnerBu);
}
