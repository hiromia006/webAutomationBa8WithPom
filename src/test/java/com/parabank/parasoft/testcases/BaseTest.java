package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.BasePage;
import com.parabank.parasoft.pages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Objects;

public class BaseTest {
    WebDriver driver;
    Page page;

    @BeforeMethod
    public void setupBrowser() {
        String browserName = "firefox";
        if (Objects.equals(browserName, "firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (Objects.equals(browserName, "chrome")) {
            WebDriverManager.chromiumdriver().setup();
            driver = new ChromeDriver();

        } else if (Objects.equals(browserName, "headless")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println("Please provide right Browser Name");
        }

        driver.manage().window().maximize();
        driver.get("");
        page = new BasePage(driver);

    }


    @AfterMethod
    public void closeBrowser() {

    }
}
