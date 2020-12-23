package com.thejavafullstack.Covid19ProfilerSoapProducer.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.thejavafullstack.Covid19ProfilerSoapProducer.model.Covid19CountryProfile;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class Covid19CountryProfilerRepository {
	private static final Map<String, Covid19CountryProfile> COVID_19_COUNTRY_PROFILE_MAP = new HashMap<>();

	@PostConstruct
	public void initData() {

		Covid19CountryProfile covid19CountryProfile = new Covid19CountryProfile();
		covid19CountryProfile.setCountryName("SA");
		covid19CountryProfile.setNumberOfCases(5000);
		covid19CountryProfile.setNumberOfRecoveries(4000);
		covid19CountryProfile.setNumberOfDeaths(1000);
		COVID_19_COUNTRY_PROFILE_MAP.put(covid19CountryProfile.getCountryName(), covid19CountryProfile);
		
		covid19CountryProfile = new Covid19CountryProfile();
		covid19CountryProfile.setCountryName("India");
		covid19CountryProfile.setNumberOfCases(10000);
		covid19CountryProfile.setNumberOfRecoveries(9000);
		covid19CountryProfile.setNumberOfDeaths(1000);
		COVID_19_COUNTRY_PROFILE_MAP.put(covid19CountryProfile.getCountryName(), covid19CountryProfile);

		covid19CountryProfile = new Covid19CountryProfile();
		covid19CountryProfile.setCountryName("USA");
		covid19CountryProfile.setNumberOfCases(15000);
		covid19CountryProfile.setNumberOfRecoveries(14000);
		covid19CountryProfile.setNumberOfDeaths(1000);
		COVID_19_COUNTRY_PROFILE_MAP.put(covid19CountryProfile.getCountryName(), covid19CountryProfile);

		covid19CountryProfile = new Covid19CountryProfile();
		covid19CountryProfile.setCountryName("China");
		covid19CountryProfile.setNumberOfCases(20000);
		covid19CountryProfile.setNumberOfRecoveries(19000);
		covid19CountryProfile.setNumberOfDeaths(1000);
		COVID_19_COUNTRY_PROFILE_MAP.put(covid19CountryProfile.getCountryName(), covid19CountryProfile);


	}

	public List<Covid19CountryProfile> getAllCovid19CountryProfiles() {
		return new ArrayList<Covid19CountryProfile>(COVID_19_COUNTRY_PROFILE_MAP.values());
	}

	public Covid19CountryProfile findCovid19CountryProfile(String countryName) {
		Assert.notNull(countryName, "The countryName must not be null");
		return COVID_19_COUNTRY_PROFILE_MAP.get(countryName);
	}

	public Covid19CountryProfile updateCovid19CountryProfile(Covid19CountryProfile covid19CountryProfile) {
		Assert.notNull(covid19CountryProfile, "The covid19CountryProfile must not be null");
		Covid19CountryProfile covid19CountryProfileToBeUpdated = COVID_19_COUNTRY_PROFILE_MAP.get(covid19CountryProfile.getCountryName());
		covid19CountryProfileToBeUpdated.setCountryName(covid19CountryProfile.getCountryName());
		covid19CountryProfileToBeUpdated.setNumberOfCases(covid19CountryProfile.getNumberOfCases());
		covid19CountryProfileToBeUpdated.setNumberOfRecoveries(covid19CountryProfile.getNumberOfRecoveries());
		covid19CountryProfileToBeUpdated.setNumberOfDeaths(covid19CountryProfile.getNumberOfDeaths());
		COVID_19_COUNTRY_PROFILE_MAP.put(covid19CountryProfile.getCountryName(),covid19CountryProfileToBeUpdated);
		return covid19CountryProfileToBeUpdated;
	}

	public Covid19CountryProfile addCovid19CountryProfile(Covid19CountryProfile covid19CountryProfile) {
		Assert.notNull(covid19CountryProfile, "The covid19CountryProfile must not be null");
		COVID_19_COUNTRY_PROFILE_MAP.put(covid19CountryProfile.getCountryName(),covid19CountryProfile);
		return covid19CountryProfile;
	}

	public Covid19CountryProfile removeCovid19CountryProfile(String countryName) {
		Assert.notNull(countryName, "The countryName must not be null");
		Covid19CountryProfile covid19CountryProfileToBeRemoved = COVID_19_COUNTRY_PROFILE_MAP.get(countryName);
		COVID_19_COUNTRY_PROFILE_MAP.remove(countryName);
		return covid19CountryProfileToBeRemoved;
	}

	public Covid19CountryProfile updateNumberOfCases(int numberOfCases, String countryName) {
		Assert.notNull(countryName, "The countryName must not be null");
		Covid19CountryProfile covid19CountryProfileToBeUpdated = COVID_19_COUNTRY_PROFILE_MAP.get(countryName);
		covid19CountryProfileToBeUpdated.setNumberOfCases(numberOfCases);
		COVID_19_COUNTRY_PROFILE_MAP.put(countryName,covid19CountryProfileToBeUpdated);
		return covid19CountryProfileToBeUpdated;
	}

	public Covid19CountryProfile updateNumberOfDeaths(int numberOfDeaths, String countryName) {
		Assert.notNull(countryName, "The countryName must not be null");
		Covid19CountryProfile covid19CountryProfileToBeUpdated = COVID_19_COUNTRY_PROFILE_MAP.get(countryName);
		covid19CountryProfileToBeUpdated.setNumberOfDeaths(numberOfDeaths);
		COVID_19_COUNTRY_PROFILE_MAP.put(countryName,covid19CountryProfileToBeUpdated);
		return covid19CountryProfileToBeUpdated;
	}

	public Covid19CountryProfile updateNumberOfRecoveries(int numberOfRecoveries, String countryName) {
		Assert.notNull(countryName, "The countryName must not be null");
		Covid19CountryProfile covid19CountryProfileToBeUpdated = COVID_19_COUNTRY_PROFILE_MAP.get(countryName);
		covid19CountryProfileToBeUpdated.setNumberOfRecoveries(numberOfRecoveries);
		COVID_19_COUNTRY_PROFILE_MAP.put(countryName,covid19CountryProfileToBeUpdated);
		return covid19CountryProfileToBeUpdated;
	}
}