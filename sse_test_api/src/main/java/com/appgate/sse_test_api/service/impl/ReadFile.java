package com.appgate.sse_test_api.service.impl;

import com.appgate.sse_test_api.service.IReadFile;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReadFile implements IReadFile {

    @Override
    public List readFileInList(String filename) throws Exception {

        List<String> list = new ArrayList<>();
        InputStream in = getClass().getResourceAsStream("/" + filename);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            while (br.ready()) {
                list.add(br.readLine());
            }
        }
        return list;
    }

}
