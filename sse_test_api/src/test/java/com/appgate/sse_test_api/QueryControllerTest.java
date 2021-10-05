package com.appgate.sse_test_api;

import com.appgate.sse_test_api.controller.QueryController;
import com.appgate.sse_test_api.entity.Process;
import com.appgate.sse_test_api.repository.IProcessRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QueryControllerTest {

    @InjectMocks
    QueryController queryController;

    @Mock
    IProcessRepository IProcessRepository;

    Process process;
    List<Process> lstProcess = new ArrayList<>();

    @Before
    public void init(){

        process = new Process();
        process.setId(UUID.fromString("F000123A-0451-4000-B000-000000000000"));
        process.setDate(new Date());
        process.setValidatedDomainList("DomainList");
        process.setDomainChecked("Domain");
        process.setSimilarityDomainsFound("SimilarityDomain");
        process.setPunycodeDomainsFound("PunycodeList");

        lstProcess.add(process);

    }

    @Test
    public void getProcessedDomainsTest(){
        when(IProcessRepository.findByDomainChecked(anyString())).thenReturn(lstProcess);
        ResponseEntity<List<Process>> result = queryController.getProcessedDomains("Bancolombia.com");
        assertEquals(result.getStatusCode(), HttpStatus.OK);
    }
}
