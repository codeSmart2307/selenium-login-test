package com.pragmatic.iit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private WebDriver webDriver;

    @BeforeClass
    public void beforeClass() {
        //Open web browser
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        webDriver = new ChromeDriver();

        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod() {
        webDriver.navigate().to("http://opensource.demo.orangehrmlive.com/");
    }

    @AfterClass
    public void afterClass() {
        //Closing the browser
        webDriver.close();
    }

    @Test
    public void testValidUserLogin() {
        webDriver.findElement(By.id("txtUsername")).sendKeys("Admin");
        webDriver.findElement(By.id("txtPassword")).sendKeys("admin");
        webDriver.findElement(By.id("txtPassword")).submit();

        String welcomeMessage = webDriver.findElement(By.id("welcome")).getText();
        Assert.assertEquals(welcomeMessage, "Welcome Admin");
    }

    @Test
    public void testInvalidPassword() {

    }

    @Test
    public void testBlankUsername() {

    }

    @Test
    public void testBlankPassword() {

    }
}
