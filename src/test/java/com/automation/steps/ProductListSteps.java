package com.automation.steps;

import com.automation.pages.ProductListPage;
import com.automation.utils.ConfigReader;
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


    @Then("verify {string} listing page is displayed")
    public void verifyHeadsetListingPageIsDisplayed(String key) {
        Assert.assertTrue(productListPage.isItemHeadingDisplayed(ConfigReader.getConfigValue(key)));
        Assert.assertTrue(productListPage.isProductListPageDisplayed());
    }

    @When("user selects filter by brand {string}")
    public void userSelectsFilterByBrand(String key) throws InterruptedException {
        productListPage.addBrandFilter(ConfigReader.getConfigValue(key));
    }

    @Then("verify filter {string} is applied")
    public void verifyFilterIsApplied(String key) {
        Assert.assertTrue(productListPage.isBrandFilterApplied(ConfigReader.getConfigValue(key)));
    }
}
