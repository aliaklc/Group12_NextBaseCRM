package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US7 {

    WebDriver driver;


    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //  for (int user_id=1;user_id<10;user_id++) {
        // 1-go to login page
        driver.get(ConfigurationReader.getProperty("env"));
        //System.out.println("1-nv");

        // * 2- write username
        WebElement userName = driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));

        userName.sendKeys(ConfigurationReader.getProperty("username9"));
        //userName.sendKeys(ConfigurationReader.getProperty("username" + user_id));
        //System.out.println(ConfigurationReader.getProperty("username" + user_id));
        // System.out.println("1"+user_id);
        // * 3- write password
        WebElement password = driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        password.sendKeys(ConfigurationReader.getProperty("password") + Keys.ENTER);

        //Click poll tab on the homepage
        WebElement clickPoll = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-vote']"));
        clickPoll.click();

//            WebElement logOut = driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[5]"));
//            logOut.click();
//            System.out.println("logout");

        //Locate the text box to enter a title
        WebElement clickTextBox = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        clickTextBox.click();


        //Enter the title in the text box "Java Programming"
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        driver.findElement(By.xpath("//body[@contenteditable='true']")).sendKeys("Java Programming  -?...?!");
        driver.switchTo().parentFrame();

        //Enter the question "Please select which programming language you are most comfortable with?"
        driver.findElement(By.xpath("//input[@name='UF_BLOG_POST_VOTE_n0_DATA[QUESTIONS][0][QUESTION]']")).sendKeys("Please select which programming language you are most comfortable with?");
        //1st option
        driver.findElement(By.xpath("//input[@id='answer_0__0_']")).sendKeys("JAVA");
        //2nd option
        driver.findElement(By.xpath("//input[@id='answer_0__1_']")).sendKeys("PYTHON");
        //Click send
        driver.findElement(By.xpath("//button[@class='ui-btn ui-btn-lg ui-btn-primary']")).click();


    }






    @Test
    public void select_Poll() throws InterruptedException {


        //Select "Python" as an option
        WebElement select_Poll_Java = driver.findElement(By.xpath("(//label[@class='bx-vote-block-input-wrap-inner']/span[starts-with(@class, \"bx-vote-block-inp-substitute\")])[1]"));
        select_Poll_Java.click();
        Thread.sleep(1000);

        //Vote
        WebElement clickVoteButton = driver.findElement(By.xpath("(//div[@class='bx-vote-buttons']//button[@class='ui-btn ui-btn-lg ui-btn-primary'])[1]"));
        clickVoteButton.click();
        Thread.sleep(2000);

//            //Vote again
//            WebElement Vote = driver.findElement(By.xpath("(//div[@class='bx-vote-buttons']/button[@data-bx-vote-button='actVoting'])[1]"));
//            clickVoteButton.click();
//            Thread.sleep(3000);


    }
}



