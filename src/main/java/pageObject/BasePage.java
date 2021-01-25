package pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BasePage {
    protected AppiumDriver driver;
    private WebDriverWait wait;
    private FluentWait<WebDriver> fluentlyWait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 40);
        fluentlyWait = new FluentWait<WebDriver>(this.driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class);
    }

    public WebElement waitForElementToBeVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementToBeVisible(By by, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public WebElement waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementToBeClickable(By by, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForVisibilityOfAllElements(By by) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitForVisibilityOfAllElements(List<WebElement> webElementList) {
        wait.until(ExpectedConditions.visibilityOfAllElements(webElementList));
    }



    public WebElement scrollToText(String text) {
        try {
            return driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector()" +
                            ".scrollable(true)" +
                            ".instance(0))" +
                            ".scrollIntoView(new UiSelector()" +
                            ".text(\"" + text + "\")" +
                            ".instance(0))"
            ));
        } catch (Exception e) {

        }
        return null;
    }

    public WebElement scrollToResourceId(String resourceId) {
        try {
            return driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector()" +
                            ".scrollable(true)" +
                            ".instance(0))" +
                            ".scrollIntoView(new UiSelector()" +
                            ".resourceId(\"" + resourceId + "\")" +
                            ".instance(0))"
            ));
        } catch (Exception e) {

        }
        return null;
    }

}
