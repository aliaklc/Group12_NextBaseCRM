package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory3 {

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
    }

    @Test
    public void logOut_test() throws InterruptedException {
        CRM_Utilities.crm_login(driver, "hr34@cydeo.com","UserUser");

        driver.findElement(By.xpath("//div[@id='user-block']")).click();

        WebElement logOutBtn = driver.findElement(By.linkText("Log out"));
        Thread.sleep(2000);
        logOutBtn.click();

        BrowserUtils.verifyTitle(driver,"Authorization");

    }

    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }



}
