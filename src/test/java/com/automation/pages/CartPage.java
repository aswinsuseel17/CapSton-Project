package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy(css = ".CartPage__myBag")
    WebElement myBagHeader;
    public boolean isCartPageDisplayed(){
        return myBagHeader.isDisplayed();
    }

    @FindBy(xpath = "//div[@class='CartItemForDesktop__textWithOutOfStock']/preceding-sibling::div")
    WebElement title;
    public String cartProductTitle(){
        return title.getText();
    }

    @FindBy(className = "SizeQuantitySelectBox__bottom")
    WebElement sizeAndQuantity;
    @FindBy(xpath = "//div[@class='SizeSelector__grid']/child::div[@class='SizeSelector__child']")
    List<WebElement> sizeSelectList;
    @FindBy(xpath = "//div[text()='2']")
    WebElement quantitySelect;
    @FindBy(xpath = "//span[text()='Done']/parent::div")
    WebElement doneButton;
    public void changeSizeAndQuantity() throws InterruptedException {
        sizeAndQuantity.click();
        sizeSelectList.get(0).click();
        quantitySelect.click();
        doneButton.click();
        Thread.sleep(3000);
    }
    @FindBy(xpath = "//div[text()='Size']/following-sibling::div/span")
    WebElement sizeCheck;
    @FindBy(xpath = "//div[text()='Qty']/following-sibling::div/span")
    WebElement quantityCheck;
    public boolean verifySizeAndQuantityUpdated(String size){
        if(sizeCheck.getText().equals(size)){
            return false;
        }
        if(quantityCheck.getText().equals("1")){
            return false;
        }
        return true;
    }
}
