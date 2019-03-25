package com.itc.qa.automat.usecases;

import com.itc.qa.automat.pages.PageRegistrationEducationDetails;
import com.itc.qa.automat.pages.PageRegistrationPersonalDetails;
import com.itc.qa.automat.pages.PageRegistrationPreferences;
import com.itc.qa.automat.values.EducationDetailsValues;
import com.itc.qa.automat.values.PersonalDetailsValues;
import com.itc.qa.automat.values.PreferencesValues;


public class Registration {

    private PageRegistrationPersonalDetails personalDetails = new PageRegistrationPersonalDetails();

    private PageRegistrationEducationDetails educationDetails;

    private PageRegistrationPreferences preferences;

    private void fillPersonalDetails(PersonalDetailsValues rv) {

        personalDetails.clickLinkFresher();

        personalDetails.enterName(rv.getName());

        personalDetails.enterEmail(rv.getEmail());

        personalDetails.enterPassword(rv.getPassword());

        personalDetails.enterCurrentLocation(rv.getCity_fewChars(), rv.getCity());

        personalDetails.enterMobile(rv.getMobileNumber());

        personalDetails.uploadResume("\\resume.pdf");

        personalDetails.waitUntilUploadSuccess();

        educationDetails = personalDetails.clickSubmit();

    }

    private void fillEducationDetails(EducationDetailsValues rv) {

        educationDetails.waitUntilElementVisible();

        educationDetails.enterHighestQualification(rv.getQualification_fewChars(), rv.getQualification());

        educationDetails.enterSpecialisation(rv.getSpecialization_fewChars(), rv.getSpecialization());

        educationDetails.enterInstitute(rv.getInstitute_fewChars(), rv.getInstitute());

        educationDetails.selectEducationType(rv.getEducationType());

        educationDetails.enterPassingYear(rv.getPassingYear());

        educationDetails.enterSkills(rv.getSkills_fewChars(), rv.getSkills());

        preferences = educationDetails.clickButtonContinue();

    }


    private void fillPreferences(PreferencesValues rv)  {

        preferences.uploadPhoto("\\photo.jpg");

        preferences.enterLocation(rv.getCity_fewChars(), rv.getCity());

        preferences.enterIndustry(rv.getIndustry_fewChars(), rv.getIndustry());

        preferences.enterFunction(rv.getFunction());

        preferences.enterRole(rv.getRole_fewChars(), rv.getRole());

        preferences.selectJobType(rv.getJobType());

        preferences.selectEmploymentType(rv.getEmploymentType());

        preferences.selectGender(rv.getGender());

        preferences.enterSkillData(rv.getSkill());

        preferences.selectBirth(rv.getBirthDate(),rv.getBirhtMonth(),rv.getBirthYear());

        preferences.enterMaritalStatus(rv.getMarital_status());

        preferences.enterLanguage(rv.getLang_fewChars(),rv.getLang(),rv.getLang_level());

        preferences.enterAllowedCountry(rv.getAllowedCountry_few(),rv.getAllowedCountry());

        preferences.enterCaste(rv.getCaste());

        preferences.clickSubmit();

        preferences.waitUntilElementVisible();

    }


    public void success(PersonalDetailsValues pd, EducationDetailsValues ed, PreferencesValues pv) {

        try {

            fillPersonalDetails(pd);

            fillEducationDetails(ed);

            fillPreferences(pv);


        } catch (Throwable t) {

            throw new RuntimeException(t);

        } finally {

            preferences.closeBrowser();
        }
    }


}
