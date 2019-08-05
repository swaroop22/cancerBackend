package com.patient.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Table(name = "cancer_type")
@Data
@Builder
@AllArgsConstructor
public class CancerType implements Serializable {
    @Column(name = "pk")
    @Id
    private int id;

    @Column(name = "patient_type_id")
    private int patienttypeid;

    @ManyToOne
    @JoinColumn(name = "id")
    private Patient patient;

    @Column(name = "title")
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatienttypeid() {
        return patienttypeid;
    }

    public void setPatienttypeid(int patienttypeid) {
        this.patienttypeid = patienttypeid;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
