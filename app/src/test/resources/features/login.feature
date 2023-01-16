Feature: Feature to test login functionality

  Scenario: Check login is successful with valid credentials
    Given user with a valid username and password
    When send a post request to the API
    Then user is login
