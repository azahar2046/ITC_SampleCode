package com.itc.qa.automat.pages;

import org.openqa.selenium.By;

public class PageRegistrationPersonalDetails {

    public static final By linkFresher = By.xpath("//*[@class='mqfi-graduation-cap-line']/parent::div/parent::div");

    public static final By textFieldName = By.name("fullname");
    public static final By textFieldEmail = By.cssSelector("input[name='email'][type='email']");
    public static final By textFieldPassword = By.cssSelector("input[name='Password']");
    public static final By textFieldCurrentLocation = By.xpath("//*[contains(@class,'multiselect modal-ref-class')]");
    public static final By textFieldCity = By.xpath("//*[contains(@class,'multiselect__content ddn-scrollable modal-ref-class')]/li");
    public static final By textFieldMobile = By.cssSelector("input[name='mobile'][type='tel']");
    public static final By linkFileUpload = By.cssSelector("div[class='uploadResume fl pr tc']");
    public static final By UploadSuccess = By.xpath("//*[contains(text(),'uploaded successfully')]");
    public static final By buttonSubmit = By.xpath("//input[contains(@value,'Register')]");

    public static final By dropDownSelectOption = By.xpath("//*[contains(@class,'multiselect__content-wrapper')]/ul/li");

}
