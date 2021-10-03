package com.appgate.sse_test_api.pojo;

import lombok.Data;

import java.util.List;

@Data
public class DynamicDomain {
    private String target;
    private List domainList;
}
