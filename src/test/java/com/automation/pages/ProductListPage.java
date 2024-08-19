package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//div[text()='Brand']/following-sibling::div")
    WebElement plusIconBrand;
    @FindBy(xpath = "//input[@placeholder='Search by brands']")
    WebElement brandInput;
    public void addBrandFilter(String brand) throws InterruptedException {
        plusIconBrand.click();
        brandInput.sendKeys(brand);
        driver.findElement(By.xpath("//div[text()='"+brand+"']")).click();
        Thread.sleep(3000);
    }

    @FindBy(xpath = "//div[@class='ProductDescription__header']")
    List<WebElement> brandProductHeaderList;
    public boolean isBrandFilterApplied(String productName){
        for(WebElement product : brandProductHeaderList){
            if(!product.getText().equals(productName)){
                return false;
            }
        }
        return true;
    }
}
