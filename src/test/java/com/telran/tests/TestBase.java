package com.telran.tests;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.util.concurrent.TimeUnit;


public class TestBase {
    public WebDriver driver;
//    Logger logger = LogerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void init() {
        driver = new FirefoxDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }
}


