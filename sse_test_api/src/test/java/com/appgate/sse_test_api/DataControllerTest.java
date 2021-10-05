package com.appgate.sse_test_api;

import com.appgate.sse_test_api.controller.DataController;
import com.appgate.sse_test_api.pojo.Domain;
import com.appgate.sse_test_api.pojo.DynamicDomain;
import com.appgate.sse_test_api.service.impl.ReadFile;
import com.appgate.sse_test_api.service.impl.SimilarityDomain;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DataControllerTest {

    @InjectMocks
    DataController dataController;

    @Mock
    SimilarityDomain similarityDomain;

    @Mock
    ReadFile readFile;

    Domain dominio = new Domain();
    DynamicDomain dynamicDomain = new DynamicDomain();

    @Before
    public void init(){
        ArrayList<String> similars = new ArrayList<>();
        similars.add("bancolombia1amano.com.co");
        similars.add("enlineabancolombia.net");
        ArrayList<String> punycode = new ArrayList<>();
        punycode.add("banиcфlфmbia.com");
        punycode.add("ьancol0mbia.com.co");
        dominio.setDominio("Bancolombia.com");
        dominio.setDominios_similares(similars);
        dominio.setDominios_sim_punycode(punycode);

        dynamicDomain.setTarget("Bancolombia.com");
        dynamicDomain.setDomainList(Arrays.asList( "olinmarcus.world.",
                "olympia.world.",
                "bancolombia1amano.com.co",
                "opendata.world.",
                "osrxj.world.",
                "ovazl.world."));
    }


    @Test
    public void checkDataStatic() throws Exception {
        when(similarityDomain.getSimilarDomains(anyString(),anyList())).thenReturn(dominio);
        when(readFile.readFileInList("dominios.txt")).thenReturn(Arrays.asList("Lista1", "Lista2"));
        ResponseEntity<Domain> result = dataController.checkDataStatic("Bancolombia.com");
        assertEquals(result.getStatusCode(), HttpStatus.OK);
        assertEquals(result.getBody().getDominio(), "Bancolombia.com");
    }

    @Test
    public void checkDataDyamic() {
        when(similarityDomain.getSimilarDomains(anyString(),anyList())).thenReturn(dominio);
        ResponseEntity<Domain> result = dataController.checkDataDynamic(dynamicDomain);
        assertEquals(result.getStatusCode(), HttpStatus.OK);
        assertEquals(result.getBody().getDominio(), "Bancolombia.com");

    }

}
