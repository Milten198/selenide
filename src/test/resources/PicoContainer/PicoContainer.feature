@PicoContainer

Feature: Login operations

  As a user
  I want to be able to type user name in login field

  Background:
    Given I'm on page with task number "6"

  Scenario: User is able to type user name in login field
    When I type user name "UserName" to login field
    Then I can see "UserName" in login field
