@Task6

Feature: Login and download file

  As a user
  I want to be able to login and download file

  Background:
    Given User is on page with task number "6"

  Scenario: User is able to logout
    When I fill the Login field with "tester"
    And I fill the Password field with "123-xyz"
    And I submit Login button
    Then I am on logged page
    And I click logout link
    And I am on login page

  Scenario: User is unable to login with incorrect data
    When I fill the Login field with "wrong login"
    And I fill the Password field with "wrong password"
    And I submit Login button
    Then I can see wrong login data error message "Nieprawidłowe dane logowania"
    And I am on login page

  Scenario: User is able to login and download file
    When I fill the Login field with "tester"
    And I fill the Password field with "123-xyz"
    And I submit Login button
    And I clean download directory
    And I click download link
    Then File is downloaded
