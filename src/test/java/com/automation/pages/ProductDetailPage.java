package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductDetailPage extends BasePage{
    @FindBy(xpath = "//div[@itemprop='name']")
    WebElement productName;
    public boolean isTheClickedProductDisplayed(){
        return productName.getText().equals(ConfigReader.getConfigValue("product.name"));
    }

    @FindBy(xpath = "//button[text()='Add To Bag']")
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

    @FindBy(xpath = "//div[@class='SizeSelectNewPdp__base']/div/div")
    List<WebElement> sizeList;
    public void selectSize(String key){
        sizeList.get(0).click();
        ConfigReader.setConfigValue(key,sizeList.get(0).getText());
    }

    @FindBy(className = "ProductDescriptionPage__moreProductInfoHead")
    WebElement moreProductInfo;
    public void clickMoreProductInfo(){
        javascriptExecuteClick(moreProductInfo);
    }

    @FindBy(css = ".MoreProductInfoComponent__header")
    WebElement productInfoHeading;
    public boolean isProductInfoDisplayed(){
        return productInfoHeading.isDisplayed();
    }

}
