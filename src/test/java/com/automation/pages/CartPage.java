package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//div[@class='CartItemForDesktop__textWithOutOfStock']/preceding-sibling::div")
    WebElement title;
    public String cartProductTitle(){
        return title.getText();
    }
}
