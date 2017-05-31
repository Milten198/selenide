package steps;

import Objects.Login;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class PicoContainerReport {

    private Login login;

    public PicoContainerReport(Login login) {
        this.login = login;
    }

    @Then("^I can see \"([^\"]*)\" in login field$")
    public void iCanSeeInLoginField(String userName) throws Throwable {
        Assert.assertEquals("User names are not the same", userName, login.getUserName());
    }
}
