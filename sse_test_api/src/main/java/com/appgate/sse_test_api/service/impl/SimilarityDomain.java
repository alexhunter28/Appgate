package com.appgate.sse_test_api.service.impl;

import net.ricecode.similarity.StringSimilarityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appgate.sse_test_api.service.ISimilarityDomain;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimilarityDomain implements ISimilarityDomain {

    @Autowired
    private StringSimilarityService similarityService;


    @Override
    public ArrayList<String> getSimilarDomains(String target, List list) {
        ArrayList lstSimilarDomains = new ArrayList();

        list.stream().forEach(x -> {
            double score = similarityService.score(x.toString(), target);
            if(score >= 0.6){
                lstSimilarDomains.add(x);
            }
        });


        return lstSimilarDomains;
    }

}
