Feature: Validate product detail page functionalities

  Background:
    Given user opens website
    Then verify user is on homepage
    When user search an item "search.cart" in search bar
    Then verify "search.cart" listing page is displayed
    When user clicks on the first product
    Then verify whether product detail page is displayed

  Scenario: Verify user can see more product info
    When user clicks more product info
    Then verify product info is displayed