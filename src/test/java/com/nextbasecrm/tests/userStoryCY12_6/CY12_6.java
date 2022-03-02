package com.nextbasecrm.tests.userStoryCY12_6;

import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.CRM_Utilities;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CY12_6 {


    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        //get browser, userName, password
        String browser= KeysCrm.getKey("browser");
        String userName = KeysCrm.getKey("mt1_username");
        String password = KeysCrm.getKey("password");

        driver= WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get(KeysCrm.getKey("qa_link1"));

        //logIn
        CRM_Utilities.crm_login(driver, userName, password);
    }


    @Test (priority = 1)
    public void testCase44() {

        //requirement-1
        String expectedModuleText = "MORE";

        String xPathMore= "//span[text()='More']";
        String actualModuleText = driver.findElement(By.xpath(xPathMore)).getText();

        //System.out.println(actualModuleText + " : " + expectedModuleText);
        Assert.assertEquals(actualModuleText, expectedModuleText, "Module text FAIL!");

        //requirements-2
        String[] expectedOptions= {"File","Appreciation","Announcement","Workflow"};
        int expectedNumberOfOptions= expectedOptions.length;

        driver.findElement(By.xpath(xPathMore)).click();

        List<WebElement> optionsElements = driver.findElements(By.xpath("//div[@class='menu-popup-items']/span/span[2]"));
        int actualNumberOfOptions= optionsElements.size();

        //System.out.println(expectedNumberOfOptions + " : " + actualNumberOfOptions);
        Assert.assertTrue(actualNumberOfOptions==expectedNumberOfOptions, "Options size FAIL!");

        int iter= 0;
        for (WebElement eachElement : optionsElements) {
            String actualOptions = eachElement.getText();
            Assert.assertEquals(actualOptions,expectedOptions[iter], "Options text FAIL!");
            //System.out.println(expectedOptions[iter] + " : " + actualOptions);
            iter++;
        }
    }

    @AfterMethod
    public void tearDownMethod(){

        driver.quit();

    }



}
