package com.syarah.preprod.base;

import com.syarah.preprod.Factory.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {


    protected WebDriver driver;

    @BeforeClass
    public void setup() throws InterruptedException {
        driver = new DriverFactory().initializeDriver();
        driver.get("https://syarah.com/");
        }

        @AfterClass
    public void teardown(){

        driver.quit();
        }

    }