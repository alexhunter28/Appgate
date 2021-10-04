package com.appgate.sse_test_api.service.impl;

import com.appgate.sse_test_api.pojo.Domain;
import com.appgate.sse_test_api.service.ISaveProcess;
import com.appgate.sse_test_api.service.ISpecialDomainChecker;
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

    @Autowired
    private ISpecialDomainChecker iSpecialDomainChecker;

    @Autowired
    private ISaveProcess iSaveProcess;

    @Override
    public Domain getSimilarDomains(String target, List list) {
        ArrayList<String> lstSimilarDomains = new ArrayList();
        ArrayList<String> lstPunycodeDomains = new ArrayList();
        Domain domain = new Domain();

        list.stream().forEach(x -> {
            double score = similarityService.score(x.toString(), target);
            if(score >= 0.6){
                lstSimilarDomains.add(x.toString());
            }

            String punnyDomain = iSpecialDomainChecker.checkDomain(x.toString(), target);
            if(punnyDomain != null){
                lstPunycodeDomains.add(punnyDomain);
            }

        });

        domain.setDominio(target);
        domain.setDominios_similares(lstSimilarDomains);
        domain.setDominios_sim_punycode(lstPunycodeDomains);

        iSaveProcess.saveProcessIntoDB(target, lstSimilarDomains, lstPunycodeDomains,list);

        return domain;
    }

}
