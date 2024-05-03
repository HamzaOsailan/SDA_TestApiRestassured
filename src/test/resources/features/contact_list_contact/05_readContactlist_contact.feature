@Contact
Feature: read Contact list

  Scenario: User can patch contact via API
    Given set the url for readContactlist
    And set the expected data for readContactlist
    When send the get request for readContactlist
    Then do assertion readContactlist