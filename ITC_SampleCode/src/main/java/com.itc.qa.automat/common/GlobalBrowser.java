package com.itc.qa.automat.common;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;


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

    private void escapeTimeoutException(Throwable t) {

        if (t instanceof TimeoutException) {

            try {

                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_ESCAPE);
                robot.keyRelease(KeyEvent.VK_ESCAPE);

            } catch (AWTException e) {

                throw new RuntimeException(e);
            }

        } else {

            throw new RuntimeException(t);
        }
    }

    protected void waitUntil(ExpectedCondition<?> expectedCondition) {

        WebDriverWait wait = new WebDriverWait(webdriver, 30);
        wait.until((Function<WebDriver, ?>) expectedCondition);
    }

    protected void openUrl(String url) {

        try {

            webdriver.get(url);

        } catch (Throwable t) {

            escapeTimeoutException(t);
        }
    }


    protected void click(By by) {

        try {

            sleep(100);
            waitUntil(ExpectedConditions.elementToBeClickable(by));
            webdriver.findElement(by).click();

        } catch (Throwable t) {

            escapeTimeoutException(t);
        }
    }

    protected void sendKeys(By by, String keys) {

        sleep(100);
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement textfield = webdriver.findElement(by);
        textfield.sendKeys(keys);
    }


    protected void selectOption(By locator_1, By locator_2, String text) {

        sleep(5000);

        List<WebElement> webElementList = webdriver.findElement(locator_1).findElements(locator_2);

        for (WebElement webElement : webElementList) {

            String text_1 = webElement.getText();

            if (text_1.contains(text)){

                clickByActions(webElement);

                break;
            }

        }
    }


    protected void radioButton(By by, String text) {

        webdriver.findElement(By.xpath("//span[text()='" + text + "']")).findElement(by).click();

    }

    protected void sendKeysByActions(By by, String text) {

        try {

            sleep(100);
            Actions actions = new Actions(webdriver);
            actions.moveToElement(webdriver.findElement(by)).click().sendKeys(text).perform();

        } catch (Throwable t) {

            escapeTimeoutException(t);
        }

    }

    protected void clickByActions(By by) {

        try {

            sleep(100);
            Actions actions = new Actions(webdriver);
            actions.moveToElement(webdriver.findElement(by)).click().perform();

        } catch (Throwable t) {

            throw new RuntimeException(t);
        }

    }

    protected void clickByActions(WebElement webElement) {

        try {

            sleep(100);
            Actions actions = new Actions(webdriver);
            actions.moveToElement(webElement).click().perform();

        } catch (Throwable t) {

            throw new RuntimeException(t);
        }

    }

    protected void moveByActions(By by) {

        try {

            sleep(100);
            Actions actions = new Actions(webdriver);
            actions.moveToElement(webdriver.findElement(by)).perform();

        } catch (Throwable t) {

            throw new RuntimeException(t);
        }

    }


    protected void sleep(Integer l) {

        try {

            Thread.sleep(l);

        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
    }


    protected void fileUpload(String file) {

        StringSelection attachment = new StringSelection(userDir + file);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(attachment, null);

        sleep(100);

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

    protected void assertAttritbute(By by, String attribute) {

        Assert.assertTrue(!webdriver.findElement(by).getAttribute(attribute).isEmpty());
    }
}
