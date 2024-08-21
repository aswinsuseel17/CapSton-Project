Feature: Validate product list page functionalities

  Background:
    Given user opens website
    Then verify user is on homepage
    When user search an item "search.item" in search bar
    Then verify "search.item" listing page is displayed

  Scenario: Verify user can filter product list
    When user selects filter by brand "filter.brand"
    Then verify filter "filter.brand" is applied

  Scenario: Verify user can sort price high to low
    And user sort price high to low
    Then verify whether product list is sorted

  Scenario: Verify user can give feedback
    When user clicks give feedback button
    Then verify feedback form is displayed
    And user enters feedback and click next
    When user enters text and clicks submit
    Then verify "Thank you for sharing your feedback!" is displayed
