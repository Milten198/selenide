package steps;

import com.codeborne.selenide.Selenide;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import executors.HomePage;
import org.junit.Assert;

public class CommonSteps {

    private HomePage homePage;

    public CommonSteps() {
        homePage = new HomePage();
    }

    @Given("^I'm on page with task number \"([^\"]*)\"$")
    public void iMsOnPageWithTaskNumber(String taskNumber) throws Throwable {
        homePage.openTask(taskNumber);
    }

    @Then("^I can see alert with message \"([^\"]*)\"$")
    public void iCanSeeAlertWithMessage(String message) throws Throwable {
        Assert.assertEquals("Wrong alert or no alert has been dislayed", message, Selenide.confirm());
    }
}
