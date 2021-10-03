package com.appgate.sse_test_api.service.impl;

import com.appgate.sse_test_api.service.IReadFile;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

@Service
public class ReadFile implements IReadFile {

    @Override
    public List readFileInList()  throws IOException {
        return Files.readAllLines(new File("src/dominios.txt").toPath(), Charset.defaultCharset() );
    }

}
