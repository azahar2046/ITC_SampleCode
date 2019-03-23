package com.itc.qa.automat.pages;

import org.openqa.selenium.By;

public class PageRegistrationPreferences {

    public static final By linkUploadPicture = By.cssSelector(".btn.uploadImg");
    public static final By UploadSuccess = By.id("user-avtar");
    public static final By textFieldLocation = By.xpath("//span[contains(text(),'Location')]/parent::div/parent::div");
    public static final By textFieldIndustry = By.xpath("//span[contains(text(),'Industry')]/parent::div/parent::div");
    public static final By textFieldFunction = By.xpath("//span[contains(text(),'Function')]/parent::div/parent::div");
    public static final By textFieldRole = By.xpath("//span[contains(text(),'Role')]/parent::div/parent::div");
    public static final By textFieldBirth = By.xpath("div.vdp-datepicker");
    public static final By textFieldLanguage = By.xpath("//span[contains(text(),'Language')]/parent::div/parent::div");
    public static final By textFiledLanguageLevel = By.xpath("//span[contains(text(),'Level')]/parent::div/parent::div");

    public static final By textFieldMaritalStatus = By.xpath("//span[contains(text(),'Marital Status')]/parent::div/parent::div");
    public static final By RadioButton = By.xpath("//parent::label/preceding-sibling::span/input");
    public static final By buttonSubmit= By.cssSelector("input[class='btn']");


    public static final By dropDownSelectOption = By.xpath("//*[contains(@class,'multiselect__content-wrapper')]/ul/li");

}
