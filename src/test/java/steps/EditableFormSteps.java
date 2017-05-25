package steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import executors.EditableFormPage;
import org.junit.Assert;

import static executors.EditableFormPage.*;

public class EditableFormSteps {

    EditableFormPage editableFormPage;

    public EditableFormSteps() {
        editableFormPage = new EditableFormPage();
    }

    @When("^I enable edition mode$")
    public void iEnableEditionMode() throws Throwable {
        editableFormPage.enableEditionMode();
    }

    @And("^I fill all the fields$")
    public void iFillAllTheFields() throws Throwable {
        editableFormPage.setName();
        editableFormPage.setSurname();
        editableFormPage.setNote();
        editableFormPage.setPhone();
    }

    @And("^I upload photo$")
    public void iUploadPhoto() throws Throwable {
        editableFormPage.uploadPhoto();
    }

    @And("^I save the changes$")
    public void iSaveTheChanges() throws Throwable {
        editableFormPage.clickSaveButton();
    }

    @Then("^I can see confirmation message \"([^\"]*)\"$")
    public void iCanSeeConfirmationMessage(String message) throws Throwable {
        Assert.assertEquals("Confirmation message is wrong", message, editableFormPage.getConfirmationMessage());
    }

    @And("^I can see my data in form$")
    public void iCanSeeMyDataInForm() throws Throwable {
        Assert.assertEquals("Wrong name", NAME, editableFormPage.getNameFromForm());
        Assert.assertEquals("Wrong surname", SURNAME, editableFormPage.getSurnameFromForm());
        Assert.assertEquals("Wrong note", NOTE, editableFormPage.getNoteFrmForm());
        Assert.assertEquals("Wrong phone number", PHONE, editableFormPage.getPhoneFromForm());
        Assert.assertTrue("Wrong image", editableFormPage.getPhotoSrc().contains("data:image/jpeg;base64"));
    }

    @When("^I try to modify data in locked form$")
    public void iTryToModifyDataInLockedForm() throws Throwable {
        Assert.assertTrue(editableFormPage.isFormEditable());
    }

    @Then("^I am not able to modify data$")
    public void iAmNotAbleToModifyData() throws Throwable {
        Assert.assertEquals("Name has been changed", "Salma", editableFormPage.getNameFromForm());
    }
}
