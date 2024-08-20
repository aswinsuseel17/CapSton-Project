package com.automation.steps;

import com.automation.pages.website.ProductDetailPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductDetailSteps {

    ProductDetailPage productDetailPage = new ProductDetailPage();

    @Then("verify whether product detail page is displayed")
    public void verifyWhetherProductDetailPageIsDisplayed() {
        Assert.assertTrue(productDetailPage.isTheClickedProductDisplayed());
    }

    @And("user clicks add to cart button")
    public void userClicksAddToCartButton() {
        productDetailPage.clickAddToCart();
    }


    @Then("verify cart count is {string}")
    public void verifyCartCountIs(String count) {
        Assert.assertEquals(count,productDetailPage.verifyCartCount());
    }

    @And("user click cart icon")
    public void userClickCartIcon() {
        productDetailPage.clickCartIcon();
    }

    @And("user selects size {string} of the product")
    public void userSelectsSizeOfTheProduct(String key) {
        productDetailPage.selectSize(key);
    }

    @When("user clicks more product info")
    public void userClicksMoreProductInfo() {
        productDetailPage.clickMoreProductInfo();
    }

    @Then("verify product info is displayed")
    public void verifyProductInfoIsDisplayed() {
        Assert.assertTrue(productDetailPage.isProductInfoDisplayed());
    }

    @When("user clicks visit store button")
    public void userClicksVisitStoreButton() {
        productDetailPage.clickVisitStore();
    }

}
