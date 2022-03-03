package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US10_TC1_Misha {



    WebDriver driver;


    @BeforeMethod// Once a task is created successfully,
    // there should be a confirmation message dimply in a popup. “Task has been created”
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
        WebElement login = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));

        login.sendKeys("hr34@cydeo.com");
        password.sendKeys("UserUser");
        loginButton.click();

    }

    @Test
    public void test1(){



        WebElement taskButton = driver.findElement(By.xpath("//span[.='Task'][1]"));
        taskButton.click();

        WebElement taskTitle = driver.findElement(By.xpath("//input[@name='ACTION[0][ARGUMENTS][data][TITLE]']"));
        taskTitle.sendKeys("Data Data");

        WebElement taskMassageFrame = driver.findElement(By.xpath("(//iframe[@class='bx-editor-iframe'])[2]"));
        driver.switchTo().frame(taskMassageFrame);

        WebElement taskMassage = driver.findElement(By.xpath("//body[@style='min-height: 84px;']"));
        taskMassage.sendKeys("Data Data");

        driver.switchTo().parentFrame();

        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
/*
        WebElement popUpWindow = driver.findElement(By.xpath("//div[@class='feed-create-task-popup-title']"));

        String actualTextPopOpWindow = popUpWindow.getText();
        String expectedTextPopOpWindow = "Task has been created";

        Assert.assertEquals(actualTextPopOpWindow, expectedTextPopOpWindow);
*/

        WebElement popupWindow = driver.findElement(By.xpath("//div[@id='blogPostEditCreateTaskPopup']"));

        boolean popupWindowDisplayed = popupWindow.isDisplayed();

        Assert.assertTrue(popupWindowDisplayed);

        driver.close();

    }

    @Test //The task name is not specified.” The message should display when the user did not write the task title.
    public void test2(){

        WebElement taskButton = driver.findElement(By.xpath("//span[.='Task'][1]"));
        taskButton.click();

        WebElement taskMassageFrame = driver.findElement(By.xpath("(//iframe[@class='bx-editor-iframe'])[2]"));
        driver.switchTo().frame(taskMassageFrame);

        WebElement taskMassage = driver.findElement(By.xpath("//body[@style='min-height: 84px;']"));
        taskMassage.sendKeys("Data Data");

        driver.switchTo().parentFrame();

        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

        WebElement errorMassage = driver.findElement(By.xpath("//div[@class='task-message-label error']"));

        boolean errorMassageDisplayed = errorMassage.isDisplayed();

        Assert.assertTrue(errorMassageDisplayed);

        driver.close();



    }




}
