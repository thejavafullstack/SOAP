package com.thejavafullstack.Covid19ProfilerSoapProducer.service;

import com.thejavafullstack.Covid19ProfilerSoapProducer.model.Covid19CountryProfile;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface Covid19ProfilerService {

    @WebMethod
    public List<Covid19CountryProfile> getAllCovid19CountryProfiles();

    @WebMethod
    public Covid19CountryProfile getCovid19CountryProfile(String countryName);

    @WebMethod
    public Covid19CountryProfile updateCovid19CountryProfile(Covid19CountryProfile request);

    @WebMethod
    public Covid19CountryProfile addCovid19CountryProfile( Covid19CountryProfile request);

    @WebMethod
    public Covid19CountryProfile removeCovid19CountryProfile( String countryName );

    @WebMethod
    public Covid19CountryProfile updateNumberOfCases( int numberOfCases  ,  String countryName);

    @WebMethod
    public Covid19CountryProfile updateNumberOfRecoveries( int numberOfRecoveries  ,  String countryName);

    @WebMethod
    public Covid19CountryProfile updateNumberOfDeaths( int numberOfDeaths  ,  String countryName);
}