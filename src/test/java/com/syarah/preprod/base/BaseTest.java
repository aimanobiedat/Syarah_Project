package com.syarah.preprod.base;

import com.syarah.preprod.Factory.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseTest {


    protected WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new DriverFactory().initializeDriver();
        driver.get("https://preprod.syarah.com/");
        }

        @AfterMethod
    public void teardown(){

        driver.quit();
        }

    }