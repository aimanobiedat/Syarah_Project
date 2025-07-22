package com.syarah.preprod.testcases;
import com.syarah.preprod.base.BaseTest;
import com.syarah.preprod.pages.CarSelectionPage;
import com.syarah.preprod.pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class CheckoutTest extends BaseTest {


    @Test
    public void shouldReserveCarSuccessfullyWithPriceValidation() {
        CarSelectionPage carSelectionPage = new CarSelectionPage(driver);

        carSelectionPage.clickCarModelAndSelectCar();

        String expectedPrice = carSelectionPage.getCarPrice();
        System.out.println(" Car price from selection page: " + expectedPrice);
        Assert.assertFalse(expectedPrice.isEmpty(), " Car price from selection page is empty!");


        String actualPrice = new CheckoutPage(driver)
                .clickBookItNow()
                .selectCashOption()
                .clickNextButton()
                .enterUserInformation("Ayman", "0511111111")
                .clickSubmitButton()
                .enterOtp("123456")
                .getCardPrice();
        System.out.println(" Car price from payment page: " + actualPrice);
        Assert.assertFalse(actualPrice.isEmpty(), "Price from payment page is empty!");
        Assert.assertEquals(actualPrice, expectedPrice, " Price mismatch between selection and checkout page!");
    }




}




