package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage{
    @FindBy(xpath = "//div[@itemprop='name']")
    WebElement productName;
    public boolean isTheClickedProductDisplayed(){
        return productName.getText().equals(ConfigReader.getConfigValue("product.name"));
    }

    @FindBy(xpath = "//span[text()='ADD TO BAG']")
    WebElement addToCartBtn;
    public void clickAddToCart(){
        addToCartBtn.click();
    }

    @FindBy(css = ".DesktopHeader__cartCount")
    WebElement cartCount;
    public String verifyCartCount(){
        return cartCount.getText();
    }

    public void clickCartIcon(){
        cartCount.click();
    }

}
