package com.itc.qa.automat.usecases;

import com.gargoylesoftware.htmlunit.Page;
import com.itc.qa.automat.common.Browser;
import com.itc.qa.automat.pages.PageRegistration;
import com.itc.qa.automat.values.RegistrationValues;

public class Registration extends Browser {


    private void fill(RegistrationValues registrationValues) {

        goToPageRegistration();
        sendKeys(PageRegistration.textFieldName,registrationValues.getName());
        sendKeys(PageRegistration.textFieldEmail,registrationValues.getEmail());
        sendKeys(PageRegistration.textFieldPassword,registrationValues.getPassword());
        autoSuggestDropdown(PageRegistration.textFieldCity,registrationValues.getCity_few(),registrationValues.getCity());
        sendKeys(PageRegistration.textFieldMobile,registrationValues.getMobileNumber());
        click(PageRegistration.buttonSubmit_1);

    }

    public void success(RegistrationValues registrationValues) {

        try {

            fill(registrationValues);
             sleep(3000);

        } catch (Throwable t) {

           throw  new RuntimeException(t);

        } finally {

            webdriver.quit();
        }
    }

    public void failure(RegistrationValues registrationValues, String message) {

        try {

            fill(registrationValues);
            sleep(2000);

        } catch (Throwable t) {

            throw  new RuntimeException(t);

        } finally {

            webdriver.quit();
        }
    }

}
