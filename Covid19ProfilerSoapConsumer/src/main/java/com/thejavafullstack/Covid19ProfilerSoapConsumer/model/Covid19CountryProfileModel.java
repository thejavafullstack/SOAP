package com.thejavafullstack.Covid19ProfilerSoapConsumer.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Covid19CountryProfileModel {
    private String countryName;
    private Integer numberOfCases;
    private Integer numberOfDeaths;
    private Integer numberOfRecoveries;
}
