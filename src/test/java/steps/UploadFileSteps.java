package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import executors.UploadFilePage;
import org.junit.Assert;

public class UploadFileSteps {

    private UploadFilePage filePage;

    public UploadFileSteps() {
        filePage = new UploadFilePage();
    }

    @When("^I upload file \"([^\"]*)\"$")
    public void iUploadFile(String file) throws Throwable {
        filePage.uploadFile(file);
    }

    @Then("^I can see data in table$")
    public void iCanSeeDataInTable() throws Throwable {
        Assert.assertTrue("List are not equal or one list is empty", filePage.compareTwoLists());
    }
}
