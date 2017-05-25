@Task2

Feature: Select products by category

  As a user
  I want to be able to sort products by category

  Background:
    Given I'm on page with task number "2"

  Scenario Outline: User is able to sort product by category
    When I expand dropdown list with categories
    And I select category "<category>"
    Then I can see products only for this category "<category>"
    Examples:
      | category       |
      | Sport          |
      | Elektronika    |
      | Firma i usługi |

  Scenario Outline: User is able to search for category
    When I expand dropdown list with categories
    And I type fragment "<fragment>" of category name
    Then I can see category "<category>" matched for this fragment
    Examples:
      | fragment | category       |
      | el       | Elektronika    |
      | ort      | Sport          |
      | a i usł  | Firma i usługi |