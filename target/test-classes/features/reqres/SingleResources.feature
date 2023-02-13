@Tugas
  Feature: Get single resources
    This test case is everything about single resources

  Scenario Outline: Get single resources with valid id
    Given Get single resources with valid parameter <id>
    When Send request get single resources
    Then Status code should be 200 OK
    And Response body id should be <id>
    And Validate get single resource schema
    Examples:
      | id |  |
      | 1  |  |
      | 2  |  |
      | 3  |  |

  Scenario Outline: Get single resources with invalid id
    Given Get single resources with invalid parameter "<id>"
    When Send request get single resources
    Then Status code should be 400 Bad Request
    Examples:
      | id |  |
      | 1  |  |
      | 2  |  |
      | 3  |  |