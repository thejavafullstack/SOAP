package com.thejavafullstack.Covid19ProfilerSoapConsumer.service;

import com.thejavafullstack.Covid19ProfilerSoapConsumer.model.Covid19CountryProfileModel;
import com.thejavafullstack.service.covid19profiler.stub.Covid19CountryProfile;
import lombok.extern.java.Log;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Log
@Stateless
public class Covid19ProfilerServiceImpl implements Covid19ProfilerService {
    private static final String COVID_19_PROFILER_SERVICE = "Covid-19-Profiler-Service";
    private static final String ERROR_MESSAGE_TEMPLATE = "Unexpected %s:%s";
    private static final String SUCCESS_MESSAGE_TEMPLATE = "Success %s:%s";
    private static final String COVID_19_PROFILER_REQUEST_TEMPLATE = "Request %s:%s";
    private static final String COVID_19_PROFILER_RESPONSE_TEMPLATE = "Response %s:%s";
    private static final String WSDL_LOCATION ="http://localhost:8082/service/covid19-country-profiler?wsdl";

    @Inject
    private Covid19ProfilerServiceHelper covid19ProfilerServiceHelper;

    private Covid19CountryProfileModel convertCovid19CountryProfileDtoToModel(Covid19CountryProfile covid19CountryProfileDto){
        Covid19CountryProfileModel covid19CountryProfileModel = Covid19CountryProfileModel.builder()
                .countryName(covid19CountryProfileDto.getCountryName())
                .numberOfCases(covid19CountryProfileDto.getNumberOfCases())
                .numberOfDeaths(covid19CountryProfileDto.getNumberOfDeaths())
                .numberOfRecoveries(covid19CountryProfileDto.getNumberOfRecoveries())
                .build();
        return covid19CountryProfileModel;
    }

    private Covid19CountryProfile convertCovid19CountryProfileModelToDto(Covid19CountryProfileModel covid19CountryProfileModel){
        Covid19CountryProfile covid19CountryProfileDto = new Covid19CountryProfile();
        covid19CountryProfileDto.setCountryName(covid19CountryProfileModel.getCountryName());
        covid19CountryProfileDto.setNumberOfCases(covid19CountryProfileModel.getNumberOfCases());
        covid19CountryProfileDto.setNumberOfDeaths(covid19CountryProfileModel.getNumberOfDeaths());
        covid19CountryProfileDto.setNumberOfRecoveries(covid19CountryProfileModel.getNumberOfRecoveries());
        return covid19CountryProfileDto;
    }

    @Override
    public Covid19CountryProfileModel getCovid19CountryProfile(String countryName){
        log.info(String.format(COVID_19_PROFILER_REQUEST_TEMPLATE, COVID_19_PROFILER_SERVICE, countryName));

        Covid19CountryProfile covid19CountryProfileResponse = covid19ProfilerServiceHelper.getCovid19CountryProfile(countryName);

        if(covid19CountryProfileResponse != null)
            log.fine(String.format(COVID_19_PROFILER_RESPONSE_TEMPLATE, COVID_19_PROFILER_SERVICE, covid19CountryProfileResponse.toString()));

        return convertCovid19CountryProfileDtoToModel(covid19CountryProfileResponse);
    }

    @Override
    public List<Covid19CountryProfileModel> getAllCovid19CountryProfiles(){
        List<Covid19CountryProfileModel> listOfCovid19CountryProfileModel = new ArrayList<>();
        List<Covid19CountryProfile>  listOfCovid19CountryProfileDto = covid19ProfilerServiceHelper.getAllCovid19CountryProfiles();

        for (Covid19CountryProfile covid19CountryProfileDto :listOfCovid19CountryProfileDto) {
            listOfCovid19CountryProfileModel.add(convertCovid19CountryProfileDtoToModel(covid19CountryProfileDto));
        }
         return listOfCovid19CountryProfileModel;
    }

    @Override
    public Covid19CountryProfileModel addCovid19CountryProfile(Covid19CountryProfileModel covid19CountryProfileModel){

        Covid19CountryProfile covid19CountryProfileDto = convertCovid19CountryProfileModelToDto(covid19CountryProfileModel);

        return convertCovid19CountryProfileDtoToModel(covid19ProfilerServiceHelper.addCovid19CountryProfile(covid19CountryProfileDto));
    }

    @Override
    public Covid19CountryProfileModel removeCovid19CountryProfile(String countryName){
        return convertCovid19CountryProfileDtoToModel(covid19ProfilerServiceHelper.removeCovid19CountryProfile(countryName));
    }

    @Override
    public Covid19CountryProfileModel updateCovid19CountryProfile(Covid19CountryProfileModel covid19CountryProfileModel){
        Covid19CountryProfile covid19CountryProfileDto = convertCovid19CountryProfileModelToDto(covid19CountryProfileModel);
        return convertCovid19CountryProfileDtoToModel(covid19ProfilerServiceHelper.updateCovid19CountryProfile(covid19CountryProfileDto));
    }

    @Override
    public Covid19CountryProfileModel updateNumberOfCases(int numberOfCases, String countryName){
        return convertCovid19CountryProfileDtoToModel(covid19ProfilerServiceHelper.updateNumberOfCases(numberOfCases,countryName));
    }

    @Override
    public Covid19CountryProfileModel updateNumberOfDeaths(int numberOfDeaths, String countryName){
        return convertCovid19CountryProfileDtoToModel(covid19ProfilerServiceHelper.updateNumberOfDeaths(numberOfDeaths,countryName));
    }

    @Override
    public Covid19CountryProfileModel updateNumberOfRecoveries(int numberOfRecoveries, String countryName){
        return convertCovid19CountryProfileDtoToModel(covid19ProfilerServiceHelper.updateNumberOfRecoveries(numberOfRecoveries,countryName));
    }
}