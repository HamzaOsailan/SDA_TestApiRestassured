@Contact
Feature: patch Contact

  Scenario: User can patch contact via API
    Given set the url for patch contact
    And set the expected data for patch contact
    When send the post request for patch contact
    Then do assertion for patch contact