package com.appgate.sse_test_api;

import com.appgate.sse_test_api.service.impl.SpecialDomainChecker;
import net.ricecode.similarity.StringSimilarityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SpecialDomainCheckerTest {

    @InjectMocks
    SpecialDomainChecker specialDomainChecker;

    @Mock
    StringSimilarityService similarityService;


    @Test
    public void when_check_domain_return_null(){
        when(similarityService.score(anyString(),anyString())).thenReturn(0.5D);
        String result = specialDomainChecker.checkDomain("rentallife.net.", "Bancolombia.com");
        assertNull(result);
    }

    @Test
    public void  when_check_domain_return_null_when_score_is_under_limit(){
        when(similarityService.score(anyString(),anyString())).thenReturn(0.3D);
        String result = specialDomainChecker.checkDomain("xn--banclmbia-d1h7kb.com", "Bancolombia.com");
        assertNull(result);
    }

    @Test
    public void when_check_domain_return_valid_similar_punicode_domain(){
        when(similarityService.score(anyString(),anyString())).thenReturn(0.6D);
        String result = specialDomainChecker.checkDomain("xn--banclmbia-d1h7kb.com", "Bancolombia.com");
        assertEquals(result, "banиcфlфmbia.com");
    }

}
