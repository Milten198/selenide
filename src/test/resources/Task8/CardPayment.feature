@Task8
  Feature: Payment with different credit cards

    As a user
    I want to be able to pay with different credit cards

    Background:
      Given I'm on page with task number "8"

    Scenario Outline: User is able to pay with any credit card
      When I select a credit card type "<card>"
      And I type name "Jan Kowalski"
      And I type credit card number "<number>"
      And I type CVV code "123"
      And I select expiration date "July", "2020"
      And I click pay button
      Then Payment confirmation message "Zamówienie opłacone" is displayed
      Examples:
        | card                       | number           |
        | American Express           | 371449635398431  |
        | American Express Corporate | 378734493671000  |
        | Australian BankCard        | 5610591081018250 |
        | Diners Club                | 30569309025904   |
        | Discover                   | 6011111111111117 |
        | JCB                        | 3530111333300000 |
        | MasterCard                 | 5555555555554444 |
        | Visa                       | 4111111111111111 |
        | Dankort (PBS)              | 76009244561      |
        | Switch/Solo (Paymentech)   | 6331101999990016 |


    Scenario Outline: Card expiration date expired
      When I select a credit card type "<card>"
      And I type name "Jan Kowalski"
      And I type credit card number "<number>"
      And I type CVV code "123"
      And I select expiration date "February", "2017"
      And I click pay button
      Then Payment expiration date message "Upłynął termin ważności karty" is displayed
      Examples:
        | card             | number          |
        | American Express | 371449635398431 |