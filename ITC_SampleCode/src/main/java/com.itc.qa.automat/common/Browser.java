package com.itc.qa.automat.common;

import com.itc.qa.automat.pages.PageRegistration;

public class Browser extends GlobalBrowser {

    //https://www.phptravels.net/register

    public void goToPageHome() {

        String url = "https://www.monsterindia.com/seeker/registration";
        webdriver.get(url);

    }

    public void goToPageRegistration() {

        goToPageHome();
        click(PageRegistration.linkFresher);

    }
}
