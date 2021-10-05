package com.appgate.sse_test_api.config;

import net.ricecode.similarity.DiceCoefficientStrategy;
import net.ricecode.similarity.SimilarityStrategy;
import net.ricecode.similarity.StringSimilarityService;
import net.ricecode.similarity.StringSimilarityServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public StringSimilarityService similarityService(){
        SimilarityStrategy strategy = new DiceCoefficientStrategy();
        return new StringSimilarityServiceImpl(strategy);
    }

}
