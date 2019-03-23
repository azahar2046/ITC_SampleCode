package com.itc.qa.automat.values;

import com.itc.qa.automat.common.Enums;
import com.itc.qa.automat.common.RandData;

public class RegistrationValues {

    private String name;
    private String birth;
    private String city_fewChars;
    private String city;
    private String email;
    private String password;
    private String mobileNumber;
    private String qualification;
    private String qualification_fewChars;
    private String specialization;
    private String specialization_fewChars;
    private String institute_fewChars;
    private String institute;
    private String PassingYear;
    private String skills_fewChars;
    private String skills;
    private String industry_fewChars;
    private String industry;
    private String role_fewChars;
    private String role;
    private String jobType;
    private String employmentType;
    private String gender;
    private String marital_status;

    public RegistrationValues() {

        this.name = RandData.getRandomStringWithoutAdditionalCharacters(5) + " " + RandData.getRandomStringWithoutAdditionalCharacters(5);
        this.email = RandData.getRandomMail();
        this.password = "123456789";
        this.mobileNumber = RandData.getRandomMobileNumber();
        this.city_fewChars = "hyd";
        this.city = "Hyderabad";
        this.qualification = "B.E/B.Tech";
        this.qualification_fewChars = "B.E";
        this.specialization = "Electrical engineering";
        this.specialization_fewChars = "elec";
        this.institute_fewChars = "muff";
        this.institute = "Muffakhamjah College";
        this.PassingYear = "2016";
        this.skills_fewChars = "mat";
        this.skills = "Matlab";
        this.industry_fewChars  =  "IT";
        this.industry  = "IT/ Computers - Software";
        this.role_fewChars = "tes";
        this.role =  "Software Test Engineer";
        this.jobType = Enums.JobType.Permanent.getVisibleText();
        this.employmentType = Enums.employmentType.Full_time.getVisibleText();
        this.gender = Enums.Gender.Male.getVisibleText();
        this.marital_status = "Single/Unmarried";
    }

    public String getMarital_status() {
        return marital_status;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public String getGender() {
        return gender;
    }


    public String getJobType() {
        return jobType;
    }

    public String getRole_fewChars() {
        return role_fewChars;
    }

    public String getRole() {
        return role;
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

    public String getSkills_fewChars() {
        return skills_fewChars;
    }

    public String getSkills() {
        return skills;
    }

    public String getIndustry() {
        return industry;
    }

    public String getIndustry_fewChars() {
        return industry_fewChars;
    }

    public String getPassingYear() {
        return PassingYear;
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

    public String getQualification() {
        return qualification;
    }

    public String getInstitute() {
        return institute;
    }

    public String getInstitute_fewChars() {
        return institute_fewChars;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
