@Tugas
Feature: Single User
  This test case is everything about single user

  Scenario Outline: Get single user with valid id
    Given Get single user with valid parameter <id>
    When Send request get single user
    Then Status code should be 200 OK
    And Response body id should be <id>
    And Validate single user json schema
    Examples:
      | id |
      | 1  |
      | 2  |

  Scenario Outline: Get single user with invalid id
    Given Get single user with valid parameter "<id>"
    When Send request get single user
    Then Status code should be 404 Not Found
    Examples:
      | id    |
      | sadas |
      | dasd  |
