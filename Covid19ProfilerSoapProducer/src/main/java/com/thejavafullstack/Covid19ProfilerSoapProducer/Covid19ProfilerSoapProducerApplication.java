package com.thejavafullstack.Covid19ProfilerSoapProducer;

import com.thejavafullstack.Covid19ProfilerSoapProducer.service.Covid19ProfilerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.ws.Endpoint;

@SpringBootApplication
public class Covid19ProfilerSoapProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19ProfilerSoapProducerApplication.class, args);

		Endpoint.publish(
				"http://localhost:8082/service/covid19-country-profiler",
				new Covid19ProfilerServiceImpl());
	}
}