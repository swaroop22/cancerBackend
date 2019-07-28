package com.patient.services;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patient.models.RegimenDetail;
import com.patient.models.SubCancerType2;
import com.patient.repos.SubCancerType2Repository;
import com.sun.javafx.collections.ImmutableObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class SubCancerType2Service {

    @Autowired
    private SubCancerType2Repository subCancerType2Repository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<SubCancerType2> getAllSubCancerType2(){
        return subCancerType2Repository.findAll();
    }


    public  List<SubCancerType2> getSubCancerType2TypesById(int id) { return
            subCancerType2Repository.findSubCancerType2ById(id);}


    public long deleteSubCancerType2(int id) {
        subCancerType2Repository.delete(subCancerType2Repository.findOne(id).getId());
        return id;
    }

    public SubCancerType2 addOrUpdateSubCancerType2(String payLoad) throws JsonParseException, JsonMappingException, IOException {
        SubCancerType2 subCancerType2 = objectMapper.readValue(payLoad, SubCancerType2.class);
        int id = subCancerType2.getId() != 0? subCancerType2.getId() :(int) (subCancerType2Repository.getMaxId() +1);
        RegimenDetail regimenDetail = new RegimenDetail();
        SubCancerType2 subCancerType1 = SubCancerType2.builder()
                .id((int)(subCancerType2Repository.getMaxId() +1))
                .subCancerType1(subCancerType2.getSubCancerType1())
                .subcancertypeid(id)
                .title(subCancerType2.getTitle())
                .regimenDetails(subCancerType2.getregimenDetails())
                .build();
        return subCancerType2Repository.save(subCancerType1);
    }

}
