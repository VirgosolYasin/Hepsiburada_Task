Feature: API Scenarios

  @API @smoke
  Scenario: Add a new pet to the pet store
    Given Generate new random pet name as "available"
    And Sending "POST" request with random pet data
    Then Verify status code as 200
    Then Verify contains random pet name

  @API @smoke
  Scenario: Update an existing pet
    Given Generate new random pet name as "available"
    And Sending "PUT" request with random pet data
    And Saving pet id
    Then Verify status code as 200
    Then Verify contains random pet name

  @API @smoke
  Scenario: Checking pet name
    Given Sending "GET" request for all "available" pet data
    Then Verify all data contains random pet name

  @API @smoke
  Scenario: Deletes a pet
    Given Sending "DELETE" request for specific pet
    And Sending "GET" request for all "available" pet data
    Then Verify created pet is not exist anymore
