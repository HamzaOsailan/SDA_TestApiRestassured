@Contact
Feature: update Contact

  Scenario: User can update contact via API
    Given set the url for updating contact
    And set the expected data for updating contact
    When send the put request for updating contact
    Then do assertion for updating contact