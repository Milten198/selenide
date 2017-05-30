package executors;

import locators.CardPaymentLocators;

public class CardPaymentPage {

    private CardPaymentLocators locators;

    public CardPaymentPage() {
        locators = new CardPaymentLocators();
    }

    public void selectCardType(String cardType) {
        locators.cardType.selectOption(cardType);
    }

    public void setName(String name) {
        locators.name.val(name);
    }

    public void setCardNumber(String cardNumber) {
        locators.cardNumber.val(cardNumber);
    }

    public void cvvCode(String cvvCode) {
        locators.cardCVV.val(cvvCode);
    }

    public CardPaymentPage setMonth(String month) {
        locators.monthExpirationDate.selectOption(month);
        return this;
    }

    public CardPaymentPage setYear(String year) {
        locators.yearExpirationDate.selectOption(year);
        return this;
    }

    public void clickPayButton() {
        locators.payButton.click();
    }

    public String verifyMessage() {
        return locators.cardExpirationMessage.getText();
    }
}
