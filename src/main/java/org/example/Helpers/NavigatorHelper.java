package org.example.Helpers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class NavigatorHelper {

    private final WebDriver driver;

    public NavigatorHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        driver.get("https://identity.getpostman.com/login");
    }
}
