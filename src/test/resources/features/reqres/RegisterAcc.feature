@Tugas
  Feature: Register account
    This test case is everything about register user

  Scenario: Post new register user with valid json file
    Given Create new register with valid json
    When Send request post register user
    Then Status code should be 200 OK
    And Response body should be 4 as id and "QpwL5tke4Pnpja7X4" as token
    And Validate register json schema

  Scenario: Post new register user with invalid json file
    Given Create new register with invalid json
    When Send request post register user
    Then Status code should be 400 Bad Request
    And Response body should be "Missing password" as error message
    And Validate unsuccessful register schema