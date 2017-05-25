package steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import executors.HomePage;
import executors.LoggedPage;
import executors.LoginPage;
import org.junit.Assert;

public class LoginAndDownloadSteps {

    private LoggedPage loggedPage;
    private LoginPage loginPage;

    public LoginAndDownloadSteps() {
        loggedPage = new LoggedPage();
        loginPage = new LoginPage();
    }


    @When("^I fill the Login field with \"([^\"]*)\"$")
    public void iFillTheLoginFieldWith(String login) throws Throwable {
        loginPage.setLogin(login);
    }

    @And("^I fill the Password field with \"([^\"]*)\"$")
    public void iFillThePasswordFieldWith(String password) throws Throwable {
        loginPage.setPassword(password);
    }

    @And("^I submit Login button$")
    public void iSubmitLoginButton() throws Throwable {
        loginPage.clickLoginBtn();
    }


    @Then("^I am on logged page$")
    public void iAmOnLoggedPage() throws Throwable {
        loggedPage.verifyLoggedPageIsVisible();
    }

    @And("^I click logout link$")
    public void iClickLogoutLink() throws Throwable {
        loggedPage.clickLogoutLink();
    }

    @And("^I am on login page$")
    public void iAmOnLoginPage() throws Throwable {
        loginPage.verifyLoginPageIsVisible();
    }

    @Then("^I can see wrong login data error message \"([^\"]*)\"$")
    public void iCanSeeWrongLoginDataErrorMessage(String message) throws Throwable {
        loginPage.verifyLoginErrorMessage(message);
    }

    @And("^I clean download directory$")
    public void iCleanDownloadDirectory() throws Throwable {
        loggedPage.cleanDownloadFolder();
    }

    @And("^I click download link$")
    public void iClickDownloadLink() throws Throwable {
        loggedPage.clickDownloadLink();
    }

    @Then("^File is downloaded$")
    public void fileIsDownloaded() throws Throwable, Exception {
        Assert.assertTrue("File was not downloaded or wrong file downloaded", loggedPage.checkIfFileWasDownloaded());
    }
}
