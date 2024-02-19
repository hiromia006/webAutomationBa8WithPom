package com.parabank.parasoft.pages;

import com.aventstack.extentreports.Status;
import com.parabank.parasoft.report.ReportTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends Page {
    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTittle() {
        return driver.getTitle();
    }

    @Override
    public WebElement getWebElement(By locator) {
        WebElement webElement = null;
        try {
            addInfo(locator.toString() + " going to operate");
            waitForWebElement(locator);
            webElement = driver.findElement(locator);
            addInfo(locator.toString() + " already did successfully operation");
        } catch (Exception exception) {
            System.out.println(locator.toString() + " Select or Locator Not Found");
        }
        return webElement;
    }

    @Override
    public List<WebElement> getWebElements(By selector) {
        List<WebElement> webElements = null;
        try {
            waitForWebElement(selector);
            webElements = driver.findElements(selector);
        } catch (Exception exception) {
            System.out.println(selector.toString() + " Select or Locator Not Found");
        }
        return webElements;

    }

    @Override
    public void waitForWebElement(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception exception) {
            System.out.println(locator.toString() + " Select or Locator Not Found");
        }
    }


    public void addInfo(String message) {
        if (ReportTestManager.getTest() != null) {
            ReportTestManager.getTest().log(Status.INFO, message);
        }
    }
}
