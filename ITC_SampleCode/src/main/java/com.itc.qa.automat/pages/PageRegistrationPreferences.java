package com.itc.qa.automat.pages;

import com.itc.qa.automat.common.GlobalBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PageRegistrationPreferences {

    private GlobalBrowser globalBrowser;

    private By linkUploadPicture = By.cssSelector(".btn.uploadImg");
    private By textFieldLocation = By.xpath("//span[contains(text(),'Location')]/parent::div/parent::div");
    private By textFieldIndustry = By.xpath("//span[contains(text(),'Industry')]/parent::div/parent::div");
    private By textFieldFunction = By.xpath("//span[contains(text(),'Function')]/parent::div/parent::div");
    private By textFieldRole = By.xpath("//span[contains(text(),'Role')]/parent::div/parent::div");
    private By textFieldBirth = By.cssSelector("div.vdp-datepicker input");
    private By textFieldLanguage = By.xpath("//span[contains(text(),'Language')]/parent::div/parent::div");
    private By textFieldLanguageLevel = By.xpath("//span[contains(text(),'Level')]/parent::div/parent::div");
    private By textFieldAllowedCountry = By.xpath("//span[contains(text(),'Countries Authorized ')]/parent::div/parent::div");
    private By textFieldCaste = By.xpath("//span[contains(text(),'Category')]/parent::div/parent::div");
    private By textFieldMaritalStatus = By.xpath("//span[contains(text(),'Marital Status')]/parent::div/parent::div");
    private By radioButtonJobType = By.xpath("//input[@name='jobType']/parent::span/following-sibling::label");
    private By radioButtonemploymentType = By.xpath("//input[@name='emplyType']/parent::span/following-sibling::label");
    private By radioButtonGender = By.xpath("//input[@name='gender']/parent::span/following-sibling::label");
    private By textFieldSkill = By.xpath("//span[contains(text(),'Skill')]/parent::div/parent::div");
    private By textFieldLastUsed = By.xpath("//span[contains(text(),'Last Used')]/parent::div/parent::div");
    private By textFieldYears = By.xpath("//span[contains(text(),'Years')]/parent::div/parent::div");
    private By textFieldMonths = By.xpath("//span[contains(text(),'Months')]/parent::div/parent::div");
    private By textFieldVersion = By.xpath("//input[@class='input version']");

    private By buttonSubmit = By.xpath("//input[@value='Submit']/parent::div");

    private By UpdateProfile = By.xpath("//a[contains(text(),'Your Profile')]");

    public void uploadPhoto(String file) {

        globalBrowser.click(linkUploadPicture);

        globalBrowser.fileUpload(file);

        globalBrowser.sleep(4000);

    }

    public void enterLocation(String few_Chars, String text) {

        globalBrowser.sendKeys(textFieldLocation, few_Chars);

        globalBrowser.selectOption(text);

    }

    public void enterIndustry(String few_Chars, String text) {

        globalBrowser.sendKeys(textFieldIndustry, few_Chars);

        globalBrowser.selectOption(text);

    }

    public void enterRole(String few_Chars, String text) {

        globalBrowser.sendKeys(textFieldRole, few_Chars);

        globalBrowser.selectOption(text);

    }

    public void enterFunction(String text) {

        globalBrowser.click(textFieldFunction);

        globalBrowser.sleep(2000);

        globalBrowser.selectOptionExacttext(text);

    }

    public void selectJobType(String text) {

        globalBrowser.radioButton(radioButtonJobType, text);

    }

    public void selectEmploymentType(String text) {

        globalBrowser.radioButton(radioButtonemploymentType, text);

    }

    public void enterSkillData(String[] skill_few) {

        globalBrowser.sendKeys(textFieldSkill, skill_few[0]);
        globalBrowser.selectOption(skill_few[1]);

        globalBrowser.sendKeys(textFieldVersion,skill_few[2]);

        globalBrowser.click(textFieldLastUsed);
        globalBrowser.selectOption(skill_few[3]);

        globalBrowser.click(textFieldYears);
        globalBrowser.selectOption(skill_few[4]);

    }


    public void selectGender(String text) {

        globalBrowser.scrollToView(radioButtonGender);

        globalBrowser.radioButton(radioButtonGender, text);

    }

    public void enterMaritalStatus(String text) {

        globalBrowser.click(textFieldMaritalStatus);

        globalBrowser.selectOption(text);

    }

    public void enterAllowedCountry(String few, String text) {

        globalBrowser.sendKeys(textFieldAllowedCountry,few);

        globalBrowser.selectOption(text);

    }

    public void enterCaste(String text) {

        globalBrowser.click(textFieldCaste);

        globalBrowser.selectOption(text);

    }

    public void enterLanguage(String few_chars, String text_lang, String[] text) {


        globalBrowser.sendKeys(textFieldLanguage, few_chars);
        globalBrowser.selectOptionExacttext(text_lang);

        globalBrowser.sleep(2000);

        globalBrowser.click(textFieldLanguageLevel);
        globalBrowser.selectOptionExacttext(text[1]);

        System.out.println(text[0]);

    }

    public void clickSubmit() {

        globalBrowser.click(buttonSubmit);

    }

    public void waitUntilElementVisible() {

        globalBrowser.waitUntil(ExpectedConditions.visibilityOfElementLocated(UpdateProfile), 60);

    }

    public void selectBirth(String date, String month, String year) {

        String text = year+"-"+month+"-"+date;

        globalBrowser.enterScriptText(textFieldBirth,text);

    }

    public void closeBrowser() {

        globalBrowser.quitBrowser();
    }


    public PageRegistrationPreferences(GlobalBrowser globalBrowser) {

        this.globalBrowser = globalBrowser;
    }

}
