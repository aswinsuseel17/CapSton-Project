package com.automation.pages.web;


import com.automation.pages.interfaces.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class WebHomePage extends WebBasePage implements HomePage {

    @Override
    public void openWebsite() {
        driver.get(ConfigReader.getConfigValue("website.url"));
    }

    @FindBy(id = "wzrk-cancel")
    WebElement askMeLater;
    @FindBy(xpath = "//div[@class='wzrkPPwarp']/a")
    WebElement popUpClose;
    @FindBy(id = "wiz-iframe")
    WebElement popupIframe;

    @Override
    public void closePopUp() {
        if (isDisplayed(popupIframe)) {

            driver.switchTo().frame(popupIframe);
            popUpClose.click();
            driver.switchTo().defaultContent();

        }
        askMeLater.click();

    }

    @FindBy(className = "BannerDesktop__base")
    WebElement bannerBase;

    @Override
    public boolean isHomePageDisplayed() {

        return bannerBase.isDisplayed();
    }

    @FindBy(xpath = "//div[text()='Brands']/div[@class='DesktopHeader__arrow']")
    WebElement brandsMenu;
    @FindBy(xpath = "//div[text()='Footwear']")
    WebElement footwearSelect;
    @FindBy(xpath = "(//div[@class='BrandImage__imageHolder']/div)[1]")
    WebElement adidasSelect;

    @Override
    public void chooseBrand() {
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

    @Override
    public void searchCategory() {
        Actions actions = new Actions(driver);
        actions.moveToElement(categoryMenu).pause(1000).build().perform();
        actions.moveToElement(mensFashionOption).pause(1000).build().perform();
        actions.click(shirtsLink).build().perform();
    }


    @FindBy(id = "search-text-input")
    WebElement searchBox;

    @Override
    public void searchItem(String item) {
        searchBox.sendKeys(item);
        Actions action = new Actions(driver);
        action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
    }

    @Override
    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(css = ".DesktopHeader__luxeryTab")
    WebElement tataLuxury;
    public void clickTataLuxury(){
        tataLuxury.click();
        String originalHandle = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for(String window : windows){
            if(!originalHandle.equals(window)){
                driver.switchTo().window(window);
            }
        }
    }

    @FindBy(xpath = "//li[@class='active']/a")
    WebElement heading;
    public boolean isLuxuryPageTitleDisplayed(){
        return heading.isDisplayed();
    }

}
