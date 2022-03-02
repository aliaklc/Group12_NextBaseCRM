package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US13 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
    }


    @Test //Send the appreciation succesfully
    public void test_US13_TC1() throws InterruptedException {

        CRM_Utilities.crm_login(driver, "helpdesk35@cydeo.com", "UserUser");
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']")).click();
        Thread.sleep(2000);


        driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[2]")).click();

        driver.switchTo().frame(0);
        WebElement element1 = driver.findElement(By.xpath("//body[@contenteditable='true']"));

        element1.sendKeys("hello");
        driver.switchTo().parentFrame();
//
//
        driver.findElement(By.xpath("//button[@id='blog-submit-button-save']")).click();
        WebElement element2 = driver.findElement(By.xpath("(//div[@class='feed-post-text-block-inner-inner'])[1]"));
       Assert.assertTrue(element2.isDisplayed());


//        String  actualMessage = element2.getText();
//        String expectedMessage = "hello";
//        Assert.assertEquals(actualMessage,expectedMessage,"Verification is failed!");


    }

    @Test //Send the appreciation no text message
    public void test_US13_TC2() throws InterruptedException {

        CRM_Utilities.crm_login(driver, "helpdesk35@cydeo.com", "UserUser");
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[2]")).click();

        Thread.sleep(2000);


        driver.findElement(By.xpath("//button[@id='blog-submit-button-save']")).click();
        WebElement getTextMethod = driver.findElement(By.xpath("//span[@class='feed-add-info-text']"));
        String actualText = getTextMethod.getText();
        String expectedText = "The message title is not specified";


        Assert.assertEquals(actualText, expectedText, "Verification failed!");


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }


}
