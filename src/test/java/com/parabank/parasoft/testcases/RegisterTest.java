package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.CustomerLoginPage;
import com.parabank.parasoft.pages.OverviewPage;
import com.parabank.parasoft.pages.RegisterPage;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    @Test
    public void doRegisterWithFirstNameShouldFail() {
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class);
        RegisterPage registerPage = loginPage
                .clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .clickRegisterLink();
        Assert.assertTrue(registerPage.hasError(9));
    }

    @Test
    public void doRegisterWithNameShouldFail() {
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class);
        RegisterPage registerPage = loginPage
                .clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .clickRegisterLink();
        Assert.assertTrue(registerPage.hasError(8));
    }

    @Test
    public void registerShouldSucceed() {
        OverviewPage overviewPage = page.getInstance(CustomerLoginPage.class)
                .clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress(LoremIpsum.getInstance().getCity())
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getStateAbbr())
                .fillZipCode(Integer.valueOf(LoremIpsum.getInstance().getZipCode()))
                .fillPhone(LoremIpsum.getInstance().getPhone())
                .fillSsn("522-83-1308")
                .fillUsername(LoremIpsum.getInstance().getName())
                .fillPassword("abcd")
                .fillConfirmPassword("abcd")
                .clickRegisterBtn();
        Assert.assertTrue(overviewPage.isLogout());

    }
}
