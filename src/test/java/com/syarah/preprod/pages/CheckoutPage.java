package com.syarah.preprod.pages;

import com.syarah.preprod.base.BasePage;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@id='BuyNow']")
    private WebElement bookItNowButton;

    @FindBy(xpath = "//div[contains(@class,'')]//span[contains(@class,'RadioCard-module__customRadio')]")
    private WebElement cashOption;

    @FindBy(xpath = "//button[normalize-space()='Next' or contains(text(),'متابعة')]")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@placeholder='اسمك بالكامل' or @placeholder='Enter your full name here']")
    private WebElement fullName;

    @FindBy(xpath = "//input[@class='InputPhoneNumber-module__inputField']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//strong[contains(text(),'اكمل لدفع العربون')] | //button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//strong[@id='payment-info_car-price']")
    private WebElement cardPriceElement;

    @FindBy(xpath = "//input[starts-with(@aria-label, 'Please enter OTP character')]")
    private List<WebElement> otpInputs;

    public CheckoutPage clickBookItNow() {
        bookItNowButton.click();
        return this;
    }

    public CheckoutPage selectCashOption() {
        cashOption.click();
        return this;
    }

    public CheckoutPage clickNextButton() {
        nextButton.click();
        return this;
    }

    public CheckoutPage enterUserInformation(String name, String phone) {
        fullName.clear();
        fullName.sendKeys(name);
        phoneNumber.clear();
        phoneNumber.sendKeys(phone);
        return this;
    }

    public CheckoutPage clickSubmitButton() {
        try {
            submitButton.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println(" Element click intercepted, trying JS click...");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", submitButton);
        }
        return this;
    }
    public PaymentPage enterOtp(String otp) {
        for (int i = 0; i < otp.length() && i < otpInputs.size(); i++) {
            otpInputs.get(i).clear();
            otpInputs.get(i).sendKeys(String.valueOf(otp.charAt(i)));
        }
        return new PaymentPage(driver);
    }


}















