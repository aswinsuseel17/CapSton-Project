package com.automation.steps;

import com.automation.pages.ProductDetailPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ProductDetailSteps {

    ProductDetailPage productDetailPage = new ProductDetailPage();

    @Then("verify whether product detail page is displayed")
    public void verifyWhetherProductDetailPageIsDisplayed() {
        Assert.assertTrue(productDetailPage.isTheClickedProductDisplayed());
    }
}
