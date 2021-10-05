package com.appgate.sse_test_api.controller;

import com.appgate.sse_test_api.entity.Process;
import com.appgate.sse_test_api.repository.IProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("data/find")
public class QueryController {

    @Autowired
    IProcessRepository iProcessRepository;

    @GetMapping("/domain")
    public ResponseEntity<List<Process>> getProcessedDomains(@RequestParam("domain") String domain){
        return  new ResponseEntity<>(iProcessRepository.findByDomainChecked(domain), HttpStatus.OK);
    }

}
