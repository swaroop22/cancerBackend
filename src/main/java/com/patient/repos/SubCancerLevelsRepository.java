package com.patient.repos;
import com.patient.models.SubCancerLevels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCancerLevelsRepository  extends JpaRepository<SubCancerLevels, Integer> {

}
