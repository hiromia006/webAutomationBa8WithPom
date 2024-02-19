package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerLoginPage extends BasePage {
    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }

    public CustomerLoginPage fillUsername(String username) {
        getWebElement(By.cssSelector("input[name='username']")).sendKeys(username);
        return this;
    }

    public CustomerLoginPage fillPassword(String password) {
        getWebElement(By.xpath("//input[@name='password']")).sendKeys(password);
        return this;
    }

    public OverviewPage clickLoginBtn() {
        getWebElement(By.xpath("//input[@class='button']"));
        return getInstance(OverviewPage.class);
    }
}
