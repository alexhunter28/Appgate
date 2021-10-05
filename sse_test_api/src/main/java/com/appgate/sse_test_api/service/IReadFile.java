package com.appgate.sse_test_api.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface IReadFile {
    public List readFileInList(String filename) throws Exception;
}
