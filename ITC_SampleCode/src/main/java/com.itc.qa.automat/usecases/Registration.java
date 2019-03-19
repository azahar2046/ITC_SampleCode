package com.itc.qa.automat.usecases;

import com.gargoylesoftware.htmlunit.Page;
import com.itc.qa.automat.common.Browser;
import com.itc.qa.automat.pages.PageRegistration;
import com.itc.qa.automat.values.RegistrationValues;
import sun.security.krb5.internal.PAEncTSEnc;

public class Registration extends Browser {


    private void fill(RegistrationValues registrationValues) {

        goToPageRegistration();
        sendKeys(PageRegistration.textFieldName,registrationValues.getName());
        sendKeys(PageRegistration.textFieldEmail,registrationValues.getEmail());
        sendKeys(PageRegistration.textFieldPassword,registrationValues.getPassword());
        sendKeys(PageRegistration.textFieldCity,registrationValues.getCity());
        sendKeys(PageRegistration.textFieldMobile,registrationValues.getMobileNumber());
        click(PageRegistration.buttonSubmit_1);

    }

    public void success(RegistrationValues registrationValues) {

        try {

            fill(registrationValues);
             sleep(3000);

        } catch (Throwable t) {

           t.getStackTrace();

        } finally {

            webdriver.quit();
        }
    }

    public void failure(RegistrationValues registrationValues, String message) {

        try {

            fill(registrationValues);
            sleep(2000);

        } catch (Throwable t) {

            t.getStackTrace();

        } finally {

            webdriver.quit();
        }
    }

}
