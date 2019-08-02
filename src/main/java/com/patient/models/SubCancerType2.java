package com.patient.models;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subcancertype2")
@AllArgsConstructor
@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
public class SubCancerType2 implements Serializable {
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

    public SubCancerType1 getSubCancerType1() {
        return subCancerType1;
    }

    public void setSubCancerType1(SubCancerType1 subCancerType1) {
        this.subCancerType1 = subCancerType1;
    }

    public List<RegimenDetail> getRegimenDetails() {
        return regimenDetails;
    }

    public void setRegimenDetails(List<RegimenDetail> regimenDetails) {
        this.regimenDetails = regimenDetails;
    }

    @Column(name = "pk")
    @Id
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "subcancer_type1_id")
    private int subcancertypeid;

    @ManyToOne
    @JoinColumn(name = "id")
    private SubCancerType1 subCancerType1;

    @OneToMany(mappedBy = "subCancerType2", cascade = CascadeType.ALL)
    @Builder.Default
    @LazyCollection(LazyCollectionOption.FALSE)
    @Column(name = "regimenDetails")
    private List<RegimenDetail> regimenDetails = new ArrayList<>();

    public List<RegimenDetail> getregimenDetails(){
        return new ArrayList<>();
    }
}
