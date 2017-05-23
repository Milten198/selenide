package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import executors.DynamicContentPage;
import org.junit.Assert;

public class DynamicContentSteps {

    DynamicContentPage contentPage;

    public DynamicContentSteps() {
        contentPage = new DynamicContentPage();
    }

    @When("^I scroll the page to the bottom$")
    public void iScrollThePageToTheBottom() throws Throwable, Exception {
        contentPage.scrollToTheFooter();
    }

    @Then("^I can see footer$")
    public void iCanSeeFooter() throws Throwable {
        Assert.assertTrue("Footer is not displayed", contentPage.isFooterVisible());
    }

    @Then("^Loaded fragments are equal to \"([^\"]*)\"$")
    public void loadedFragmentsAreEqualTo(String numberOfLoadings) throws Throwable {
        Assert.assertEquals("Wrong numbers of loadings", numberOfLoadings, contentPage.numberOfLoadings());
    }
}
