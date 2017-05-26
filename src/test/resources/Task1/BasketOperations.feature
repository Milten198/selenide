@Task1

Feature: Basket Operations

  As a user
  I want to be able to add and remove products from basket

  Background:
    Given I'm on page with task number "1"

  Scenario: User is able to add products to basket
    When I add product "Okulary" with quantity "40"
    And I add product "Kabel" with quantity "30"
    Then I can see total quantity of products in basket
    And I can see total price to pay for products

  Scenario: User is can't to add more than 100 products quantity
    When I add product "Okulary" with quantity "101"
    And I can see alert with message "Łączna ilość produktów w koszyku nie może przekroczyć 100."

  Scenario: User can remove products from basket
    When I add product "Okulary" with quantity "20"
    And I add product "Kabel" with quantity "30"
    And Basket has "2" products
    Then I remove product "Okulary"
    And Basket has "1" products
    And Product "Okulary" is not in the basket