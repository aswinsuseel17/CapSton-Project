package com.automation.steps;

import com.automation.pages.CartPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class CartSteps {

    CartPage cartPage = new CartPage();

    @And("verify cart contain the correct item")
    public void verifyCartContainTheCorrectItem() {
        Assert.assertEquals(ConfigReader.getConfigValue("product.name"),cartPage.cartProductTitle());
    }
}
