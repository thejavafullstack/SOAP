package com.thejavafullstack.Covid19ProfilerSoapProducer.service;

import com.thejavafullstack.Covid19ProfilerSoapProducer.model.Covid19CountryProfile;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService(name="Covid19ProfilerService",
        targetNamespace="http://www.thejavafullstack.com")
public interface Covid19ProfilerService {

    @WebMethod(action="getAllCovid19CountryProfiles", operationName="getAllCovid19CountryProfiles")
    @WebResult(name="Covid19CountryProfiles")
    public List<Covid19CountryProfile> getAllCovid19CountryProfiles();

    
    @WebMethod(action="getCovid19CountryProfile", operationName="getCovid19CountryProfile")
    @WebResult(name="Covid19CountryProfile")
    public Covid19CountryProfile getCovid19CountryProfile(@WebParam(name = "countryName") String countryName);

    
    @WebMethod(action="updateCovid19CountryProfile", operationName="updateCovid19CountryProfile")
    @WebResult(name="Covid19CountryProfile")
    public Covid19CountryProfile updateCovid19CountryProfile(@WebParam(name = "covid19CountryProfile") Covid19CountryProfile covid19CountryProfile);

    
    @WebMethod(action="addCovid19CountryProfile", operationName="addCovid19CountryProfile")
    @WebResult(name="Covid19CountryProfile")
    public Covid19CountryProfile addCovid19CountryProfile(@WebParam(name = "covid19CountryProfile") Covid19CountryProfile covid19CountryProfile);

    
    @WebMethod(action="removeCovid19CountryProfile", operationName="removeCovid19CountryProfile")
    @WebResult(name="Covid19CountryProfile")
    public Covid19CountryProfile removeCovid19CountryProfile(@WebParam(name = "countryName") String countryName);

    
    @WebMethod(action="updateNumberOfCases", operationName="updateNumberOfCases")
    @WebResult(name="Covid19CountryProfile")
    public Covid19CountryProfile updateNumberOfCases(@WebParam(name = "numberOfCases") int numberOfCases, @WebParam(name = "countryName") String countryName);

    
    @WebMethod(action="updateNumberOfRecoveries", operationName="updateNumberOfRecoveries")
    @WebResult(name="Covid19CountryProfile")
    public Covid19CountryProfile updateNumberOfRecoveries(@WebParam(name = "numberOfRecoveries") int numberOfRecoveries, @WebParam(name = "countryName") String countryName);

    
    @WebMethod(action="updateNumberOfDeaths", operationName="updateNumberOfDeaths")
    @WebResult(name="Covid19CountryProfile")
    public Covid19CountryProfile updateNumberOfDeaths(@WebParam(name = "numberOfDeaths") int numberOfDeaths, @WebParam(name = "countryName")  String countryName);
}