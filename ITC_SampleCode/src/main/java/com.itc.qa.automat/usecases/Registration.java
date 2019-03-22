package com.itc.qa.automat.usecases;

import com.itc.qa.automat.common.Browser;
import com.itc.qa.automat.pages.PageRegistration;
import com.itc.qa.automat.values.RegistrationValues;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Registration extends Browser {


    private void fill(RegistrationValues registrationValues)  {

        goToPageRegistration();
        sendKeys(PageRegistration.textFieldName, registrationValues.getName());

        sendKeys(PageRegistration.textFieldEmail, registrationValues.getEmail());

        sendKeys(PageRegistration.textFieldPassword, registrationValues.getPassword());

        actionsSendKeys(PageRegistration.textFieldCurrentLocation,registrationValues.getCity_fewchars());
        clickMultiSelect(PageRegistration.textFieldCurrentLocation,registrationValues.getCity());

        sendKeys(PageRegistration.textFieldMobile, registrationValues.getMobileNumber());

        //actionsClick(PageRegistration.linkFileUpload);

        //fileUpload("\\resume.pdf");

        //waitUntil(ExpectedConditions.visibilityOfElementLocated(PageRegistration.UploadSuccess));

        actionsClick(PageRegistration.buttonSubmit_1);

        waitUntil(ExpectedConditions.visibilityOfElementLocated(PageRegistration.textFieldHighestQualification));

        actionsSendKeys(PageRegistration.textFieldHighestQualification,registrationValues.getQualification_fewChars());
        clickMultiSelect(PageRegistration.textFieldHighestQualification,registrationValues.getQualification());

        actionsSendKeys(PageRegistration.textFieldSpecialisation, registrationValues.getSpecialization_fewChars());
        clickMultiSelect(PageRegistration.textFieldSpecialisation, registrationValues.getSpecialization());

        actionsSendKeys(PageRegistration.textFieldInstitute,registrationValues.getInstitute_fewchars());
        clickMultiSelect(PageRegistration.textFieldInstitute,registrationValues.getInstitute());

        actionsClick(PageRegistration.textFieldPassingYear);
        clickMultiSelect(PageRegistration.textFieldPassingYear,registrationValues.getPassingYear());

        actionsSendKeys(PageRegistration.textFieldSkills,registrationValues.getSkills_fewchars());
        clickMultiSelect(PageRegistration.textFieldSkills,registrationValues.getSkills());

        actionsClick(PageRegistration.buttonContinue_2);

        sleep(1000);


    }

    public void success(RegistrationValues registrationValues) {

        try {

            fill(registrationValues);

            sleep(3000);

        } catch (Throwable t) {

            throw new RuntimeException(t);

        } finally {

            webdriver.quit();
        }
    }

    public void failure(RegistrationValues registrationValues, String message) {

        try {

            fill(registrationValues);
            sleep(2000);

        } catch (Throwable t) {

            throw new RuntimeException(t);

        } finally {

            webdriver.quit();
        }
    }

}
