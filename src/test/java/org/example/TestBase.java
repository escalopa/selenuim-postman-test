package org.example;

import org.example.Helpers.NavigatorHelper;
import org.example.Helpers.WebElementHelper;
import org.example.Models.User;
import org.example.Models.Workspace;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    User mainUser;
    WebDriver driver;
    NavigatorHelper navigatorHelper;
    WebElementHelper webElementHelper;

    TestBase() {
        // Set up the driver
        driver = new ChromeDriver();
        navigatorHelper = new NavigatorHelper(driver);
        webElementHelper = new WebElementHelper(driver, 20);
        driver.manage().window().setSize(new Dimension(1920, 1051));

        // Set main user
        String username = System.getenv("POSTMAN_USERNAME");
        String password = System.getenv("POSTMAN_PASSWORD");
        this.mainUser = new User(username, password);
    }

    public void login() {
        navigatorHelper.navigateToLoginPage();
        webElementHelper.findByIdAndSendKeys("username", mainUser.username);
        webElementHelper.findByIdAndSendKeys("password", mainUser.password);
        driver.findElement(By.id("sign-in-btn")).click();
    }

    public void createWorkspace(Workspace workspace) {
        webElementHelper.waitByCssSelectorAndClick(".workspace-switcher__name");
        webElementHelper.waitByCssSelectorAndClick(".workspace-switcher__action");

        webElementHelper.waitByIdAndSendKeys("name", workspace.name);
        webElementHelper.findByIdAndSendKeys("summary", workspace.summary);

        driver.findElement(By.cssSelector(".create-workspace-button")).click();
    }
}
