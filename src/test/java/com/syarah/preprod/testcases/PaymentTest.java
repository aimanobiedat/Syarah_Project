package com.syarah.preprod.testcases;

import com.syarah.preprod.base.BaseTest;
import com.syarah.preprod.pages.CarSelectionPage;
import org.testng.annotations.Test;

public class PaymentTest extends BaseTest {

    @Test
    public void shouldCompletePaymentSuccessfully() {
        new CarSelectionPage(driver)
                .clickCarModelAndSelectCar()
                .clickBookItNow()
                .selectCashOption()
                .clickNextButton()
                .enterUserInformation("Ayman", "0511111111")
                .clickSubmitButton()
                .enterOtp("123456")
                .enterCardDetails("Ayman Ayman", "4111111111111111", "12/26", "123");


    }

    }
