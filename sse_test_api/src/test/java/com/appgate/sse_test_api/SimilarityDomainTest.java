package com.appgate.sse_test_api;

import com.appgate.sse_test_api.pojo.Domain;
import com.appgate.sse_test_api.service.impl.SaveProcess;
import com.appgate.sse_test_api.service.impl.SimilarityDomain;
import com.appgate.sse_test_api.service.impl.SpecialDomainChecker;
import net.ricecode.similarity.StringSimilarityService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SimilarityDomainTest {

    @InjectMocks
    SimilarityDomain similarityDomain;

    @Mock
    StringSimilarityService similarityService;

    @Mock
    SpecialDomainChecker specialDomainChecker;

    @Mock
    SaveProcess saveProcess;

    List list = new ArrayList<String>();


    @Before
    public void init(){
        list.add("xn--banclmbia-d1h7kb.com");
        list.add("bancolombia1amano.com.co");
        list.add("enlineabancolombia.net");
    }

    @Test
    public void when_similarity_service_return_data(){
        when(similarityService.score(anyString(),anyString())).thenReturn(0.65D);
        when(specialDomainChecker.checkDomain(anyString(),anyString())).thenReturn("banиcфlфmbia.com");
        when(saveProcess.saveProcessIntoDB(anyString(),any(), any(), anyList())).thenReturn(null);

        Domain domain = similarityDomain.getSimilarDomains("Bancolombia.com", list);
        System.out.println(domain.getDominio());
        System.out.println(domain.getDominios_similares());
        System.out.println(domain.getDominios_sim_punycode());

    }
}
