package com.thejavafullstack.Covid19ProfilerSoapProducer.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Objects;

@XmlRootElement(name="Covid19CountryProfile")
@XmlType(propOrder = { "countryName","numberOfCases","numberOfDeaths","numberOfRecoveries"})
public class Covid19CountryProfile implements Serializable {
    private static final long serialVersionUID = 1L;

    private String countryName;
    private Integer numberOfCases;
    private Integer numberOfDeaths;
    private Integer numberOfRecoveries;

    public Covid19CountryProfile() {

    }

    public Covid19CountryProfile(Long countryId, String countryName, Integer numberOfCases, Integer numberOfDeaths, Integer numberOfRecoveries) {
        this.countryName = countryName;
        this.numberOfCases = numberOfCases;
        this.numberOfDeaths = numberOfDeaths;
        this.numberOfRecoveries = numberOfRecoveries;
    }


    @XmlElement(name="CountryName")
    public String getCountryName() { return countryName; }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @XmlElement(name="NumberOfCases")
    public Integer getNumberOfCases() {
        return numberOfCases;
    }

    public void setNumberOfCases(Integer numberOfCases) {
        this.numberOfCases = numberOfCases;
    }

    @XmlElement(name="NumberOfDeaths")
    public Integer getNumberOfDeaths() {
        return numberOfDeaths;
    }

    public void setNumberOfDeaths(Integer numberOfDeaths) {
        this.numberOfDeaths = numberOfDeaths;
    }

    @XmlElement(name="NumberOfRecoveries")
    public Integer getNumberOfRecoveries() {
        return numberOfRecoveries;
    }

    public void setNumberOfRecoveries(Integer numberOfRecoveries) {
        this.numberOfRecoveries = numberOfRecoveries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Covid19CountryProfile)) return false;
        Covid19CountryProfile that = (Covid19CountryProfile) o;
        return Objects.equals(countryName, that.countryName) &&
                Objects.equals(numberOfCases, that.numberOfCases) &&
                Objects.equals(numberOfDeaths, that.numberOfDeaths) &&
                Objects.equals(numberOfRecoveries, that.numberOfRecoveries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryName, numberOfCases, numberOfDeaths, numberOfRecoveries);
    }

    @Override
    public String toString() {
        return "Covid19CountryProfile{" +
                "countryName='" + countryName + '\'' +
                ", numberOfCases=" + numberOfCases +
                ", numberOfDeaths=" + numberOfDeaths +
                ", numberOfRecoveries=" + numberOfRecoveries +
                '}';
    }
}
