package com.example.ins.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Submit")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Submit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private String description;
    private String assignedTo;
    private String additionalNotes;
    private String supportingDocument;
    @ManyToOne()
    @JoinColumn(name = "source_department")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("source_department")
    private Source sourceDepartment;
    @ManyToOne
    @JoinColumn(name = "category")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("Category")
    private category category;
    @ManyToOne
    @JoinColumn(name = "control_Regulation")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("control_regulation")
    private Regulations controlRegulation;
    @ManyToOne
    @JoinColumn(name = "resolution_Owner")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("resolution_owner")
    private department resolutionOwner;
    @ManyToOne
    @JoinColumn(name = "risk_Source")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("risk_source")
    private department riskSource;
    @ManyToOne
    @JoinColumn(name = "risk_Scoring_Method")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("risk_scoring_method")
    private Scoring riskScoringMethod;
    @ManyToOne
    @JoinColumn(name = "probability")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("Probability")
    private Risk probability;
    @ManyToOne
    @JoinColumn(name = "impact")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("Impact")
    private Risk impact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public String getSupportingDocument() {
        return supportingDocument;
    }

    public void setSupportingDocument(String supportingDocument) {
        this.supportingDocument = supportingDocument;
    }

    public Source getSourceDepartment() {
        return sourceDepartment;
    }

    public void setSourceDepartment(Source sourceDepartment) {
        this.sourceDepartment = sourceDepartment;
    }

    public com.example.ins.entity.category getCategory() {
        return category;
    }

    public void setCategory(com.example.ins.entity.category category) {
        this.category = category;
    }

    public Regulations getControlRegulation() {
        return controlRegulation;
    }

    public void setControlRegulation(Regulations controlRegulation) {
        this.controlRegulation = controlRegulation;
    }

    public department getResolutionOwner() {
        return resolutionOwner;
    }

    public void setResolutionOwner(department resolutionOwner) {
        this.resolutionOwner = resolutionOwner;
    }

    public department getRiskSource() {
        return riskSource;
    }

    public void setRiskSource(department riskSource) {
        this.riskSource = riskSource;
    }

    public Scoring getRiskScoringMethod() {
        return riskScoringMethod;
    }

    public void setRiskScoringMethod(Scoring riskScoringMethod) {
        this.riskScoringMethod = riskScoringMethod;
    }

    public Risk getProbability() {
        return probability;
    }

    public void setProbability(Risk probability) {
        this.probability = probability;
    }

    public Risk getImpact() {
        return impact;
    }

    public void setImpact(Risk impact) {
        this.impact = impact;
    }
    @JsonProperty("source_department")
    public void setSource(int source_department){sourceDepartment=Source.fromSource(source_department);}
    @JsonProperty("Category")
    public void setCategory(int Category){category= com.example.ins.entity.category.fromCategory(Category);}
    @JsonProperty("control_regulation")
    public void setRegulation(int control_regulation){controlRegulation= Regulations.fromRegulations(control_regulation);}
    @JsonProperty("risk_source")
    public void setRiskSourceBu(int risk_source){riskSource= department.fromRiskSource(risk_source);}
    @JsonProperty("risk_scoring_method")
    public void setScoring(int risk_scoring_method){riskScoringMethod= Scoring.fromScoring(risk_scoring_method);}
    @JsonProperty("Probability")
    public void setRiskProbability(int Probability){probability= Risk.fromProbability(Probability);}
    @JsonProperty("Impact")
    public void setRiskImpact(int Impact){impact= Risk.fromImpact(Impact);}
    @JsonProperty("resolution_owner")
    public void setResolutionOwnerBu(int resolution_owner){resolutionOwner= department.fromResolution(resolution_owner);}
}
