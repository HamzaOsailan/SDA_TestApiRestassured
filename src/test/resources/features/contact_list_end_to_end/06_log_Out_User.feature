@End2End
Feature: Log Out User

  Scenario: Log Out User
    Given user goes to "https://thinking-tester-contact-list.herokuapp.com/users/logout"
    When user sends a POST request to log out the user
    Then the response status code should be 200