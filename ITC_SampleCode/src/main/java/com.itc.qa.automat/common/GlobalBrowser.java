package com.itc.qa.automat.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class GlobalBrowser {

    protected final WebDriver webdriver;

    protected GlobalBrowser() {

        try {

            String osName = System.getProperty("os.name");

            String userDir = System.getProperty("user.dir");

            if (osName != null && osName.toLowerCase().contains("windows")) {

                System.setProperty("webdriver.chrome.driver", userDir + "/chromedriver.exe");

            } else if (osName != null && osName.toLowerCase().contains("linux")) {

                System.setProperty("webdriver.chrome.driver", userDir + "/chromedriver");

            } else {

                throw new RuntimeException("Unsupported OS: " + osName);
            }

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-browser-side-navigation");

            webdriver = new ChromeDriver(new ChromeDriverService.Builder().build(), options);
            webdriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
            webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }


    protected void waitUntil(ExpectedCondition<? extends Object> expectedCondition) {

        Function<WebDriver, ? extends Object> function = (WebDriver driver) -> {

            return expectedCondition.apply(driver);
        };

        WebDriverWait wait = new WebDriverWait(webdriver, 10);
        wait.until(function);
    }

    protected void openUrl(String url) {

        try {

            webdriver.get(url);

        } catch (Throwable t) {

            throw new RuntimeException(t);
        }
    }

    protected void click(By by) {

        try {

            sleep(100);
            waitUntil(ExpectedConditions.elementToBeClickable(by));
            webdriver.findElement(by).click();

        } catch (Throwable t) {

            throw  new RuntimeException(t);
        }
    }

    protected String sendKeys(By by, String keys) {

        sleep(100);
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement textfield = webdriver.findElement(by);
        String value = textfield.getAttribute("value");
        textfield.clear();
        textfield.sendKeys(keys);

        return value;
    }

    protected void selectDropdownByVisibleText(By by, String visibleText) {

        sleep(100);
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by));
        Select dropdown = new Select(webdriver.findElement(by));
        dropdown.selectByVisibleText(visibleText);
    }

    protected void selectDropdownByValue(By by, String value) {

        sleep(100);
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by));
        Select dropdown = new Select(webdriver.findElement(by));
        dropdown.selectByValue(value);
    }

    protected void selectDropdownByIndex(By by, Integer index) {

        sleep(100);
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by));
        Select dropdown = new Select(webdriver.findElement(by));
        dropdown.selectByIndex(index);
    }

    protected void sleep(Integer l) {

        try {

            Thread.sleep(l);

        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
    }
}
