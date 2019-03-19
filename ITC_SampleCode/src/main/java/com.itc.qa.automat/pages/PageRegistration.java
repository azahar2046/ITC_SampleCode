package com.itc.qa.automat.pages;

import org.openqa.selenium.By;

public class PageRegistration {

    public static final By linkFresher = By.cssSelector("[class='mqfi-graduation-cap-line']");

    public static final By textFieldName = By.name("fullname");
    public static final By textFieldEmail = By.cssSelector("input[name='email'][type='email']");
    public static final By textFieldPassword = By.cssSelector("input[name='Password']");
    public static final By textFieldCity = By.cssSelector("input[class='multiselect__input modal-ref-class']");
    //div[class='multiselect__spinner'] ~ input
    public static final By textFieldMobile = By.name("input[name='mobile'][type='tel']");
    public static final By linkFileUpload = By.cssSelector("input#file-upload");
    public static final By buttonSubmit_1 = By.cssSelector("input[class='btn']");

    public static final By selectHighestQualification = By.cssSelector("input[data-vv-name='highestQualification_0']']");
    public static final By selectSpecialisation = By.cssSelector("input[data-vv-name='specialization_0']");
    public static final By selectInstitute = By.cssSelector("input[data-vv-name='college_0']");
    public static final By radioBtnEducationType = By.cssSelector("input[type='radio']");
    public static final By selectPassingYear = By.cssSelector("input[name='passingYear_0']");
    public static final By selectSkills = By.cssSelector("input[name='skills']");
    public static final By buttonContinue_EducationDetails = By.cssSelector("input[name='educationalDetails']");

    public static final By linkUploadPicture = By.cssSelector("img[id='user-avtar']");
    public static final By textfieldLocation = By.cssSelector("");
    public static final By textfieldIndustry = By.cssSelector("");
    public static final By textfieldFunction = By.cssSelector("");
    public static final By textfieldRole = By.cssSelector("");
    public static final By checkBoxEmploymentType = By.name("emplyType");
    public static final By checkboxJobType = By.name("jobType");
    public static final By checkBoxGender = By.name("gender");
    public static final By textFieldBirth = By.name("birth");
    public static final By buttonSubmit_2 = By.cssSelector("input[class='btn']");

    public static final By logoProfile = By.cssSelector("a.main-nav-link.pr");
    public static final By linkSettings = By.linkText("Settings");
    public static final By linkDeleteAccount = By.id("pf_disable");
    public static final By buttondeleteAccount = By.cssSelector(".btn.cancel_btn");

    private PageRegistration() {
    }
}
