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

public class UserStory5_Elminur {
    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com");
    }

    @Test
    public void sendMassageWithoutBody() throws InterruptedException {
        // login
        CRM_Utilities.crm_login(driver, "hr34@cydeo.com", "UserUser");
        //located messageTab then click
        WebElement messageTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']"));
        messageTab.click();

        //located messageBody
        WebElement MessageFrame = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        driver.switchTo().frame(MessageFrame);
        WebElement messageBody = driver.findElement(By.xpath("//body[@contenteditable='true']"));


        // click send button without text
        driver.switchTo().defaultContent();
        WebElement sendButton = driver.findElement(By.id("blog-submit-button-save"));
        sendButton.click();
        Thread.sleep(5000);

        // verify get warning message: "The message title is not specified"
        WebElement warningMassage = driver.findElement(By.xpath("//span[@class='feed-add-info-text']"));
        String actualMessage = warningMassage.getText();
        String expectedMessage = "The message title is not specified";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void sendMessageToMessageBody() throws InterruptedException {
        // login page
        CRM_Utilities.crm_login(driver, "hr34@cydeo.com", "UserUser");
        WebElement messageTab = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']"));
        messageTab.click();

        // located messageBody, and send message
        WebElement MessageFrame = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        driver.switchTo().frame(MessageFrame);
        WebElement messageBody = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        messageBody.click();
        messageBody.sendKeys("hello hello");

        // click send button
        driver.switchTo().defaultContent();
        WebElement sendButton = driver.findElement(By.id("blog-submit-button-save"));
        sendButton.click();
        Thread.sleep(5000);

        // verify message display in Activity Stream
        WebElement postedMessage = driver.findElement(By.xpath("(//div[@class='feed-post-text-block-inner-inner'])[1]"));
        Assert.assertTrue(postedMessage.isDisplayed());
        //Thread.sleep(5000);


    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}

