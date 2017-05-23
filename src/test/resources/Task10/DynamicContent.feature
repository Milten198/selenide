@Task10
Feature: Dynamically loaded content

  As a user
  I want to be able to review dynamically loading content

  Background:
    Given User is on page with task number "10"

  Scenario: User is able to scroll to the bottom
    When I scroll the page to the bottom
    Then I can see footer

  Scenario: Fragments are loaded 6 times
    When I scroll the page to the bottom
    Then Loaded fragments are equal to "6"