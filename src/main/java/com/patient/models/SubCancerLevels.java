package com.patient.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "subCancerLevels")
public class SubCancerLevels {
    @Column(name = "pk")
    @Id
    private int id;

    @Column(name = "title")
    private String title;

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
