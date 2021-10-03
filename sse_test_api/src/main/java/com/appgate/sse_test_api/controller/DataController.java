package com.appgate.sse_test_api.controller;

import com.appgate.sse_test_api.service.IReadFile;
import com.appgate.sse_test_api.service.ISimilarityDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("data")
public class DataController {

    @Autowired
    ISimilarityDomain iSimilarityDomain;

    @Autowired
    IReadFile iReadFile;

    @GetMapping("evaluate")
    public String getData(@RequestParam("target") String target, @RequestParam("source") String source) throws IOException {

        ArrayList<String> list = iSimilarityDomain.getSimilarDomains(target, iReadFile.readFileInList());
        return "Score dsfsdf: " + list;
    }
}
