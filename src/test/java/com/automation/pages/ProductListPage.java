package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;

public class ProductListPage extends BasePage{

    @FindBy(css = ".SelectBoxDesktop__boxIconLeft")
    WebElement sortByBtn;
    @FindBy(className = "FilterDesktop__filterClearTxt1")
    WebElement filterOptn;
    public boolean isProductListPageDisplayed(){
        return sortByBtn.isDisplayed() && filterOptn.isDisplayed();
    }

    @FindBy(tagName = "h1")
    WebElement headingText;
    public boolean isAdidasListPageDisplayed(){
        return headingText.getText().contains("Adidas");
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
}
