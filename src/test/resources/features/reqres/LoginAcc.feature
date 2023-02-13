@Tugas
  Feature: Login feature
    This test case is everything about login user

  Scenario: Post login user with valid json file
    Given Login with existing user with valid json
    When Send request post login user
    Then Status code should be 200 OK
    And Response body should be "QpwL5tke4Pnpja7X4" as token
    And Validate login json schema

  Scenario: Post login user with invalid json file
    Given Login with existing user with invalid json
    When Send request post login user
    Then Status code should be 400 Bad Request
    And Response body should be "Missing password" as error message
    And Validate unsuccessful login schema