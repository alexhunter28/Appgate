package com.appgate.sse_test_api.controller;

import com.appgate.sse_test_api.pojo.Domain;
import com.appgate.sse_test_api.pojo.DynamicDomain;
import com.appgate.sse_test_api.service.IReadFile;
import com.appgate.sse_test_api.service.ISimilarityDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("data/check")
public class DataController {

    @Autowired
    ISimilarityDomain iSimilarityDomain;

    @Autowired
    IReadFile iReadFile;

    @PostMapping("/static")
    public ResponseEntity<Domain> checkDataStatic(@RequestParam("target") String target, @RequestParam("source") String source) throws IOException {

         return  new ResponseEntity<>(iSimilarityDomain.getSimilarDomains(target, iReadFile.readFileInList()), HttpStatus.OK);
    }

    @PostMapping("/dynamic")
    public ResponseEntity<Domain> checkDataDynamic(@RequestBody DynamicDomain body){
        return  new ResponseEntity<>(iSimilarityDomain.getSimilarDomains(body.getTarget(), body.getDomainList()), HttpStatus.OK);
    }

}
