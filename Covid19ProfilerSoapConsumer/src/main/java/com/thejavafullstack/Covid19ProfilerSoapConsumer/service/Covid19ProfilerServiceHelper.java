package com.thejavafullstack.Covid19ProfilerSoapConsumer.service;

import com.thejavafullstack.Covid19ProfilerSoapConsumer.exception.Covid19ProfilerServiceFailedException;
import com.thejavafullstack.service.covid19profiler.stub.Covid19CountryProfile;
import com.thejavafullstack.service.covid19profiler.stub.Covid19ProfilerService;
import com.thejavafullstack.service.covid19profiler.stub.Covid19ProfilerService_Service;
import lombok.extern.java.Log;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Log
@Stateless
public class Covid19ProfilerServiceHelper {
    private static final String COVID_19_PROFILER_SERVICE = "Covid-19-Profiler-Service";
    private static final String ERROR_MESSAGE_TEMPLATE = "Unexpected %s:%s";
    private static final String SUCCESS_MESSAGE_TEMPLATE = "Success %s:%s";
    private static final String WSDL_LOCATION ="http://localhost:8082/service/covid19-country-profiler?wsdl";

    private Covid19ProfilerService covid19Profiler;

    @PostConstruct
    private void init() throws Covid19ProfilerServiceFailedException {
        try {
            log.info(String.format("Connecting to %s ...",COVID_19_PROFILER_SERVICE));

            URL wsdlUrl = new URL(WSDL_LOCATION);
            Covid19ProfilerService_Service covid19ProfilerServiceConnector = new Covid19ProfilerService_Service(wsdlUrl);
            covid19Profiler = covid19ProfilerServiceConnector.getCovid19ProfilerPort();

            if(covid19Profiler != null)
                log.fine(String.format(SUCCESS_MESSAGE_TEMPLATE, COVID_19_PROFILER_SERVICE, "Connected to Covid19Profiler Service."));

        } catch (MalformedURLException ex) {
            log.severe(String.format(ERROR_MESSAGE_TEMPLATE, COVID_19_PROFILER_SERVICE, "Failed to call the Covid19Profiler Service!!"));
            throw new Covid19ProfilerServiceFailedException(String.format(ERROR_MESSAGE_TEMPLATE, COVID_19_PROFILER_SERVICE, ex.getMessage()));
        } catch (Exception ex) {
            log.severe(String.format(ERROR_MESSAGE_TEMPLATE, COVID_19_PROFILER_SERVICE, "There was some problem connecting to the Covid19Profiler Service!!"));
            throw new Covid19ProfilerServiceFailedException(String.format(ERROR_MESSAGE_TEMPLATE, COVID_19_PROFILER_SERVICE, ex.getMessage()));
        }
    }

    public Covid19CountryProfile getCovid19CountryProfile(String countryName){
         return covid19Profiler.getCovid19CountryProfile(countryName);
    }

    public List<Covid19CountryProfile> getAllCovid19CountryProfiles(){
        return covid19Profiler.getAllCovid19CountryProfiles();
    }

    public Covid19CountryProfile addCovid19CountryProfile(Covid19CountryProfile covid19CountryProfile){
        return covid19Profiler.addCovid19CountryProfile(covid19CountryProfile);
    }

    public Covid19CountryProfile removeCovid19CountryProfile(String countryName){
        return covid19Profiler.removeCovid19CountryProfile(countryName);
    }

    public Covid19CountryProfile updateCovid19CountryProfile(Covid19CountryProfile covid19CountryProfile){
        return covid19Profiler.updateCovid19CountryProfile(covid19CountryProfile);
    }

    public Covid19CountryProfile updateNumberOfCases(int numberOfCases, String countryName){
        return covid19Profiler.updateNumberOfCases(numberOfCases,countryName);
    }

    public Covid19CountryProfile updateNumberOfDeaths(int numberOfDeaths, String countryName){
        return covid19Profiler.updateNumberOfDeaths(numberOfDeaths,countryName);
    }

    public Covid19CountryProfile updateNumberOfRecoveries(int numberOfRecoveries, String countryName){
        return covid19Profiler.updateNumberOfRecoveries(numberOfRecoveries,countryName);
    }
}