package com.example.ins.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Regulations")

public class Regulations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    private int id;
    private String regulationName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegulationName() {
        return regulationName;
    }

    public void setRegulationName(String regulationName) {
        this.regulationName = regulationName;
    }
    public static Regulations fromRegulations(int control_regulation) {
        Regulations regulations=new Regulations();
        regulations.id=control_regulation;
        return regulations;}
}
