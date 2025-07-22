package com.syarah.preprod.pages;

import com.syarah.preprod.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='mysr-cc-name']")
    private WebElement nameOnCard;

    @FindBy(xpath = "//input[@id='mysr-cc-number']")
    private WebElement cardNumber;

    @FindBy(xpath = "//input[@placeholder='MM / YY']")
    private WebElement expiryDate;

    @FindBy(xpath = "//input[@placeholder='CVC']")
    private WebElement cvc;

    @FindBy(css = "#payment-info_car-price")
    private WebElement cardPriceElement;

    public PaymentPage enterCardDetails(String name, String number, String date, String cvv) {
        nameOnCard.sendKeys(name);
        cardNumber.sendKeys(number);
        expiryDate.sendKeys(date);
        cvc.sendKeys(cvv);
        return this;
    }


    public String getCardPrice() {
        String priceText = cardPriceElement.getText().trim();
        System.out.println(" Raw price from UI: " + priceText);

        String numericPart = priceText.replaceAll("[^\\d]", "");

        if (numericPart.length() > 5) {
            numericPart = numericPart.substring(0, 5);
        }

        return numericPart;
    }

}

//

