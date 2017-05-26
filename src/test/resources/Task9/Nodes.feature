@Task9

Feature: Operations on nodes

  As a user
  I want to be able to expand and change nodes names

  Background:
    Given I'm on page with task number "9"

  Scenario: User is able to display article with header
    When I click root node name
    Then I can see article with header "Root node"

  Scenario: User is able to expand tree with node arrow
    When I click root node arrow
    Then I can see "1" child node named "Child node 1"
    And I can see "2" child node named "Child node 2"

  Scenario: User is able to expand tree with double click
    When I double click root node name
    Then I can see "1" child node named "Child node 1"
    And I can see "2" child node named "Child node 2"

  Scenario: User is able to change name of any node
    When I click right button on root node name
    And I click on change name button
    And I type new name "New Root name"
    Then I can see root node name "New Root name"
    And I can see article with header "New Root name"

  Scenario: User tries to set too long name
    When I click right button on root node name
    And I click on change name button
    And I type new name "New root name with more than 20 signs"
    Then I can see alert with message "Podana nazwa przekracza limit 20 znaków"