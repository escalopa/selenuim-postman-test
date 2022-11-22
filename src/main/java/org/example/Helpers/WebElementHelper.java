package org.example.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementHelper {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public WebElementHelper(WebDriver driver, int waitAmountOfSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(waitAmountOfSeconds));
    }

    public void findByIdAndSendKeys(String id, String text) {
        this.driver.findElement(By.id(id)).click();
        this.driver.findElement(By.id(id)).sendKeys(text);
    }

    public void findByCssAndSendKeys(String cssSelector, String text) {
        this.driver.findElement(By.cssSelector(cssSelector)).click();
        this.driver.findElement(By.cssSelector(cssSelector)).sendKeys(text);
    }

    public void waitByIdAndSendKeys(String id, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        this.findByIdAndSendKeys(id, text);
    }

    public void waitByCssSelectorAndClick(String cssSelector) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
        this.driver.findElement(By.cssSelector(cssSelector)).click();
    }
}
