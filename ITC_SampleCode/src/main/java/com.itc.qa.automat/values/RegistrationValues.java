package com.itc.qa.automat.values;

import com.itc.qa.automat.common.RandData;

public class RegistrationValues {

    private String name;
    private String birth;
    private String city_fewchars;
    private String city;
    private String email;
    private String password;
    private String mobileNumber;
    private String qualification;
    private String qualification_fewChars;
    private String specialization;
    private String specialization_fewChars;
    private String institute_fewchars;
    private String institute;
    private String PassingYear;
    private String skills_fewchars;
    private String skills;

    public RegistrationValues() {

        this.name = RandData.getRandomStringWithoutAdditionalCharacters(5) + " " + RandData.getRandomStringWithoutAdditionalCharacters(5);
        this.email = RandData.getRandomMail();
        this.password = "123456789";
        this.mobileNumber = RandData.getRandomMobileNumber();
        this.city_fewchars = "hyd";
        this.city = "hyderabad";
        this.qualification = "MCA";
        this.qualification_fewChars = "MC";
        this.specialization = "Visual Communication";
        this.specialization_fewChars = "Vis";
        this.institute_fewchars = "osm";
        this.institute = "OSMANIA UNIVERSITY";
        this.PassingYear = "2014";
        this.skills_fewchars = "seleni";
        this.skills = "Selenium 2";
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getSpecialization_fewChars() {
        return specialization_fewChars;
    }

    public String getQualification_fewChars() {
        return qualification_fewChars;
    }

    public void setQualification_fewChars(String qualification_fewChars) {
        this.qualification_fewChars = qualification_fewChars;
    }

    public String getSkills_fewchars() {
        return skills_fewchars;
    }

    public void setSkills_fewchars(String skills_fewchars) {
        this.skills_fewchars = skills_fewchars;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getPassingYear() {
        return PassingYear;
    }

    public void setPassingYear(String passingYear) {
        PassingYear = passingYear;
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

    public String getCity_fewchars() {
        return city_fewchars;
    }

    public void setCity_fewchars(String city_fewchars) {
        this.city_fewchars = city_fewchars;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getInstitute_fewchars() {
        return institute_fewchars;
    }

    public void setInstitute_fewchars(String institute_fewchars) {
        this.institute_fewchars = institute_fewchars;
    }

    @Override
    public String toString() {

        return "RegistrationValues {name='" + name + "', city='" + city + "',  email='" + email + "', password='" + password + "', mobileNumber='" + mobileNumber + "'}";
    }

}
