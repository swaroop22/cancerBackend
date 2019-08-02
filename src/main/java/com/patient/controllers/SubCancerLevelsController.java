package com.patient.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.patient.models.SubCancerLevels;
import com.patient.services.SubCancerLevelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class SubCancerLevelsController {


    @Autowired
    private SubCancerLevelsService subCancerLevelsService;

    @RequestMapping(value = "/subCancerLevelsControllerById", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<SubCancerLevels> getSubCancerType1Controller() {
        return subCancerLevelsService.getAllSubCancerLevels();
    }



    @RequestMapping(value = "/ssubCancerLevelsControllerById/add", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public SubCancerLevels addSubCancerType1(@RequestBody String payLoad)
            throws JsonParseException, JsonMappingException, IOException {
        return subCancerLevelsService.addOrUpdateSubCancerLevels(payLoad);
    }

    @RequestMapping(value = "/subCancerLevelsControllerById/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public SubCancerLevels UpdateSubCancerType1(@RequestBody String payLoad)
            throws JsonParseException, JsonMappingException, IOException {
        return subCancerLevelsService.addOrUpdateSubCancerLevels(payLoad);
    }
    /**
     * This method is used to delete the subCancerType1.
     *
     * @parampayLoad
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping(value = "/subCancerLevelsControllerById/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public long deleteSubCancerType1(@PathVariable("id") int id) {
        subCancerLevelsService.deleteSubCancerLevels(id);
        return id;
    }
}
