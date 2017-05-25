@Task3

Feature: Edit form and save changes

  As a user
  I want to be able to unlock and edit form

  Background:
    Given I'm on page with task number "3"

  Scenario: User is able to edit form after unlock
    When I enable edition mode
    And I fill all the fields
    And I upload photo
    And I save the changes
    Then I can see confirmation message "Twoje dane zostały poprawnie zapisane"
    And I can see my data in form

  Scenario: User is not able to edit form before unlock
    When I try to modify data in locked form
    Then I am not able to modify data

