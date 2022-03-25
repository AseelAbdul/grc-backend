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
@Table(name = "Source")

public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    private int id;
    private String sourceName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
    public static Source fromSource(int source_department) {
        Source source=new Source();
        source.id=source_department;
        return source;}
}
