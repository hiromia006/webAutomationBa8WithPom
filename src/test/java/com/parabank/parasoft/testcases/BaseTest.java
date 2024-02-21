package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.BasePage;
import com.parabank.parasoft.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    Page page;
    private Properties properties;

    public BaseTest() {
        String pathPath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        try {
            properties = new Properties();
            FileInputStream inputStream = new FileInputStream(pathPath);
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    @Parameters("BrowserType")
    public void setupBrowser(String BrowserType) {
//        String browserName = properties.getProperty("browserName");
        String browserName = BrowserType;
        if (Objects.equals(browserName, "firefox")) {
            driver = new FirefoxDriver();
        } else if (Objects.equals(browserName, "chrome")) {
            driver = new ChromeDriver();
        } else if (Objects.equals(browserName, "headless")) {
            FirefoxOptions options=new FirefoxOptions();
            options.addArguments("-headless");
            driver = new FirefoxDriver(options);
        } else {
            System.out.println("Please provide right Browser Name");
        }

        driver.manage().window().maximize();
        driver.get(properties.getProperty("baseUrl"));
        page = new BasePage(driver);

    }


    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public WebDriver getWebDriver() {
        return driver;
    }

}
