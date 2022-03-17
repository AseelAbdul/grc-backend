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
@Table(name = "department")

public class department {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "businessUnitId")
private int businessUnitId;
private String businessUnit;

    public int getBusinessUnitId() {
        return businessUnitId;
    }

    public void setBusinessUnitId(int businessUnitId) {
        this.businessUnitId = businessUnitId;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }
     /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="riskSource",referencedColumnName = "businessUnitId")
    private List<transaction> transactions; */
    @OneToMany(mappedBy = "riskSourceBu")
    @JsonIgnore
    private List<transaction> transactionrisksource;
    @OneToMany(mappedBy="resolutionOwnerBu",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<transaction> transactionresolutionowner;
    public static department fromResolution(int resolution_owner_bu) {
        department resolutionOwnerBu=new department();
    resolutionOwnerBu.businessUnitId=resolution_owner_bu;
    return resolutionOwnerBu;}

    public static department fromSource(int risk_source_bu) {
        department riskSourceBu=new department();
        riskSourceBu.businessUnitId=risk_source_bu;
        return riskSourceBu;}


}
