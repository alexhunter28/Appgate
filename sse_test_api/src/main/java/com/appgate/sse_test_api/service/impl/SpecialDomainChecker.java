package com.appgate.sse_test_api.service.impl;

import com.appgate.sse_test_api.service.ISpecialDomainChecker;
import net.ricecode.similarity.StringSimilarityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.IDN;

@Service
public class SpecialDomainChecker implements ISpecialDomainChecker {

    @Autowired
    private StringSimilarityService similarityService;

    @Override
    public String checkDomain(String domain, String target) {
        String punycode = IDN.toUnicode(domain);
        double score = similarityService.score(punycode, target);

        if(!domain.equals(punycode)) {
            if (score >= 0.4) {
                return punycode;
            } else {
                return null;
            }
        }else{
            return null;
        }
    }
}
