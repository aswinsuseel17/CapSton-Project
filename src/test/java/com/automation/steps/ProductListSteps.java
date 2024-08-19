package com.automation.steps;

import com.automation.pages.ProductListPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductListSteps {
    ProductListPage productListPage = new ProductListPage();

    @Then("verify whether product {string} list page is displayed")
    public void verifyWhetherProductListPageIsDisplayed(String product) {
        Assert.assertTrue(productListPage.isProductListPageDisplayed());
        Assert.assertTrue(productListPage.isListPageHeadingDisplayed(product));
    }


    @When("user clicks on the first product")
    public void userClicksOnTheFirstProduct() {
        productListPage.clickFirstProduct();
    }


    @Then("verify headset listing page is displayed")
    public void verifyHeadsetListingPageIsDisplayed() {
        Assert.assertTrue(productListPage.isHeadsetListPageDisplayed());
        Assert.assertTrue(productListPage.isProductListPageDisplayed());
    }

}
