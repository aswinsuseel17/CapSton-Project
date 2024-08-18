Feature: Validate Brand Selection functionality
  Scenario: Verify user can select brand from HomePage
    Given user opens website
    Then verify user is on homepage
    When user selects adidas from Footwear in brands menu
    Then verify whether product list page is displayed
    When user clicks on the first product
    Then verify whether product detail page is displayed
