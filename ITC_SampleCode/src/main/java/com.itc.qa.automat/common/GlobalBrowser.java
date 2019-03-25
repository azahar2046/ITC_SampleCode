package com.itc.qa.automat.common;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;


import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class GlobalBrowser {

    private WebDriver webdriver;
    private String userDir;

    private void setUpWebDriver() {

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

    private  void escapeTimeoutException(Throwable t) {

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

    public  void waitUntil(ExpectedCondition<?> expectedCondition) {

        WebDriverWait wait = new WebDriverWait(webdriver, 30);
        wait.until((Function<WebDriver, ?>) expectedCondition);
    }

    public  void waitUntil(ExpectedCondition<?> expectedCondition, int timeout) {

        WebDriverWait wait = new WebDriverWait(webdriver, timeout);
        wait.until((Function<WebDriver, ?>) expectedCondition);
    }


    public void openUrl(String url) {

        try {

            setUpWebDriver();

            webdriver.get(url);

        } catch (Throwable t) {

            escapeTimeoutException(t);
        }
    }


    public  void sendKeys(By by, String text) {

        try {

            sleep(100);
            Actions actions = new Actions(webdriver);
            actions.moveToElement(webdriver.findElement(by)).click().sendKeys(text).perform();

        } catch (Throwable t) {

            escapeTimeoutException(t);
        }

    }

    public  void click(By by) {

        try {

            sleep(100);
            Actions actions = new Actions(webdriver);
            actions.moveToElement(webdriver.findElement(by)).click().perform();

        } catch (Throwable t) {

            throw new RuntimeException(t);
        }

    }

    public  void click(WebElement webElement) {

        try {

            sleep(100);
            Actions actions = new Actions(webdriver);
            actions.moveToElement(webElement).click().perform();

        } catch (Throwable t) {

            throw new RuntimeException(t);
        }

    }


    public void selectOption(String text) {

        Actions actions = new Actions(webdriver);

        WebElement webElement = webdriver.findElement(By.xpath("//span[contains(text(),'" + text + "')]/ancestor::li"));

        int i = 0;

        while (!webElement.isEnabled()) {

            i++;

            if (i > 15) {

                actions.sendKeys(Keys.ARROW_DOWN).perform();

                sleep(100);

                break;
            }

        }



        click(webElement);
    }

    public void selectOptionExacttext(String text) {

        Actions actions = new Actions(webdriver);

        WebElement webElement = webdriver.findElement(By.xpath("//span[text()='" + text + "']/ancestor::li"));

        int i = 0;

        while (!webElement.isEnabled()) {

            i++;

            if (i > 15) {

                actions.sendKeys(Keys.ARROW_DOWN).perform();

                sleep(100);

                break;
            }

        }


        click(webElement);
    }


    public  void radioButton(By by, String text) {

        WebElement webElement = webdriver.findElement(by).findElement(By.xpath("//span[text()='" + text + "']"));

        click(webElement);
    }



    public void calender(String date_text, String month_text, String year_text ){

        WebElement webElement_year = webdriver.findElement(By.xpath("//*[contains(@class,'cell year')][text()='"+year_text+"']"));

        WebElement webElement_month = webdriver.findElement(By.xpath("//*[contains(@class,'cell month')][text()='"+month_text+"']"));

        WebElement webElement_date = webdriver.findElement(By.xpath("//*[contains(@class,'cell day')][text()='"+date_text+"']"));

        int i= 15;

        while (!webElement_year.isDisplayed()){

            sleep(100);

            i++;

            if(i>15){
                break;
            }
        }

        click(webElement_year);

        while (!webElement_month.isDisplayed()){

            sleep(100);

            i++;

            if(i>15){
                break;
            }
        }

        click(webElement_month);

        while (!webElement_date.isDisplayed()){

            sleep(100);

            i++;

            if(i>15){
                break;
            }
        }

        click(webElement_date);

    }



    public void scrollToView(By by){

        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";


        ((JavascriptExecutor) webdriver).executeScript(scrollElementIntoMiddle, webdriver.findElement(by));
        sleep(2000);
    }

    public  void sleep(Integer l) {

        try {

            Thread.sleep(l);

        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
    }


    public void fileUpload(String file) {

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

    public void enterScriptText(By by, String text){

        JavascriptExecutor js = (JavascriptExecutor)webdriver;

        js.executeScript("arguments[0].value='"+text+"'",webdriver.findElement(by));
    }

    public  void quitBrowser() {

        webdriver.quit();

    }




}
