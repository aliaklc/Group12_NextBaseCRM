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

public class US4 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
    }



    @Test
    public void US4_TC () throws InterruptedException {

        CRM_Utilities.crm_login(driver, "helpdesk35@cydeo.com", "UserUser");
        driver.findElement(By.xpath("//span[@id='user-name']")).click();
        Thread.sleep(2000);


        //driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[2]")).click();
        WebElement myProfile = driver.findElement(By.xpath("//span[.='My Profile']"));
        Assert.assertTrue(myProfile.isDisplayed());

        WebElement editProfile = driver.findElement(By.xpath("//span[.='Edit Profile Settings']"));
        Assert.assertTrue(editProfile.isDisplayed());

        WebElement themes = driver.findElement(By.xpath("//span[.='Themes']"));
        Assert.assertTrue(themes.isDisplayed());

        WebElement notifications = driver.findElement(By.xpath("//span[.='Configure notifications']"));
        Assert.assertTrue(notifications.isDisplayed());

        WebElement logOut = driver.findElement(By.xpath("//span[.='Log out']"));
        Assert.assertTrue(logOut.isDisplayed());

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

}
