Feature: Validate sorting functionality
  Scenario: Verify user can sort price high to low
    Given user opens website
    Then verify user is on homepage
    When user search an item "search.item" in search bar
    Then verify "search.item" listing page is displayed
    And user sort price high to low
    Then verify whether product list is sorted