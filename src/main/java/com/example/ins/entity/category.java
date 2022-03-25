package com.example.ins.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "riskCategoryId")
    private int riskCategoryId;

    private String riskCategory;
    public int getRiskCategoryId() {
        return riskCategoryId;
    }

    public void setRiskCategoryId(int riskCategoryId) {
        this.riskCategoryId = riskCategoryId;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }

    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category",referencedColumnName = "riskCategoryId")
    private List<transaction> transactions;*/
    /*@OneToMany(mappedBy = "riskCategory")
    @JsonIgnore
    private List<transaction> category;*/
    public static category fromCategory(int Category) {
        category riskCategory=new category();
        riskCategory.riskCategoryId=Category;
        return riskCategory;}


}
