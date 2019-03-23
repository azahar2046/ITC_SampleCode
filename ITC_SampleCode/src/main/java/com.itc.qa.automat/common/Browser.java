package com.itc.qa.automat.common;

import com.itc.qa.automat.pages.PageRegistrationPersonalDetails;

public class Browser extends GlobalBrowser {

    private void goToPageHome() {

        String url = "https://www.monsterindia.com/seeker/registration";
        openUrl(url);

    }

    public void goToPageRegistration() {

        goToPageHome();
        clickByActions(PageRegistrationPersonalDetails.linkFresher);

    }
}
