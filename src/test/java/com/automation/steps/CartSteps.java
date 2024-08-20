package com.automation.steps;

import com.automation.pages.CartPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartSteps {

    CartPage cartPage = new CartPage();

    @And("verify cart contain the correct item")
    public void verifyCartContainTheCorrectItem() {
        Assert.assertEquals(ConfigReader.getConfigValue("product.name"),cartPage.cartProductTitle());
    }

    @When("user changes the size and quantity of the item")
    public void userChangesTheSizeAndQuantityOfTheItem() throws InterruptedException {
        cartPage.changeSizeAndQuantity();
    }

    @Then("verify the size {string} and quantity is updated")
    public void verifyTheSizeNadQuantityIsUpdated(String key) {
        Assert.assertTrue(cartPage.verifySizeAndQuantityUpdated(ConfigReader.getConfigValue(key)));
    }

    @Then("verify user is on cart page")
    public void verifyUserIsOnCartPage() {
        Assert.assertTrue(cartPage.isCartPageDisplayed());
    }
}
