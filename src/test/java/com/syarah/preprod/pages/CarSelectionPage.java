package com.syarah.preprod.pages;

import com.syarah.preprod.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarSelectionPage extends BasePage {

    public CarSelectionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@aria-label='كيا' or @aria-label='Kia']")
    private WebElement selectModel;

    @FindBy(xpath = "(//div[contains(@class,'absolute inset-0 transition-all duration-300 opacity-100')])[1]")
    private WebElement selectCar;

    @FindBy(xpath = "//strong[contains(@class,'NewPriceHolder')]")
    private WebElement carPriceElement;

    public CheckoutPage clickCarModelAndSelectCar() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(selectModel)).click();
        } catch (StaleElementReferenceException e) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(selectModel)).click();
            } catch (Exception retryEx) {
                System.out.println("Retry failed. Trying JavaScript click...");
                clickWithJS(selectModel);
            }
        } catch (Exception e) {
            System.out.println("Trying JavaScript click as fallback...");
            clickWithJS(selectModel);
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(selectCar)).click();

        return new CheckoutPage(driver);
    }

    public String getCarPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(carPriceElement));

        String priceText = carPriceElement.getText();
        return priceText.replaceAll("[^\\d]", "");
    }

}






