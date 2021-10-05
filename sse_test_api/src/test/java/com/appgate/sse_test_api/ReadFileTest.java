package com.appgate.sse_test_api;

import com.appgate.sse_test_api.service.impl.ReadFile;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReadFileTest {

    @InjectMocks
    ReadFile readFile;

    @Test
    public void when_get_a_file_return_a_list() throws Exception {
        List result = readFile.readFileInList("dominios.txt");
        assertEquals(result.get(0), "a-l-x-factory.academy.");
    }
}
