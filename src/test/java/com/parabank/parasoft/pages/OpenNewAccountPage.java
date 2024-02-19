package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccountPage extends BasePage {
    public OpenNewAccountPage(WebDriver driver) {
        super(driver);
    }

    public OpenNewAccountPage selectType(int index) {
        new Select(getWebElement(By.id("type"))).selectByIndex(index);
        return this;
    }

    public OpenNewAccountPage selectAccount(int index) {
        new Select(getWebElement(By.id("fromAccountId"))).selectByIndex(index);
        return this;
    }

    public AccountOpenedPage clickNewAccountBtn() {
        getWebElement(By.xpath("//input[@class='button']")).click();
        return getInstance(AccountOpenedPage.class);
    }
}
