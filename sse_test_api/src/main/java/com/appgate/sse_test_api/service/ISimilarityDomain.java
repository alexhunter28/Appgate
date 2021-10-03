package com.appgate.sse_test_api.service;

import com.appgate.sse_test_api.pojo.Domain;

import java.util.List;

public interface ISimilarityDomain {

    public Domain getSimilarDomains(String target, List list);
}
