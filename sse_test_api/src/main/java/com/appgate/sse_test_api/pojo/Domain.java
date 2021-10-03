package com.appgate.sse_test_api.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class Domain {
    private String Dominio;
    private ArrayList<String> dominios_similares;
    private ArrayList<String> dominios_sim_punycode;
}
