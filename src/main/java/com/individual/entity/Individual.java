package com.individual.entity;

import java.util.Date;

public class Individual {
    String firstName;

    String firstLastName;

    String secondLastName;

    String maritalStatus;

    Date birthDate;

    String nacionality;

    public Individual(String firstName, String firstLastName, String secondLastName, String maritalStatus, Date birthDate, String nacionality) {
        this.firstName = firstName;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.maritalStatus = maritalStatus;
        this.birthDate = birthDate;
        this.nacionality = nacionality;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getNacionality() {
        return nacionality;
    }


}
