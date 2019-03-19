package com.itc.qa.automat.values;

import com.itc.qa.automat.common.RandData;

public class RegistrationValues {

    private String name;
    private String birth;
    private String city;
    private String email;
    private String password;
    private String mobileNumber;

    public RegistrationValues() {

        this.name = RandData.getRandomStringWithoutAdditionalCharacters(5) + " " + RandData.getRandomStringWithoutAdditionalCharacters(5);
        this.email = RandData.getRandomMail();
        this.password = "123456789";
        this.mobileNumber = RandData.getRandomMobileNumber();
        this.city = "Hyd";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {

        return "RegistrationValues {name='" + name + "', city='" + city + "',  email='" + email + "', password='" + password + "', mobileNumber='" + mobileNumber + "'}";
    }

}
