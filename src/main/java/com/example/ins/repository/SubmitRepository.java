package com.example.ins.repository;

import com.example.ins.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubmitRepository extends JpaRepository<Submit,Integer> {
    @Query("select count(id) from Submit where probability='1' AND impact='1'")
    long highHigh();
    @Query("select count(id) from Submit where probability='1' AND impact='2'")
    long highMedium();
    @Query("select count(id) from Submit where probability='1' AND impact='3'")
    long highLow();
    @Query("select count(id) from Submit where probability='2' AND impact='1'")
    long mediumHigh();
    @Query("select count(id) from Submit where probability='2' AND impact='2'")
    long mediumMedium();
    @Query("select count(id) from Submit where probability='2' AND impact='3'")
    long mediumLow();
    @Query("select count(id) from Submit where probability='3' AND impact='1'")
    long lowHigh();
    @Query("select count(id) from Submit where probability='3' AND impact='2'")
    long lowMedium();
    @Query("select count(id) from Submit where probability='3' AND impact='3'")
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
