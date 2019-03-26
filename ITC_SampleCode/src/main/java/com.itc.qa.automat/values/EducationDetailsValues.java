package com.itc.qa.automat.values;

import com.itc.qa.automat.common.Enums;
import com.itc.qa.automat.common.RandData;

public class EducationDetailsValues {

    private String qualification;
    private String qualification_fewChars;
    private String specialization;
    private String specialization_fewChars;
    private String institute_fewChars;
    private String institute;
    private String educationType;
    private String PassingYear;
    private String skills_fewChars;
    private String skills;

    public EducationDetailsValues() {

        this.qualification = "B.E/B.Tech";
        this.qualification_fewChars = "B.E";
        this.specialization = "Electrical engineering";
        this.specialization_fewChars = "elec";
        this.institute_fewChars = "muff";
        this.institute = "Muffakhamjah";
        this.educationType = Enums.EducationType.Full_time.getVisibleText();
        this.PassingYear = "2016";
        this.skills_fewChars = "matl";
        this.skills = "Matlab C";

    }

    public String getPassingYear() {
        return PassingYear;
    }

    public String getEducationType() {
        return educationType;
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
