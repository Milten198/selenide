package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import executors.CardPaymentPage;
import org.junit.Assert;

public class CardPaymentSteps {

    private CardPaymentPage cardPaymentPage;

    public CardPaymentSteps() {
        cardPaymentPage = new CardPaymentPage();
    }

    @When("^I select a credit card type \"([^\"]*)\"$")
    public void iSelectACreditCardType(String cardType) throws Throwable {
        cardPaymentPage.selectCardType(cardType);
    }

    @And("^I type name \"([^\"]*)\"$")
    public void iTypeName(String name) throws Throwable {
        cardPaymentPage.setName(name);
    }

    @And("^I type credit card number \"([^\"]*)\"$")
    public void iTypeCreditCardNumber(String cardNumber) throws Throwable {
        cardPaymentPage.setCardNumber(cardNumber);
    }

    @And("^I type CVV code \"([^\"]*)\"$")
    public void iTypeCVVCode(String cvv) throws Throwable {
        cardPaymentPage.cvvCode(cvv);
    }

    @And("^I select expiration date \"([^\"]*)\", \"([^\"]*)\"$")
    public void iSelectExpirationDate(String month, String year) throws Throwable {
        cardPaymentPage.setMonth(month);
        cardPaymentPage.setYear(year);
    }

    @And("^I click pay button$")
    public void iClickPayButton() throws Throwable {
        cardPaymentPage.clickPayButtn();
    }

    @Then("^Payment confirmation message \"([^\"]*)\" is displayed$")
    public void paymentConfirmationMessageIsDisplayed(String message) throws Throwable {
        Assert.assertEquals("Wrong message or no message displayed", message, cardPaymentPage.verifyMessage());
    }

    @Then("^Payment expiration date message \"([^\"]*)\" is displayed$")
    public void paymentExpirationDateMessageIsDisplayed(String message) throws Throwable {
        Assert.assertEquals("Wrong message or no message displayed", message, cardPaymentPage.verifyMessage());
    }
}
