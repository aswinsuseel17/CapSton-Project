package com.automation.pages.interfaces;

public interface HomePage {
    void openWebsite();

    void closePopUp();

    boolean isHomePageDisplayed();

    void chooseBrand();

    void searchCategory();

    void searchItem(String configValue);
}
