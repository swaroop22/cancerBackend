package com.patient.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "subCancerLevels")
public class SubCancerLevels {
    @Column(name = "pk")
    @Id
    public int id;

    @Column(name = "title")
    private String title;

    @Transient
    private List<RegimenDetail> regimenDetailList =  new ArrayList<>();

    public List<RegimenDetail> getRegimenDetailList() {
        return regimenDetailList;
    }

    public void setRegimenDetailList(List<RegimenDetail> regimenDetailList) {
        this.regimenDetailList = regimenDetailList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegimenDetail() {
        return regimenDetail;
    }

    public void setRegimenDetail(String regimenDetail) {
        this.regimenDetail = regimenDetail;
    }

    @Column(name = "regimens")
    private String regimenDetail;

}
