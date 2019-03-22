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

    public static final By linkUploadPicture = By.cssSelector("img[id='user-avtar']");
    public static final By textfieldLocation = By.cssSelector("");
    public static final By textfieldIndustry = By.cssSelector("");
    public static final By textfieldFunction = By.cssSelector("");
    public static final By textfieldRole = By.cssSelector("");
    public static final By checkBoxEmploymentType = By.name("emplyType");
    public static final By checkboxJobType = By.name("jobType");
    public static final By checkBoxGender = By.name("gender");
    public static final By textFieldBirth = By.name("birth");
    public static final By buttonSubmit_3 = By.cssSelector("input[class='btn']");

    public static final By logoProfile = By.cssSelector("a.main-nav-link.pr");
    public static final By linkSettings = By.linkText("Settings");
    public static final By linkDeleteAccount = By.id("pf_disable");
    public static final By buttondeleteAccount = By.cssSelector(".btn.cancel_btn");

    private PageRegistration() {
    }
}
