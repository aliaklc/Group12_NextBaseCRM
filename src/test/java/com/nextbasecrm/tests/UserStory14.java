package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory14 {

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
    }

    @Test
    public void desktopOptions() throws InterruptedException {
        CRM_Utilities.crm_login(driver, "hr34@cydeo.com", "UserUser");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1200);");
        Thread.sleep(3000);

        WebElement macOS = driver.findElement(By.xpath("//a[@style='width: 33%;']"));
        String actual = macOS.getText();
        String expected = "MAC OS";
        Assert.assertEquals(actual, expected, "Verification failed");

        WebElement windows = driver.findElement(By.xpath("//a[@style='width: 37%;']"));
        actual = windows.getText();
        expected = "WINDOWS";
        Assert.assertEquals(actual, expected, "Verification failed");

        WebElement linux = driver.findElement(By.xpath("//a[@href='https://github.com/buglloc/brick']"));
        actual = linux.getText();
        expected = "LINUX";
        Assert.assertEquals(actual, expected, "Verification failed");


    }

    @AfterMethod
    public void tearDown() {
        //driver.close();
    }


}
