package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage {
    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogout() {
        return getWebElements(By.linkText("Log Out")).size() > 0;
    }

    public OpenNewAccountPage clickOpenNewAccountLink() {
        getWebElement(By.linkText("Open New Account")).click();
        return getInstance(OpenNewAccountPage.class);
    }

}
