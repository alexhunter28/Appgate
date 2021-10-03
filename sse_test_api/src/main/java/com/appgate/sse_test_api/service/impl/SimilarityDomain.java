package com.appgate.sse_test_api.service.impl;

import com.appgate.sse_test_api.pojo.Domain;
import net.ricecode.similarity.StringSimilarityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appgate.sse_test_api.service.ISimilarityDomain;

import java.net.IDN;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class SimilarityDomain implements ISimilarityDomain {

    @Autowired
    private StringSimilarityService similarityService;

    @Autowired
    private SpecialDomainChecker specialDomainChecker;

    @Override
    public Domain getSimilarDomains(String target, List list) {
        ArrayList lstSimilarDomains = new ArrayList();
        ArrayList lstPunycodeDomains = new ArrayList();
        Domain domain = new Domain();

        list.stream().forEach(x -> {
            double score = similarityService.score(x.toString(), target);
            if(score >= 0.6){
                lstSimilarDomains.add(x);
            }

            String punnyDomain = specialDomainChecker.checkDomain(x.toString(), target);
            if(punnyDomain != null){
                lstPunycodeDomains.add(punnyDomain);
            }

        });

        domain.setDominio(target);
        domain.setDominios_similares(lstSimilarDomains);
        domain.setDominios_sim_punycode(lstPunycodeDomains);

        return domain;
    }

}
