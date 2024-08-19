Feature: Validate filter functionality
  Scenario: Verify user can filter product list
    Given user opens website
    Then verify user is on homepage
    When user search an item "search.item" in search bar