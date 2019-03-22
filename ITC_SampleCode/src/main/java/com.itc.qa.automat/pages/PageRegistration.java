package com.itc.qa.automat.pages;

import org.openqa.selenium.By;

public class PageRegistration {

    public static final By linkFresher = By.cssSelector("[class='mqfi-graduation-cap-line']");

    public static final By textFieldName = By.name("fullname");
    public static final By textFieldEmail = By.cssSelector("input[name='email'][type='email']");
    public static final By textFieldPassword = By.cssSelector("input[name='Password']");
    public static final By textFieldCurrentLocation = By.xpath("//*[contains(@class,'multiselect modal-ref-class')]");
    public static final By textFieldMobile = By.cssSelector("input[name='mobile'][type='tel']");
    public static final By linkFileUpload = By.cssSelector("div[class='uploadResume fl pr tc']");
    public static final By UploadSuccess = By.xpath("//*[contains(text(),'uploaded successfully')]");
    public static final By buttonSubmit_1 = By.xpath("//input[contains(@value,'Register')]");

    public static final By textFieldHighestQualification = By.xpath("//span[contains(text(),'Highest Qualification')]/parent::div/parent::div");
    public static final By textFieldSpecialisation = By.xpath("//span[contains(text(),'Specialization ')]/parent::div/parent::div");
    public static final By textFieldInstitute = By.xpath("//span[contains(text(),'Institute')]/parent::div/parent::div");
    public static final By textFieldPassingYear = By.xpath("//span[contains(text(),'Passing Year')]/parent::div/parent::div");
    public static final By textFieldSkills = By.xpath("//span[contains(text(),'Skills ')]/parent::div/parent::div");
    public static final By buttonContinue_2 = By.cssSelector("input[name='educationalDetails']");

    public static final By linkUploadPicture = By.cssSelector(".btn.uploadImg");
    public static final By textFieldLocation = By.xpath("//span[contains(text(),'Location')]/parent::div/parent::div");
    public static final By textFieldIndustry = By.xpath("//span[contains(text(),'Industry')]/parent::div/parent::div");
    public static final By textFieldFunction = By.xpath("//span[contains(text(),'Function')]/parent::div/parent::div");
    public static final By textFieldRole = By.xpath("//span[contains(text(),'Role')]/parent::div/parent::div");
    public static final By textFieldBirth = By.xpath("div.vdp-datepicker");
    public static final By textFieldLanguage = By.xpath("//span[contains(text(),'Language')]/parent::div/parent::div");
    public static final By textFiledLanguageLevel = By.xpath("//span[contains(text(),'Level')]/parent::div/parent::div");

    public static final By textFieldMaritalStatus = By.xpath("//span[contains(text(),'Marital Status')]/parent::div/parent::div");
    public static final By RadioButton = By.xpath("//parent::label/preceding-sibling::span/input");
    public static final By buttonSubmit_3 = By.cssSelector("input[class='btn']");

    public static final By logoProfile = By.cssSelector("a.main-nav-link.pr");
    public static final By linkSettings = By.linkText("Settings");
    public static final By linkDeleteAccount = By.id("pf_disable");
    public static final By buttondeleteAccount = By.cssSelector(".btn.cancel_btn");

    private PageRegistration() {
    }
}
