package com.example.ins.repository;

import com.example.ins.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubmitRepository extends JpaRepository<Submit,Integer> {
    @Query("select count(id) from Submit where probability='high' AND impact='high'")
    long highHigh();
    @Query("select count(id) from Submit where probability='high' AND impact='medium'")
    long highMedium();
    @Query("select count(id) from Submit where probability='high' AND impact='low'")
    long highLow();
    @Query("select count(id) from Submit where probability='medium' AND impact='high'")
    long mediumHigh();
    @Query("select count(id) from Submit where probability='medium' AND impact='medium'")
    long mediumMedium();
    @Query("select count(id) from Submit where probability='medium' AND impact='low'")
    long mediumLow();
    @Query("select count(id) from Submit where probability='low' AND impact='high'")
    long lowHigh();
    @Query("select count(id) from Submit where probability='low' AND impact='medium'")
    long lowMedium();
    @Query("select count(id) from Submit where probability='low' AND impact='low'")
    long lowLow();
    Submit findById(int id);
    List<Submit> findByResolutionOwner(department resolutionOwner);
    List<Submit> findBySourceDepartment(Source sourceDepartment);
    List<Submit> findByCategory(category category);
    List<Submit> findByControlRegulation(Regulations controlRegulation);
    List<Submit> findByRiskSource(department riskSource);
    List<Submit> findByRiskScoringMethod(Scoring riskScoringMethod);
    List<Submit> findByProbability(Risk probability);
    List<Submit> findByImpact(Risk impact);
}
