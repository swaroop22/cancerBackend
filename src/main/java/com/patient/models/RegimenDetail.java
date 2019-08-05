package com.patient.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "regimen_detail")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegimenDetail implements Serializable {
    @Id
    @Column(name = "pk")
    public Long id;


    @Column(name = "subcancer_type3_id")
    private int SubCancerTypeId3;

    @Column(name = "disp_name")
    @Size(max = 10485760)
    private String dispName;

    @Column(name = "name")
    @Size(max = 10485760)
    private String name;

    @Column(name = "schedule")
    @Size(max = 10485760)
    private String schedule;

    @Column(name = "emetogenic_potential")
    @Size(max = 10485760)
    private String emetogenicPotential;

    @Column(name = "reference")
    @Size(max = 10485760)
    private String reference;

    @Column(name = "dosage_modifications")
    @Size(max = 10485760)
    private String dosageModifications;

    @Column(name = "brand_names")
    @Size(max = 10485760)
    private String brandNames;

    @ManyToOne
    @JoinColumn(name = "subcancertype2_id")
    private SubCancerType2 subCancerType2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSubCancerTypeId3() {
        return SubCancerTypeId3;
    }

    public void setSubCancerTypeId3(int subCancerTypeId3) {
        SubCancerTypeId3 = subCancerTypeId3;
    }

    public String getDispName() {
        return dispName;
    }

    public void setDispName(String dispName) {
        this.dispName = dispName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getEmetogenicPotential() {
        return emetogenicPotential;
    }

    public void setEmetogenicPotential(String emetogenicPotential) {
        this.emetogenicPotential = emetogenicPotential;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDosageModifications() {
        return dosageModifications;
    }

    public void setDosageModifications(String dosageModifications) {
        this.dosageModifications = dosageModifications;
    }

    public String getBrandNames() {
        return brandNames;
    }

    public void setBrandNames(String brandNames) {
        this.brandNames = brandNames;
    }

    public SubCancerType2 getSubCancerType2() {
        return subCancerType2;
    }

    public void setSubCancerType2(SubCancerType2 subCancerType2) {
        this.subCancerType2 = subCancerType2;
    }

    public SubCancerType1 getSubCancerType1() {
        return subCancerType1;
    }

    public void setSubCancerType1(SubCancerType1 subCancerType1) {
        this.subCancerType1 = subCancerType1;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public int getId3() {
        return id3;
    }

    public void setId3(int id3) {
        this.id3 = id3;
    }

    public int getId4() {
        return id4;
    }

    public void setId4(int id4) {
        this.id4 = id4;
    }

    @ManyToOne
    @JoinColumn(name = "subcancertype3_id")
    private SubCancerType1 subCancerType1;

    @Transient
    private int id2;

    @Transient
    private int id3;

    @Transient
    private int id4;


}
