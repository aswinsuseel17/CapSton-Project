package com.automation.steps;

import com.automation.pages.ProductListPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListSteps {
    ProductListPage productListPage = new ProductListPage();

    @Then("verify whether product list page is displayed")
    public void verifyWhetherProductListPageIsDisplayed() {
        Assert.assertTrue(productListPage.isProductListPageDisplayed());
        Assert.assertTrue(productListPage.isAdidasListPageDisplayed());
    }


    @When("user clicks on the first product")
    public void userClicksOnTheFirstProduct() {
        productListPage.clickFirstProduct();
    }

    @Then("verify product listing page is displayed")
    public void verifyProductListingPageIsDisplayed() {
        Assert.assertTrue(productListPage.shirtListPageHeading());
        Assert.assertTrue(productListPage.isProductListPageDisplayed());
    }

    @Then("verify headset listing page is displayed")
    public void verifyHeadsetListingPageIsDisplayed() {
        Assert.assertTrue(productListPage.isHeadsetListPageDisplayed());
        Assert.assertTrue(productListPage.isProductListPageDisplayed());
    }

}
