package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import executors.ProductSelectPage;
import org.junit.Assert;

public class ProductSelectSteps {

    private ProductSelectPage selectPage;

    public ProductSelectSteps() {
        selectPage = new ProductSelectPage();
    }

    @When("^I expand dropdown list with categories$")
    public void iExpandDropdownListWithCategories() throws Throwable {
        selectPage.expandDropDownlist();
    }

    @And("^I select category \"([^\"]*)\"$")
    public void iSelectCategory(String category) throws Throwable {
        selectPage.pickCategory(category);
    }

    @Then("^I can see products only for this category \"([^\"]*)\"$")
    public void iCanSeeProductsOnlyForThisCategory(String category) throws Throwable {
        Assert.assertTrue("At least one products is from different category", selectPage.areProductsFromSelectedCategory(category));
    }

    @And("^I type fragment \"([^\"]*)\" of category name$")
    public void iTypeFragmentOfCategoryName(String fragment) throws Throwable {
        selectPage.typeFragmentInSearchBox(fragment);
    }

    @Then("^I can see category \"([^\"]*)\" matched for this fragment$")
    public void iCanSeeCategoryMatchedForThisFragment(String category) throws Throwable {
        Assert.assertEquals("Wrong category found", category, selectPage.getSearchedCategory());
    }
}
