package com.automation.pages;

import com.automation.utils.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    public BasePage(){
        this.driver= DriverManager.getDriver();
        PageFactory.initElements(driver,this);
    }
    public void explicitWait(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public void javascriptExecutorClick(WebElement element){
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].click();",element);
    }

}
