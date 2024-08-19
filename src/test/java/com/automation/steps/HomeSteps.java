package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class HomeSteps {
    HomePage homePage = new HomePage();
    @Given("user opens website")
    public void user_opens_website() {
        homePage.openWebsite();
        homePage.closePopUp();
    }

    @Then("verify user is on homepage")
    public void verify_user_is_on_homepage() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("user selects adidas from Footwear in brands menu")
    public void userSelectsAdidasFromFootwearInBrandsMenu() {
        homePage.chooseBrand();
    }

    @When("user select Shirts from Men's fashion in Categories")
    public void userSelectShirtsFromMensSFashionInCategories() {
        homePage.searchCategory();
    }

    @When("user search an item in search bar")
    public void userSearchAnItemInSearchBar() {
        homePage.searchItem();
    }

}
