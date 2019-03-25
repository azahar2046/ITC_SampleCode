package com.itc.qa.automat.values;

import com.itc.qa.automat.common.Enums;
import com.itc.qa.automat.common.RandData;

public class PersonalDetailsValues {

    private String name;
    private String city_fewChars;
    private String city;
    private String email;
    private String password;
    private String mobileNumber;

    public PersonalDetailsValues() {

        this.name = "John Walker";
        this.email = RandData.getRandomMail();
        this.password = "123456789";
        this.mobileNumber = RandData.getRandomMobileNumber();
        this.city_fewChars = "hyd";
        this.city = "Hyderabad";
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCity_fewChars() {
        return city_fewChars;
    }

    public String getCity() {
        return city;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
