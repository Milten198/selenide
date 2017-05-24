package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import executors.NodesPage;
import org.junit.Assert;

public class NodesSteps {

    private NodesPage nodesPage;

    public NodesSteps() {
        nodesPage = new NodesPage();
    }

    @When("^I click root node name$")
    public void iClickRootNodeName() throws Throwable {
        nodesPage.clickOnRootNodeName();
    }

    @Then("^I can see article with header \"([^\"]*)\"$")
    public void iCanSeeArticleWithHeader(String header) throws Throwable {
        Assert.assertEquals("Header is different or no header displayed", header, nodesPage.verifyArticleHeader());
    }

    @When("^I click root node arrow$")
    public void iClickRootNodeArrow() throws Throwable {
        nodesPage.clickOnRootNodeArrow();
    }

    @Then("^I can see \"([^\"]*)\" child node named \"([^\"]*)\"$")
    public void iCanSeeChildNodeNamed(String childNumber, String childName) throws Throwable {
        Assert.assertEquals("Wrong child number", childName, nodesPage.verifyChildNodeName(childNumber));
    }

    @When("^I double click root node name$")
    public void iDoubleClickRootNodeName() throws Throwable {
        nodesPage.doubleClickRootNodeName();
    }

    @When("^I click right button on root node name$")
    public void iClickRightButtonOnRootNodeName() throws Throwable {
        nodesPage.clickRightOnRootNodeName();
    }

    @And("^I click on change name button$")
    public void iClickOnChangeNameButton() throws Throwable {
        nodesPage.clickOnChangeNameButton();
    }

    @And("^I type new name \"([^\"]*)\"$")
    public void iTypeNewName(String newName) throws Throwable {
        nodesPage.typeNewName(newName);
    }

    @Then("^I can see root node name \"([^\"]*)\"$")
    public void iCanSeeRootNodeName(String rootNodeName) throws Throwable {
        Assert.assertEquals("Wrong root node name", rootNodeName, nodesPage.verifyRootNodeName());
    }
}
