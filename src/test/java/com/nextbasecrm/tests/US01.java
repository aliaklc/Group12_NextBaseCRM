package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US01 {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
    }

    @Test //Log in successfully
    public void test_US01_TC1() throws InterruptedException {
        CRM_Utilities.crm_login(driver, "helpdesk35@cydeo.com", "UserUser");
        Thread.sleep(2000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Portal";
        Assert.assertEquals(actualTitle,expectedTitle,"Verification is failed");

    }

    @Test //Log in unsuccessfully
    public void test_US01_TC2() throws InterruptedException {
        CRM_Utilities.crm_login(driver, "helpdesk35@cydeo.com", "UserUser1");
        Thread.sleep(2000);
        WebElement errorText = driver.findElement(By.xpath("//div[@class='errortext']"));
        String actualText = errorText.getText();
        String expectedText = "Incorrect login or password";
        Assert.assertEquals(actualText,expectedText,"Verification is failed!");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
