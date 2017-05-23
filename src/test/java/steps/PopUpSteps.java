package steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import executors.PopUpFormPage;
import executors.PopupFormWindow;
import org.junit.Assert;

import static executors.PopupFormWindow.FormFields.EMAIL;
import static executors.PopupFormWindow.FormFields.PHONE;

public class PopUpSteps {

    private PopUpFormPage formPage;
    private PopupFormWindow formWindow;

    public PopUpSteps() {
        formPage = new PopUpFormPage();
        formWindow = new PopupFormWindow();
    }

    @When("^I click on Apply button$")
    public void iClickOnApplyButton() throws Throwable {
        formPage.clickApplyBtn();
    }

    @And("^Form in window is open$")
    public void formInWindowIsOpen() throws Throwable {
        formPage.switchToPopup();
        formWindow.switchToFrame();
        Assert.assertTrue("Frame is not focused", formWindow.isAlertDisplayedAndFocused());
    }

    @And("^I fill the Name field with \"([^\"]*)\"$")
    public void iFillTheNameFieldWith(String name) throws Throwable {
        formWindow.setName(name);
    }

    @And("^I fill the Email field with \"([^\"]*)\"$")
    public void iFillTheEmailFieldWith(String email) throws Throwable {
        formWindow.setEmail(email);
    }

    @And("^I fill the Phone number field with \"([^\"]*)\"$")
    public void iFillThePhoneNumberFieldWith(String phoneNumber) throws Throwable {
        formWindow.setPhoneNumber(phoneNumber);
    }

    @And("^I submit Save button$")
    public void iSubmitSaveButton() throws Throwable {
        formWindow.clickSaveBtn();
    }


    @Then("^Confirmation message \"([^\"]*)\" is displayed$")
    public void confirmationMessageIsDisplayed(String message) throws Throwable {
        Assert.assertEquals("Wrong confirmation message", message, formWindow.getConfirmationMessage());
    }

    @Then("^I can see error message \"([^\"]*)\" for email$")
    public void iCanSeeErrorMessageForEmail(String message) throws Throwable {
        Assert.assertEquals(message, formWindow.getErrorMessage(EMAIL));
    }

    @And("^I can see error message \"([^\"]*)\" for phone number$")
    public void iCanSeeErrorMessageForPhoneNumber(String message) throws Throwable {
        Assert.assertEquals(message, formWindow.getErrorMessage(PHONE));
    }
}
