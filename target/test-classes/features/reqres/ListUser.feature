@Tugas
Feature: Get list of existing user
  This test case is everything about list user

  Scenario Outline: Get list user with valid parameter page
    Given Get list user with valid parameter page <page>
    When Send request get list users
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate get list user json schema
    Examples:
      | page |
      | 1    |
      | 2    |

  Scenario Outline: Get list user with invalid parameter page
    Given Get list user with valid parameter page "<page>"
    When Send request get list users
    Then Status code should be 400 Bad Request
    And Response body page should be "<page>"
    Examples:
      | page |
      | 1    |
      | 2    |