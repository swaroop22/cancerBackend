package com.patient.services;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patient.models.SubCancerLevels;
import com.patient.repos.SubCancerLevelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SubCancerLevelsService {

    @Autowired
    private SubCancerLevelsRepository subCancerLevelsRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<SubCancerLevels> getAllSubCancerLevels(){
        return subCancerLevelsRepository.findAll();
    }


    public long deleteSubCancerLevels(int id) {
        subCancerLevelsRepository.delete(subCancerLevelsRepository.findOne(id).getId());
        return id;
    }

    public SubCancerLevels addOrUpdateSubCancerLevels(String payLoad) throws JsonParseException, JsonMappingException, IOException {
        SubCancerLevels subCancerLevels = objectMapper.readValue(payLoad, SubCancerLevels.class);


        SubCancerLevels subCancerLevels1 = new SubCancerLevels();
        subCancerLevels1.setId(subCancerLevels.getId());
        subCancerLevels1.setTitle(subCancerLevels1.getTitle());
        subCancerLevels1.setRegimenDetail(subCancerLevels.getRegimenDetail());

        return subCancerLevels;
    }



}
