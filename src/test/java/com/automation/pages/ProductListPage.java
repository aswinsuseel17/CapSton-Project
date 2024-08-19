package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ProductListPage extends BasePage{

    @FindBy(css = ".SelectBoxDesktop__boxIconLeft")
    WebElement sortByText;
    @FindBy(className = "FilterDesktop__filterClearTxt1")
    WebElement filterOptn;
    public boolean isProductListPageDisplayed(){
        return sortByText.isDisplayed() && filterOptn.isDisplayed();
    }

    @FindBy(tagName = "h1")
    WebElement headingText;
    public boolean isListPageHeadingDisplayed(String product){
        return headingText.getText().contains(product);
    }

    @FindBy(xpath = "//div[@class='ProductModule__content']/div/div/h2")
    List<WebElement> productList;
    public void clickFirstProduct(){
        ConfigReader.setConfigValue("product.name",productList.get(0).getText());
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].click();",productList.get(0));
        String currentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for(String handle : windowHandles){
            if(!handle.equals(currentWindow)){
                driver.switchTo().window(handle);
            }
        }
    }


    @FindBy(className = "Plp__camelCase")
    WebElement headsetPageHeading;
    public boolean isItemHeadingDisplayed(String product){
        return headsetPageHeading.getText().contains(product);
    }

    @FindBy(className = "SelectBoxDesktop__hideSelect")
    WebElement sortByBtn;
    public void sortPriceHighToLow() throws InterruptedException {
        Select sortBy = new Select(sortByBtn);
        sortBy.selectByValue("price-desc");
        Thread.sleep(2000);
    }

    @FindBy(xpath = "//div[@class='ProductDescription__discount ProductDescription__priceHolder']/h3")
    List<WebElement> priceList;
    public boolean isPriceHighToLowSorted(){

        List<Long> newPriceList = new ArrayList<>();

        for(WebElement price : priceList){
            String str = price.getText();
            newPriceList.add(Long.valueOf(str.substring(1)));

        }
        List<Long> copyPriceList = new ArrayList<>(newPriceList);
        Collections.sort(copyPriceList);
        Collections.reverse(copyPriceList);

        return newPriceList.equals(copyPriceList);

    }
}
