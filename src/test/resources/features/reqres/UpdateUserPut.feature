@Tugas
  Feature: Put user
    This test case is everything about update user using method put

    Scenario Outline: Put existing user with valid input
      Given Update existing user with valid json and parameter id <page>
      When Send request update user
      Then Status code should be 200 OK
      And Response body name should be "Aldan Maulana Fajri" and job is "QA Engineer"
      And Validate put user schema
      Examples:
        | page |
        | 1    |
        | 2    |
        | 3    |

    Scenario Outline: Put existing user with invalid id and valid input
      Given Update existing user with valid json and invalid parameter id "<page>"
      When Send request update user
      Then Status code should be 400 Bad Request
      Examples:
        | page |
        | 1    |
        | 2    |
        | 3    |