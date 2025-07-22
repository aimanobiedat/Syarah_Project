package com.syarah.preprod.testcases;

import com.syarah.preprod.base.BaseTest;
import com.syarah.preprod.pages.CarSelectionPage;
import org.testng.annotations.Test;

public class CarSelectionTest extends BaseTest {

@Test
    public void shouldBeAbletoSelectcar(){
CarSelectionPage carSelectionPage=new CarSelectionPage(driver);
carSelectionPage.clickCarModelAndSelectCar();

}



}
