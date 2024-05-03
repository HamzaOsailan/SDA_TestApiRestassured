@Contact
Feature: delete Contact

  Scenario: User can add contact via API
    Given set the url for delete contact
    And set the expected data for delete contact
    When send the delete request for delete contact
    Then do assertion for delete contact