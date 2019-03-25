package com.itc.qa.automat.pages;

import com.itc.qa.automat.common.GlobalBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageRegistrationPersonalDetails {

    private GlobalBrowser globalBrowser = new GlobalBrowser();

    private By linkFresher = By.xpath("//*[@class='mqfi-graduation-cap-line']/parent::div/parent::div");

    private By textFieldName = By.name("fullname");
    private By textFieldEmail = By.cssSelector("input[name='email'][type='email']");
    private By textFieldPassword = By.cssSelector("input[name='Password']");
    private By textFieldCurrentLocation = By.xpath("//*[contains(@class,'multiselect modal-ref-class')]");
    private By textFieldMobile = By.cssSelector("input[name='mobile'][type='tel']");
    private By linkFileUpload = By.cssSelector("div[class='uploadResume fl pr tc']");
    private By UploadSuccess = By.xpath("//*[contains(text(),'uploaded successfully')]");
    private By buttonSubmit = By.xpath("//input[contains(@value,'Register')]");

    public void clickLinkFresher() {

        globalBrowser.openUrl("https://www.monsterindia.com/seeker/registration");
        globalBrowser.click(linkFresher);
    }

    public void enterName(String name) {

        globalBrowser.sendKeys(textFieldName, name);

    }

    public void enterEmail(String email) {

        globalBrowser.sendKeys(textFieldEmail, email);

    }

    public void enterPassword(String password) {

        globalBrowser.sendKeys(textFieldPassword, password);

    }

    public void enterCurrentLocation(String location_fewChars, String location) {

        globalBrowser.sendKeys(textFieldCurrentLocation, location_fewChars);
        globalBrowser.selectOption(location);

    }

    public void enterMobile(String mobile) {

        globalBrowser.sendKeys(textFieldMobile, mobile);

    }

    public void uploadResume(String file) {

        globalBrowser.click(linkFileUpload);
        globalBrowser.fileUpload(file);

    }

    public void waitUntilUploadSuccess() {

        globalBrowser.waitUntil(ExpectedConditions.visibilityOfElementLocated(UploadSuccess));

    }

    public PageRegistrationEducationDetails clickSubmit() {

        globalBrowser.click(buttonSubmit);
        return new PageRegistrationEducationDetails(globalBrowser);

    }

    public PageRegistrationPersonalDetails() {

    }
}
