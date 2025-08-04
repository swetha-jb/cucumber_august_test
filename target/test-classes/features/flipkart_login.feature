Feature: Flipkart Login Button

  Scenario: User clicks login button on Flipkart homepage
    Given user is on Flipkart homepage
    When user closes the login popup
    Then login button should be visible and clickable
