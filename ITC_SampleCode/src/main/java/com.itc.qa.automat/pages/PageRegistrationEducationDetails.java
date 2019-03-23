package com.itc.qa.automat.pages;

import org.openqa.selenium.By;

public class PageRegistrationEducationDetails {

    public static final By textFieldHighestQualification = By.xpath("//span[contains(text(),'Highest Qualification')]/parent::div/parent::div");
    public static final By textFieldSpecialisation = By.xpath("//span[contains(text(),'Specialization ')]/parent::div/parent::div");
    public static final By textFieldInstitute = By.xpath("//span[contains(text(),'Institute')]/parent::div/parent::div");
    public static final By textFieldPassingYear = By.xpath("//span[contains(text(),'Passing Year')]/parent::div/parent::div");
    public static final By textFieldSkills = By.xpath("//span[contains(text(),'Skills ')]/parent::div/parent::div");
    public static final By buttonContinue = By.cssSelector("input[name='educationalDetails']");

    public static final By dropDownSelectOption = By.xpath("//*[contains(@class,'multiselect__content-wrapper')]/ul/li");

}
