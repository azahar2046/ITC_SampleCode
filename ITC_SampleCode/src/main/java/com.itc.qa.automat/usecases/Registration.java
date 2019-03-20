package com.itc.qa.automat.usecases;

import com.gargoylesoftware.htmlunit.Page;
import com.itc.qa.automat.common.Browser;
import com.itc.qa.automat.pages.PageRegistration;
import com.itc.qa.automat.values.RegistrationValues;

import java.io.IOException;

public class Registration extends Browser {


    private void fill(RegistrationValues registrationValues) {

        String userDir = System.getProperty("user.dir");

        goToPageRegistration();
        sendKeys(PageRegistration.textFieldName, registrationValues.getName());
        sendKeys(PageRegistration.textFieldEmail, registrationValues.getEmail());
        sendKeys(PageRegistration.textFieldPassword, registrationValues.getPassword());
        click(PageRegistration.textFieldCurrentLocation);
        sendKeys(PageRegistration.textFieldCity, registrationValues.getCity_few());
        clickMultiSelect(registrationValues.getCity());
        sendKeys(PageRegistration.textFieldMobile, registrationValues.getMobileNumber());
        actionsClick(PageRegistration.linkFileUpload);
        sleep(1000);
        try {
            Runtime.getRuntime().exec(userDir + "/FileUpload_resume.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sleep(1000);
        actionsClick(PageRegistration.buttonSubmit_1);

        click(PageRegistration.textFieldHighestQualification);

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
