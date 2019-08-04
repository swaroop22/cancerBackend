package com.patient.services;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patient.models.RegimenDetail;
import com.patient.models.SubCancerLevels;
import com.patient.repos.RegimenDetailRepository;
import com.patient.repos.SubCancerLevelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubCancerLevelsService {

    @Autowired
    private SubCancerLevelsRepository subCancerLevelsRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired private RegimenDetailRepository regimenDetailRepository;

    String regimenIds = String.valueOf(0);

    public List<SubCancerLevels> getAllSubCancerLevels(){
       List<SubCancerLevels> subCancerLevelsList = subCancerLevelsRepository.findAll();

       for(int i=0; i < subCancerLevelsList.size(); i++){
           String regimens = subCancerLevelsList.get(i).getRegimenDetail();
           String[] regimensInt = regimens.split(" ");
           List<RegimenDetail> regimenDetailList = new ArrayList<>();

           for (int z =1; z < regimensInt.length; z++){
               RegimenDetail regimenDetail =  regimenDetailRepository.findOne(Long.valueOf(regimensInt[z]));
               regimenDetailList.add(regimenDetail);

           }

           System.out.println("list"+regimenDetailList);
           subCancerLevelsList.get(i).setRegimenDetailList(regimenDetailList);
       }

       return subCancerLevelsList;
    }


    public long deleteSubCancerLevels(int id) {
        subCancerLevelsRepository.delete(subCancerLevelsRepository.findOne(id).getId());
        return id;
    }

    public SubCancerLevels addOrUpdateSubCancerLevels(String payLoad) throws JsonParseException, JsonMappingException, IOException {
        SubCancerLevels subCancerLevels = objectMapper.readValue(payLoad, SubCancerLevels.class);
        List<RegimenDetail> regimenDetailList = subCancerLevels.getRegimenDetailList();

        for(int i=0; i <= regimenDetailList.size()-1; i ++){
            regimenIds = regimenIds + " "+regimenDetailList.get(i).id;
        }

        SubCancerLevels subCancerLevels1 = new SubCancerLevels();
        subCancerLevels1.setId(subCancerLevels.getId());
        subCancerLevels1.setTitle(subCancerLevels1.getTitle());
        subCancerLevels.setRegimenDetail(regimenIds);

        return subCancerLevelsRepository.save(subCancerLevels);
    }



}
