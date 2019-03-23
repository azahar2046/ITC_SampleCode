package com.itc.qa.automat.pages;

import org.openqa.selenium.By;

public class PageUserHome{

    public static final By logoProfile = By.cssSelector("a.main-nav-link.pr");
    public static final By linkSettings = By.linkText("Settings");
    public static final By linkDeleteAccount = By.id("pf_disable");
    public static final By buttondeleteAccount = By.cssSelector(".btn.cancel_btn");
    public static final By textFieldllogin = By.id("input#username_login");
    public static final By textFieldPassword = By.cssSelector("#passwd_temp");
    public static final By buttonSubmit = By.cssSelector("input#button");


    private PageUserHome() {
    }
}
