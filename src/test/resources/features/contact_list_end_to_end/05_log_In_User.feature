@End2End
Feature: Log In User

  Scenario: Log In User
    Given user goes to "https://thinking-tester-contact-list.herokuapp.com/users/login"
    When user sends a POST request to log in with the following data:
      """
      {
          "email": "test2@fake.com",
          "password": "myNewPassword"
      }
      """
    Then the response status code should be 200