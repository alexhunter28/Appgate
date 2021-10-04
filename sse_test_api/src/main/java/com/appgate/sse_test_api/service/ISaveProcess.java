package com.appgate.sse_test_api.service;

import java.util.ArrayList;
import java.util.List;

public interface ISaveProcess {

    public String saveProcessIntoDB(String domainChecked, ArrayList<String> similarityDomainsFound, ArrayList<String> punycodeDomainsFound, List validatedDomainList);
}
