@Contact
Feature: read Contact

  Scenario: User can read contact via API
    Given set the url for read contact
    And set the expected data for read contact
    When send the get request for read contact
    Then do assertion for read contact