package com.appgate.sse_test_api;

import com.appgate.sse_test_api.entity.Process;
import com.appgate.sse_test_api.repository.IProcessRepository;
import com.appgate.sse_test_api.service.impl.SaveProcess;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SaveProcessTest {

    @InjectMocks
    SaveProcess saveProcess;

    @Mock
    IProcessRepository IProcessRepository;

    Process process;

    ArrayList<String> lstGeneric = new ArrayList<>();

    @Before
    public void init(){

        process = new Process();
        process.setId(UUID.fromString("F000123A-0451-4000-B000-000000000000"));
        process.setDate(new Date());
        process.setValidatedDomainList("DomainList");
        process.setDomainChecked("Domain");
        process.setSimilarityDomainsFound("SimilarityDomain");
        process.setPunycodeDomainsFound("PunycodeList");

        lstGeneric.add("list1");
        lstGeneric.add("list2");
        lstGeneric.add("list3");
        lstGeneric.add("list4");


    }

    @Test
    public void when_save_process_intoDB_return_id(){
        when(IProcessRepository.save(Mockito.any(Process.class))).thenReturn(process);
        String result = saveProcess.saveProcessIntoDB("Bancolombia.com", lstGeneric,lstGeneric,lstGeneric);
        assertEquals(result, "f000123a-0451-4000-b000-000000000000");

    }

}
