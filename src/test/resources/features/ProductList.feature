Feature: Validate product list page functionalities

  Background:
    Given user opens website
    Then verify user is on homepage
    When user search an item "search.item" in search bar
    Then verify "search.item" listing page is displayed

  Scenario: Verify user can give feedback
    When user clicks give feedback button
    Then verify feedback form is displayed
    And user enters feedback and click next
    When user enters text and clicks submit
    Then verify "Thank you for sharing your feedback!" is displayed

  Scenario: Verify user can swipe product images
    When user click right shift arrow
    Then verify image is changing

  Scenario: Verify user can switch between different views
    When user clicks on the view icon
    Then verify view has changed





