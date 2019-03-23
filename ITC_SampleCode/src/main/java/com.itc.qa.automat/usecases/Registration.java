package com.itc.qa.automat.usecases;

import com.itc.qa.automat.common.Browser;
import com.itc.qa.automat.pages.PageRegistrationEducationDetails;
import com.itc.qa.automat.pages.PageRegistrationPersonalDetails;
import com.itc.qa.automat.pages.PageRegistrationPreferences;
import com.itc.qa.automat.pages.PageUserHome;
import com.itc.qa.automat.values.RegistrationValues;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Registration extends Browser {

    private void fillPersonalDetails(RegistrationValues rv){

        goToPageRegistration();
        sendKeys(PageRegistrationPersonalDetails.textFieldName, rv.getName());

        sendKeys(PageRegistrationPersonalDetails.textFieldEmail, rv.getEmail());

        sendKeys(PageRegistrationPersonalDetails.textFieldPassword, rv.getPassword());

        sendKeysByActions(PageRegistrationPersonalDetails.textFieldCurrentLocation,rv.getCity_fewChars());
        selectOption(PageRegistrationPersonalDetails.textFieldCurrentLocation,PageRegistrationPersonalDetails.dropDownSelectOption,rv.getCity());

        sendKeys(PageRegistrationPersonalDetails.textFieldMobile, rv.getMobileNumber());

        //clickByActions(PageRegistrationPersonalDetails.linkFileUpload);

        //fileUpload("\\resume.pdf");

        //waitUntil(ExpectedConditions.visibilityOfElementLocated(PageRegistrationPersonalDetails.UploadSuccess));

        clickByActions(PageRegistrationPersonalDetails.buttonSubmit);

        waitUntil(ExpectedConditions.visibilityOfElementLocated(PageRegistrationEducationDetails.textFieldHighestQualification));

    }

    private void fillEducationDetails(RegistrationValues rv)  {


        sendKeysByActions(PageRegistrationEducationDetails.textFieldHighestQualification,rv.getQualification_fewChars());
        selectOption(PageRegistrationEducationDetails.textFieldHighestQualification,PageRegistrationEducationDetails.dropDownSelectOption,rv.getQualification());

        sendKeysByActions(PageRegistrationEducationDetails.textFieldSpecialisation, rv.getSpecialization_fewChars());
        selectOption(PageRegistrationEducationDetails.textFieldSpecialisation,PageRegistrationEducationDetails.dropDownSelectOption, rv.getSpecialization());

        sendKeysByActions(PageRegistrationEducationDetails.textFieldInstitute,rv.getInstitute_fewChars());
        selectOption(PageRegistrationEducationDetails.textFieldInstitute,PageRegistrationEducationDetails.dropDownSelectOption,rv.getInstitute());

        clickByActions(PageRegistrationEducationDetails.textFieldPassingYear);
        selectOption(PageRegistrationEducationDetails.textFieldPassingYear,PageRegistrationEducationDetails.dropDownSelectOption,rv.getPassingYear());

        sendKeysByActions(PageRegistrationEducationDetails.textFieldSkills,rv.getSkills_fewChars());
        selectOption(PageRegistrationEducationDetails.textFieldSkills,PageRegistrationEducationDetails.dropDownSelectOption,rv.getSkills());

        clickByActions(PageRegistrationEducationDetails.buttonContinue);

        waitUntil(ExpectedConditions.visibilityOfElementLocated(PageRegistrationPreferences.linkUploadPicture));

    }


    private void fillPreferences(RegistrationValues rv){


        clickByActions(PageRegistrationPreferences.linkUploadPicture);

        fileUpload("\\photo.jpg");

        assertAttritbute(PageRegistrationPreferences.UploadSuccess,"src");


        sendKeysByActions(PageRegistrationPreferences.textFieldLocation,rv.getCity_fewChars());
        selectOption(PageRegistrationPreferences.textFieldLocation,PageRegistrationPreferences.dropDownSelectOption,rv.getCity());

        sendKeysByActions(PageRegistrationPreferences.textFieldIndustry,rv.getIndustry_fewChars());
        selectOption(PageRegistrationPreferences.textFieldIndustry,PageRegistrationPreferences.dropDownSelectOption,rv.getIndustry());

        clickByActions(PageRegistrationPreferences.textFieldFunction);
        selectOption(PageRegistrationPreferences.textFieldFunction,PageRegistrationPreferences.dropDownSelectOption,rv.getIndustry_fewChars());


        sendKeysByActions(PageRegistrationPreferences.textFieldRole,rv.getRole_fewChars());
        selectOption(PageRegistrationPreferences.textFieldRole,PageRegistrationPreferences.dropDownSelectOption,rv.getRole());

        radioButton(PageRegistrationPreferences.RadioButton,rv.getEmploymentType());

        radioButton(PageRegistrationPreferences.RadioButton,rv.getJobType());

        radioButton(PageRegistrationPreferences.RadioButton,rv.getGender());

        clickByActions(PageRegistrationPreferences.textFieldMaritalStatus);
        selectOption(PageRegistrationPreferences.textFieldMaritalStatus,PageRegistrationPreferences.dropDownSelectOption,rv.getMarital_status());


        clickByActions(PageRegistrationPreferences.buttonSubmit);

        waitUntil(ExpectedConditions.visibilityOfElementLocated(PageUserHome.logoProfile));

    }


    public void deleteAccount(RegistrationValues rv){

        moveByActions(PageUserHome.logoProfile);

        clickByActions(PageUserHome.linkSettings);

        sendKeysByActions(PageUserHome.textFieldllogin,rv.getEmail());

        sendKeysByActions(PageUserHome.textFieldPassword,rv.getPassword());

        clickByActions(PageUserHome.buttonSubmit);

        clickByActions(PageUserHome.linkDeleteAccount);

        clickByActions(PageUserHome.buttondeleteAccount);
        
    }

    public void success(RegistrationValues rv) {

        try {

            fillPersonalDetails(rv);

            fillEducationDetails(rv);

            fillPreferences(rv);

            deleteAccount(rv);

        } catch (Throwable t) {

            throw new RuntimeException(t);

        } finally {

            webdriver.quit();
        }
    }

    public void failure(RegistrationValues rv, String message) {

        try {

            fillPersonalDetails(rv);
            sleep(2000);

        } catch (Throwable t) {

            throw new RuntimeException(t);

        } finally {

            webdriver.quit();
        }
    }

}
