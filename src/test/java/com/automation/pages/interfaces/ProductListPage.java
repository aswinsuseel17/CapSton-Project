package com.automation.pages.interfaces;

public interface ProductListPage {
    boolean isProductListPageDisplayed();

    boolean isListPageHeadingDisplayed(String configValue);

    void clickFirstProduct();

    boolean isItemHeadingDisplayed(String configValue);

    void sortPriceHighToLow();

    boolean isPriceHighToLowSorted();

    void addBrandFilter(String configValue, String filterType);

    boolean isBrandFilterApplied(String configValue);

    void changeView();

    boolean isViewChanged();

    boolean isSimilarProductsDisplayed();

    void clickFeedBack();

    boolean isFeedBackPageDisplayed();

    void enterFeedBack();

    void submitFeedBack();

    String successMsg();

    void sortPriceLowToHigh();

    boolean isPriceLowToHighSorted();

    void clickRightArrow();

    boolean verifyImage();

    boolean isDiscountFilterApplied();
}
