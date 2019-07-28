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
