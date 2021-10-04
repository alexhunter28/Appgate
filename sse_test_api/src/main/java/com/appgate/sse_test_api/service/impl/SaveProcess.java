package com.appgate.sse_test_api.service.impl;

import com.appgate.sse_test_api.entity.Process;
import com.appgate.sse_test_api.repository.ProcessRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SaveProcess {

    @Autowired
    private ProcessRepository processRepository;

    public String saveProcessIntoDB(String domainChecked, ArrayList<String> similarityDomainsFound, ArrayList<String> punycodeDomainsFound, List validatedDomainList){

        Process process = new Process();
        Gson gson = new Gson();
        process.setId(UUID.randomUUID());
        process.setDate(new Date());
        process.setDomainChecked(domainChecked);
        process.setSimilarityDomainsFound(gson.toJson(similarityDomainsFound));
        process.setPunycodeDomainsFound(gson.toJson(punycodeDomainsFound));
        process.setValidatedDomainList(gson.toJson(validatedDomainList));

        Process save = processRepository.save(process);
        return save.getId().toString();
    }


}
