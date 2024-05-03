@End2End
Feature: Get User

  Scenario: Get User Profile
    Given user goes to "https://thinking-tester-contact-list.herokuapp.com/users/me"
    When user sends a GET request to retrieve the user profile
    Then the response status code should be 200
