package com.patient.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Entity
    @Table(name = "subcancertype1")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubCancerType1 implements Serializable {
    @Column(name = "pk")
    @Id
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "cancer_type_id")
    private int subcancertypeid;

    @ManyToOne
    @JoinColumn(name = "id")
    private CancerType cancerType;

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

    public int getSubcancertypeid() {
        return subcancertypeid;
    }

    public void setSubcancertypeid(int subcancertypeid) {
        this.subcancertypeid = subcancertypeid;
    }

    public CancerType getCancerType() {
        return cancerType;
    }

    public void setCancerType(CancerType cancerType) {
        this.cancerType = cancerType;
    }
}
