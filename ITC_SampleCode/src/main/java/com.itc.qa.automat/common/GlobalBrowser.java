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

import java.util.List;
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
            webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            webdriver.manage().timeouts().setScriptTimeout(30,TimeUnit.SECONDS);

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

    protected void clickMultiSelect(String text) {


        try {

            sleep(100);

            List<WebElement> webElementList = webdriver.findElements(By.xpath("//*[contains(@class,'multiselect__content-wrapper')]/ul/li"));

            for(WebElement webElement:webElementList){

                String text_1 = webElement.getText();

                System.out.println(text_1);

                if(text_1.equalsIgnoreCase(text)){

                    webElement.click();
                    break;
                }

            }

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

    public void autoSuggestDropdown(By by, String few_chars, String target_value){

        JavascriptExecutor js = (JavascriptExecutor)webdriver;

        WebElement webElement = webdriver.findElement(by);

        webdriver.findElement(by).sendKeys(few_chars);

        sleep(2000);

        String script = "return arguments[0].value;";

        String text = (String)js.executeScript(script,webElement);

        System.out.println(text);

        int i=0;

        while (!text.equalsIgnoreCase(target_value)) {

            webdriver.findElement(by).sendKeys(Keys.DOWN);

            text = (String)js.executeScript(script,webElement);

            System.out.println(text);

            i++;

            if(i>9) {

                break;
            }
        }

    }


    public void actionsClick(By by){

        Actions actions = new Actions(webdriver);

        actions.moveToElement(webdriver.findElement(by)).click().perform();
    }
}
