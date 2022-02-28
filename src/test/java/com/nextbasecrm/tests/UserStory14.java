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
        String actual1 = macOS.getText();
        String expected1 = "MAC OS";
        Assert.assertEquals(actual1, expected1, "Verification failed");

        WebElement windows = driver.findElement(By.xpath("//a[@style='width: 37%;']"));
        String actual2 = windows.getText();
        String expected2 = "WINDOWS";
        Assert.assertEquals(actual2, expected2, "Verification failed");

        WebElement linux = driver.findElement(By.xpath("//a[@href='https://github.com/buglloc/brick']"));
        String actual3 = linux.getText();
        String expected3 = "LINUX";
        Assert.assertEquals(actual3, expected3, "Verification failed");


    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }


}
