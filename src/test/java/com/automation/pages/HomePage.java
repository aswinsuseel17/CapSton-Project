package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public void openWebsite(){
        driver.get(ConfigReader.getConfigValue("website.url"));
    }

    @FindBy(id = "wzrk-cancel")
    WebElement askMeLater;
    public void closePopUp(){
        askMeLater.click();
    }

    @FindBy(className = "BannerDesktop__base")
    WebElement bannerBase;
    public boolean isHomePageDisplayed(){

        return bannerBase.isDisplayed();
    }

    @FindBy(xpath = "//div[text()='Brands']/div[@class='DesktopHeader__arrow']")
    WebElement brandsMenu;
    @FindBy(xpath = "//div[text()='Footwear']")
    WebElement footwearSelect;
    @FindBy(xpath = "(//div[@class='BrandImage__imageHolder']/div)[1]")
    WebElement adidasSelect;
    public void chooseBrand(){
        Actions action = new Actions(driver);
        action.moveToElement(brandsMenu).pause(1000).build().perform();
        action.moveToElement(footwearSelect).pause(1000).click(adidasSelect).build().perform();

    }


    @FindBy(xpath = "//div[@class='DesktopHeader__categoryAndBrand' and text()='Categories']")
    WebElement categoryMenu;
    @FindBy(xpath = "//div[text()=\"Men's Fashion\"]")
    WebElement mensFashionOption;
    @FindBy(xpath = "//a[text()='Shirts']")
    WebElement shirtsLink;
    public void searchCategory(){
        Actions actions = new Actions(driver);
        actions.moveToElement(categoryMenu).pause(1000).build().perform();
        actions.moveToElement(mensFashionOption).pause(1000).build().perform();
        actions.click(shirtsLink).build().perform();
    }


    @FindBy(id = "search-text-input")
    WebElement searchBox;
    @FindBy(xpath = "//span[@class='SearchResultItem__bolder' and text()='headset']")
    WebElement searchItem;
    public void searchItem(String item){
        searchBox.sendKeys(item);
        searchItem.click();
    }

}
