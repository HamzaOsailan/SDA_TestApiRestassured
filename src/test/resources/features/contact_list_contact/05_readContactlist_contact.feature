@Contact
Feature: read Contact list

  Scenario: User can patch contact via API
    Given set the url for readContactlist
    When send the get request for readContactlist
    Then do assertion readContactlist