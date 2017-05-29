package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import executors.BasketOperationsPage;
import org.junit.Assert;

public class BasketOperationsSteps {

    public BasketOperationsPage operationsPage;

    public BasketOperationsSteps() {
        operationsPage = new BasketOperationsPage();
    }

    @When("^I add product \"([^\"]*)\" with quantity \"([^\"]*)\"$")
    public void iAddProductWithQuantity(String productName, String productQuantity) throws Throwable {
        operationsPage.setQuantityOfProduct(productName, productQuantity)
                .addProductToBasket(productName);
    }

    @Then("^I can see total quantity of products in basket$")
    public void iCanSeeTotalQuantityOfProductsInBasket() throws Throwable {
        Assert.assertTrue("Wrong products quantity", operationsPage.verifyTotalQuantity());
    }

    @And("^I can see total price to pay for products$")
    public void iCanSeeTotalPriceToPayForProducts() throws Throwable {
        Assert.assertTrue("Wrong price to pay", operationsPage.verifyTotalPrice());
    }

    @And("^Basket has \"([^\"]*)\" products$")
    public void basketHasProducts(String numberOfProducts) throws Throwable {
        Assert.assertEquals("Wrong number of products", numberOfProducts, operationsPage.numberOfProductsInBasket());
    }

    @Then("^I remove product \"([^\"]*)\"$")
    public void iRemoveProduct(String productName) throws Throwable {
        operationsPage.removeProductFromBasket(productName);
    }

    @And("^Product \"([^\"]*)\" is not in the basket$")
    public void productIsNotInTheBasket(String productName) throws Throwable {
        Assert.assertTrue("Product still in basket", operationsPage.isProductNotInBasket(productName));
    }
}
