package steps;

import Objects.Login;
import cucumber.api.java.en.When;

public class PicoContainerSteps {

    private Login login;

    public PicoContainerSteps(Login login) {
        this.login = login;
    }

    @When("^I type user name \"([^\"]*)\" to login field$")
    public void iTypeUserNameToLoginField(String userName) throws Throwable {
        login.setUserName(userName);
    }
}
