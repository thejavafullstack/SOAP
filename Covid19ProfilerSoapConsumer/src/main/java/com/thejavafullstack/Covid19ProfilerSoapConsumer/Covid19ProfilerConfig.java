package com.thejavafullstack.Covid19ProfilerSoapConsumer;


import com.thejavafullstack.Covid19ProfilerSoapConsumer.service.Covid19ProfilerServiceHelper;
import com.thejavafullstack.Covid19ProfilerSoapConsumer.service.Covid19ProfilerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Covid19ProfilerConfig {

    @Bean
    public Covid19ProfilerServiceImpl Covid19ProfilerServiceImpl() {
        return new Covid19ProfilerServiceImpl();
    }

    @Bean
    public Covid19ProfilerServiceHelper Covid19ProfilerServiceHelper() {
        return new Covid19ProfilerServiceHelper();
    }
}