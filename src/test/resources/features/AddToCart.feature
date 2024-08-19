Feature: Validate add to cart functionality
  Scenario: Verify user can add an item to cart
    Given user opens website
    Then verify user is on homepage
    When user search an item "search.item" in search bar
    Then verify "search.item" listing page is displayed
    When user clicks on the first product
    Then verify whether product detail page is displayed
    And user clicks add to cart button
    Then verify cart count is "1"
    And user click cart icon
    Then verify cart contain the correct item