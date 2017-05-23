package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import executors.DragAndDropPage;
import org.junit.Assert;

public class DragAndDropSteps {

    private DragAndDropPage dropPage;

    public DragAndDropSteps() {
       dropPage = new DragAndDropPage();
    }

    @When("^I set \"([^\"]*)\" of \"([^\"]*)\"$")
    public void iSetOf(String productQuantity, String productNumber) throws Throwable {
        dropPage.setQuantity(productNumber, productQuantity);
    }

    @And("^I drag and drop a \"([^\"]*)\" into the basket$")
    public void iDragAndDropAIntoTheBasket(String productNumber) throws Throwable {
        dropPage.dragProductLogo(productNumber);
    }

    @Then("^I can see total \"([^\"]*)\" of product in basket$")
    public void iCanSeeTotalOfProductInBasket(String totalQuantity) throws Throwable {
        Assert.assertEquals("Quantity is different or no quantity found", totalQuantity, dropPage.totalQuantityOfProducts());
    }

    @And("^I can see total \"([^\"]*)\" to pay in basket$")
    public void iCanSeeTotalToPay(String summaryPrice) throws Throwable {
        Assert.assertEquals("Wrong price or no price found", summaryPrice, dropPage.totalPriceToPay());
    }
}
