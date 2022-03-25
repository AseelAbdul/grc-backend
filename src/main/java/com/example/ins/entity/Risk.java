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
@Table(name = "Risk")

public class Risk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    private int id;
    private String riskName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }
    public static Risk fromProbability(int Probability) {
        Risk risk=new Risk();
        risk.id=Probability;
        return risk;}
    public static Risk fromImpact(int Impact) {
        Risk risk=new Risk();
        risk.id=Impact;
        return risk;}
}
