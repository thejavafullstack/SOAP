package com.thejavafullstack.Covid19ProfilerSoapConsumer.service;

import com.thejavafullstack.Covid19ProfilerSoapConsumer.model.Covid19CountryProfileModel;

import java.util.List;

public interface Covid19ProfilerService {
    public Covid19CountryProfileModel getCovid19CountryProfile(String countryName);
    public List<Covid19CountryProfileModel> getAllCovid19CountryProfiles();
    public Covid19CountryProfileModel addCovid19CountryProfile(Covid19CountryProfileModel Covid19CountryProfileModel);
    public Covid19CountryProfileModel removeCovid19CountryProfile(String countryName);
    public Covid19CountryProfileModel updateCovid19CountryProfile(Covid19CountryProfileModel Covid19CountryProfileModel);
    public Covid19CountryProfileModel updateNumberOfCases(int numberOfCases, String countryName);
    public Covid19CountryProfileModel updateNumberOfDeaths(int numberOfDeaths, String countryName);
    public Covid19CountryProfileModel updateNumberOfRecoveries(int numberOfRecoveries, String countryName);
}