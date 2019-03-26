package com.itc.qa.automat.values;

import com.itc.qa.automat.common.Enums.EmploymentType;
import com.itc.qa.automat.common.Enums.Gender;
import com.itc.qa.automat.common.Enums.JobType;

public class PreferencesValues {

    private String city_fewChars;
    private String city;
    private String industry_fewChars;
    private String industry;
    private String function;
    private String role_fewChars;
    private String role;
    private String jobType;
    private String employmentType;
    private String gender;
    private String birthDate;
    private String birhtMonth;
    private String birthYear;
    private String marital_status;
    private String lang_fewChars;
    private String lang;
    private String[] lang_level;
    private String allowedCountry_few;
    private String allowedCountry;
    private String caste;
    private String[] skill;

    public PreferencesValues() {

        this.city_fewChars = "hyd";
        this.city = "Hyderabad";
        this.industry_fewChars  =  "IT";
        this.industry  = "IT/ Computers - Software";
        this.role_fewChars = "tes";
        this.role =  "Software Test Engineer";
        this.jobType = JobType.Permanent.getVisibleText();
        this.employmentType = EmploymentType.Full_time.getVisibleText();
        this.gender = Gender.Male.getVisibleText();
        this.marital_status = "Single/Unmarried";
        this.function = "IT";
        this.birthDate = "02";
        this.birhtMonth = "08";
        this.birthYear = "1991";
        this.lang_fewChars = "Eng";
        this.lang = "English";
        this.lang_level =new String[] {"Read","Write","Speak"};
        this.allowedCountry_few = "In";
        this.allowedCountry = "India";
        this.caste = "OBC";
        this.skill = new String[]{"sele","Selenium Web","3","2019","7 Years","3 Months"};
    }

    public String[] getSkill() {
        return skill;
    }

    public String getCaste() {
        return caste;
    }

    public String getAllowedCountry() {
        return allowedCountry;
    }

    public String getAllowedCountry_few() {
        return allowedCountry_few;
    }

    public String getLang() {
        return lang;
    }

    public String getLang_fewChars() {
        return lang_fewChars;
    }

    public String[] getLang_level() {
        return lang_level;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBirhtMonth() {
        return birhtMonth;
    }

    public String getBirthYear() {
        return birthYear;
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

    public String getFunction() {
        return function;
    }

    public String getIndustry() {
        return industry;
    }

    public String getIndustry_fewChars() {
        return industry_fewChars;
    }

    public String getCity_fewChars() {
        return city_fewChars;
    }

    public String getCity() {
        return city;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
