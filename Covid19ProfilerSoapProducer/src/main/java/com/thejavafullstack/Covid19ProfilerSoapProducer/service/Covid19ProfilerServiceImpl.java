package com.thejavafullstack.Covid19ProfilerSoapProducer.service;

import com.thejavafullstack.Covid19ProfilerSoapProducer.model.Covid19CountryProfile;
import com.thejavafullstack.Covid19ProfilerSoapProducer.dao.Covid19CountryProfilerRepository;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService(name="Covid19Profiler",
        endpointInterface = "com.thejavafullstack.Covid19ProfilerSoapProducer.service.Covid19ProfilerService",
        targetNamespace="https://www.thejavafullstack.com"
)
public class Covid19ProfilerServiceImpl implements Covid19ProfilerService {

    //@Autowired
    private Covid19CountryProfilerRepository covid19CountryProfilerRepository = new Covid19CountryProfilerRepository();

    @Override
    @WebMethod
    public List<Covid19CountryProfile> getAllCovid19CountryProfiles() {
        return covid19CountryProfilerRepository.getAllCovid19CountryProfiles();
    }

    @Override
    @WebMethod(action="getCovid19CountryProfile", operationName="getCovid19CountryProfile")
    @WebResult(name="Covid19CountryProfile")
    public Covid19CountryProfile getCovid19CountryProfile(String countryName) {
        return covid19CountryProfilerRepository.findCovid19CountryProfile(countryName);
    }

    @Override
    @WebMethod(action="updateCovid19CountryProfile", operationName="updateCovid19CountryProfile")
    @WebResult(name="Covid19CountryProfile")
    public Covid19CountryProfile updateCovid19CountryProfile(Covid19CountryProfile request) {
        return covid19CountryProfilerRepository.updateCovid19CountryProfile(request);
    }

    @Override
    @WebMethod(action="addCovid19CountryProfile", operationName="addCovid19CountryProfile")
    @WebResult(name="Covid19CountryProfile")
    public Covid19CountryProfile addCovid19CountryProfile(Covid19CountryProfile request) {
        return covid19CountryProfilerRepository.addCovid19CountryProfile(request);
    }

    @Override
    @WebMethod(action="removeCovid19CountryProfile", operationName="removeCovid19CountryProfile")
    @WebResult(name="Covid19CountryProfile")
    public Covid19CountryProfile removeCovid19CountryProfile(String countryName) {
        return covid19CountryProfilerRepository.removeCovid19CountryProfile(countryName);
    }

    @Override
    @WebMethod(action="updateNumberOfCases", operationName="updateNumberOfCases")
    @WebResult(name="Covid19CountryProfile")
    public Covid19CountryProfile updateNumberOfCases(int numberOfCases, String countryName) {
        return covid19CountryProfilerRepository.updateNumberOfCases(numberOfCases,countryName);
    }

    @Override
    @WebMethod(action="updateNumberOfRecoveries", operationName="updateNumberOfRecoveries")
    @WebResult(name="Covid19CountryProfile")
    public Covid19CountryProfile updateNumberOfRecoveries(int numberOfRecoveries, String countryName) {
        return covid19CountryProfilerRepository.updateNumberOfRecoveries(numberOfRecoveries,countryName);
    }

    @Override
    @WebMethod(action="updateNumberOfDeaths", operationName="updateNumberOfDeaths")
    @WebResult(name="Covid19CountryProfile")
    public Covid19CountryProfile updateNumberOfDeaths(int numberOfDeaths, String countryName) {
        return covid19CountryProfilerRepository.updateNumberOfDeaths(numberOfDeaths,countryName);
    }
}