@Tugas
  Feature: Delete existing user
    This test case is everything about delete user

    Scenario Outline: Delete user with valid parameter id
      Given Delete user with valid id <id>
      When Send request delete user
      Then Status code should be 204 No Content
      Examples:
        | id |
        | 1  |
        | 2  |

    Scenario Outline: Delete user with invalid parameter id
      Given Delete user with invalid id "<id>"
      When Send request delete user
      Then Status code should be 400 Bad Request
      Examples:
        | id |  |
        | 1  |  |
        | 2  |  |
        | 3  |  |