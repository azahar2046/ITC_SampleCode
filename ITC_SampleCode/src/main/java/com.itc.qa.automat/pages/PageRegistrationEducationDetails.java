package com.itc.qa.automat.pages;

import com.itc.qa.automat.common.GlobalBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PageRegistrationEducationDetails  {

    private GlobalBrowser globalBrowser;

    private By textFieldHighestQualification = By.xpath("//span[contains(text(),'Highest Qualification')]/parent::div/parent::div");
    private By textFieldSpecialisation = By.xpath("//span[contains(text(),'Specialization ')]/parent::div/parent::div");
    private By textFieldInstitute = By.xpath("//span[contains(text(),'Institute')]/parent::div/parent::div");
    private By radioButtonEducationType = By.xpath("//input[@type='radio']/parent::span/following-sibling::label");
    private By textFieldPassingYear = By.xpath("//span[contains(text(),'Passing Year')]/parent::div/parent::div");
    private By textFieldSkills = By.xpath("//span[contains(text(),'Skills ')]/parent::div/parent::div");
    private By buttonContinue = By.cssSelector("input[name='educationalDetails']");

    public void waitUntilElementVisible() {

        globalBrowser.waitUntil(ExpectedConditions.visibilityOfElementLocated(textFieldHighestQualification));
    }

    public void enterHighestQualification(String fewChars, String text) {

        globalBrowser.sendKeys(textFieldHighestQualification, fewChars);
        globalBrowser.selectOption(text);
    }

    public void enterSpecialisation(String fewChars, String text) {

        globalBrowser.sendKeys(textFieldSpecialisation, fewChars);
        globalBrowser.selectOption(text);
    }

    public void enterInstitute(String fewChars, String text) {

        globalBrowser.sendKeys(textFieldInstitute, fewChars);
        globalBrowser.selectOption(text);
    }

    public void selectEducationType(String text) {

        globalBrowser.radioButton(radioButtonEducationType,text);
    }

    public void enterPassingYear(String text) {

        globalBrowser.click(textFieldPassingYear);
        globalBrowser.selectOption(text);
    }


    public void enterSkills(String fewChars,String text) {

        globalBrowser.scrollToView(buttonContinue);
        globalBrowser.sendKeys(textFieldSkills, fewChars);
        globalBrowser.selectOption(text);
    }

    public PageRegistrationPreferences clickButtonContinue() {

        globalBrowser.click(buttonContinue);
        return new PageRegistrationPreferences(globalBrowser);
    }

    public  PageRegistrationEducationDetails(GlobalBrowser globalBrowser){

        this.globalBrowser = globalBrowser;
    }
}
