@Tugas
  Feature: List Resource
    This test case is everything about list resource

  Scenario: Get list resource
    Given Get list resource
    When Send request get list resource
    Then Status code should be 200 OK
    And Validate get list resource schema