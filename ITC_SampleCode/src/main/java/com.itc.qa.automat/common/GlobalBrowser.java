package com.itc.qa.automat.common;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class GlobalBrowser {

    protected final WebDriver webdriver;
    private static String userDir;

    protected GlobalBrowser() {

        try {

            String osName = System.getProperty("os.name");

            userDir = System.getProperty("user.dir");

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
            webdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }


    protected void waitUntil(ExpectedCondition<? extends Object> expectedCondition) {

        Function<WebDriver, ? extends Object> function = (WebDriver driver) -> {

            return expectedCondition.apply(driver);
        };

        WebDriverWait wait = new WebDriverWait(webdriver, 40);
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

            throw new RuntimeException(t);
        }
    }

    protected void clickMultiSelect(By by, String text) {

        try {

            sleep(100);

            List<WebElement> webElementList = webdriver.findElement(by).findElements(By.xpath("//*[contains(@class,'multiselect__content-wrapper')]/ul/li"));

            for (WebElement webElement : webElementList) {

                String text_1 = webElement.getText();

                if (text_1.contains(text)) {

                    actionsClick(webElement);

                    break;
                }

            }

        } catch (Throwable t) {

            throw new RuntimeException(t);
        }
    }

    protected void radioButton(By by, String text){

        webdriver.findElement(By.xpath("//span[text()='"+text+"']")).findElement(by).click();

    }

    protected void sendKeys(By by, String keys) {

        sleep(100);
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement textfield = webdriver.findElement(by);
        textfield.sendKeys(keys);
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


    protected void actionsSendKeys(By by, String text) {

        Actions actions = new Actions(webdriver);
        actions.moveToElement(webdriver.findElement(by)).click().sendKeys(text).perform();
        sleep(1000);
    }

    protected void actionsClick(By by) {

        Actions actions = new Actions(webdriver);
        actions.moveToElement(webdriver.findElement(by)).click().perform();
        sleep(1000);
    }

    protected void actionsClick(WebElement webElement) {

        Actions actions = new Actions(webdriver);
        actions.moveToElement(webElement).click().perform();
        sleep(1000);
    }

    protected void fileUpload(String file) {

        StringSelection attachment = new StringSelection(userDir + file);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(attachment, null);

        sleep(1000);

        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }
}
