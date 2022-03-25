package com.example.ins.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Scoring")

public class Scoring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    private int id;
    private String scoringName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScoringName() {
        return scoringName;
    }

    public void setScoringName(String scoringName) {
        this.scoringName = scoringName;
    }
    public static Scoring fromScoring(int risk_scoring_method) {
        Scoring scoring=new Scoring();
        scoring.id=risk_scoring_method;
        return scoring;}
}
