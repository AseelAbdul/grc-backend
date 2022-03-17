package com.example.ins.entity;


import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor@NoArgsConstructor
@Table(name="transaction")

public class transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Risk_Id")
    private int riskId;
    @Column(name = "Date")
    private String date;
    @Column(name = "Risk_Description")
    private String riskDescription;
    @Column(name = "Probability")
    private String probability;
    @Column(name = "Impact")
    private String impact;
    @Column(name = "Overall_Risk_Rating")
    private String overallRiskRating;
    @Column(name = "Cost_Impact")
    private double costImpact;
    @Column(name = "Assigned_to")
    private String assignedTo;
    @Column(name = "Project_Id")
    private int projectId;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getRiskId() {
        return riskId;
    }

    public void setRiskId(int riskId) {
        this.riskId = riskId;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRiskDescription() {
        return riskDescription;
    }

    public void setRiskDescription(String riskDescription) {
        this.riskDescription = riskDescription;
    }

    public double getCostImpact() {
        return costImpact;
    }

    public void setCostImpact(double costImpact) {
        this.costImpact = costImpact;
    }


    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getOverallRiskRating() {
        return overallRiskRating;
    }

    public void setOverallRiskRating(String overallRiskRating) {
        this.overallRiskRating = overallRiskRating;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_category")
    private category category;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_department")
    private department department;*/
    @ManyToOne()
    @JoinColumn(name = "Risk_Source_BU")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("risk_source_bu")
    private department riskSourceBu;
    @JsonProperty("risk_source_bu")
    public void setSource(int risk_source_bu){riskSourceBu=department.fromSource(risk_source_bu);}

    @ManyToOne()
    @JoinColumn(name = "Resolution_Owner_BU")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("resolution_owner_bu")
    private department resolutionOwnerBu;
    @JsonProperty("resolution_owner_bu")
    public void setOwner(int resolution_owner_bu){resolutionOwnerBu=department.fromResolution(resolution_owner_bu);}

    @ManyToOne()
    @JoinColumn(name="Risk_Category")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("risk_category")
    private category riskCategory;
    @JsonProperty("risk_category")
    public void setCategory(int risk_category){riskCategory=category.fromCategory(risk_category);}

    public department getRiskSourceBu() {
        return riskSourceBu;
    }

    public void setRiskSourceBu(department riskSourceBu) {
        this.riskSourceBu = riskSourceBu;
    }

    public department getResolutionOwnerBu() {
        return resolutionOwnerBu;
    }

    public void setResolutionOwnerBu(department resolutionOwnerBu) {
        this.resolutionOwnerBu = resolutionOwnerBu;
    }

    public category getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(category riskCategory) {
        this.riskCategory = riskCategory;
    }
    
}
