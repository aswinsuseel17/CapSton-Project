Feature: Validate Brand Selection functionality

  Background:
    Given user opens website
    Then verify user is on homepage

  Scenario: Verify user can select brand from HomePage

    When user selects adidas from Footwear in brands menu
    Then verify whether product list page is displayed
    When user clicks on the first product
    Then verify whether product detail page is displayed


  Scenario: Verify user csn select category from home page

    When user select Shirts from Men's fashion in Categories
    Then verify product listing page is displayed
    When user clicks on the first product
    Then verify whether product detail page is displayed


  Scenario: Verify user can search an item
    When user search an item in search bar
    Then verify headset listing page is displayed
    When user clicks on the first product
    Then verify whether product detail page is displayed