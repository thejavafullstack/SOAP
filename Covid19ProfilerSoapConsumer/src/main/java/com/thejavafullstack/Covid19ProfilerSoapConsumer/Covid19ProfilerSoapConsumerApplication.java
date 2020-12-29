package com.thejavafullstack.Covid19ProfilerSoapConsumer;

import com.thejavafullstack.Covid19ProfilerSoapConsumer.model.Covid19CountryProfileModel;
import com.thejavafullstack.Covid19ProfilerSoapConsumer.service.Covid19ProfilerServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Covid19ProfilerSoapConsumerApplication {
	public static void main(String[] args) {

		SpringApplication.run(Covid19ProfilerSoapConsumerApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(Covid19ProfilerServiceImpl covid19ProfilerService) {
		return args -> {
			String countryName = "SA";

			if (args.length > 0) {
				countryName = args[0];
			}
			getCovid19CountryProfile(covid19ProfilerService,countryName);
			getAllCovid19CountryProfiles(covid19ProfilerService);
		};
	}

	private void getCovid19CountryProfile(Covid19ProfilerServiceImpl covid19ProfilerService, String countryName){
		Covid19CountryProfileModel response = covid19ProfilerService.getCovid19CountryProfile(countryName);
		System.out.println("*********** Fetching covid19Profiler for "+ countryName +" *************");
		System.out.println("Country Name = "+response.getCountryName());
		System.out.println("Number of cases = "+response.getNumberOfCases());
		System.out.println("Number of Deaths = "+response.getNumberOfDeaths());
		System.out.println("Number of Recoveries = "+response.getNumberOfRecoveries());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");

	}

	private void getAllCovid19CountryProfiles(Covid19ProfilerServiceImpl covid19ProfilerService){
		System.out.println("*************** Fetching all Covid19CountryProfiles  ******************");

		List<Covid19CountryProfileModel> covid19CountryProfileModelList = covid19ProfilerService.getAllCovid19CountryProfiles();
		for (Covid19CountryProfileModel covid19CountryProfileModel:covid19CountryProfileModelList) {
			System.out.println("Country Name = "+covid19CountryProfileModel.getCountryName());
			System.out.println("Number of cases = "+covid19CountryProfileModel.getNumberOfCases());
			System.out.println("Number of Deaths = "+covid19CountryProfileModel.getNumberOfDeaths());
			System.out.println("Number of Recoveries = "+covid19CountryProfileModel.getNumberOfRecoveries());
			System.out.println("------");
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
	}
}