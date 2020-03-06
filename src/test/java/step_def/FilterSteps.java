package step_def;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import page_obj.ResultsPage;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.Is.is;

public class FilterSteps {
    private ResultsPage resultsPage=new ResultsPage();



    @When("^I apply filter review \"([^\"]*)\"$")
    public void i_apply_filter_review(String filter){
        resultsPage.selectFilter(filter);
    }

    @Then("^I should be able to see product rating \"([^\"]*)\"$")
    public void i_should_be_able_to_see_product_rating(double expected){
        List<Double> actual=resultsPage.getProductRating();
        System.out.println(actual);
        assertThat(actual, everyItem(is(greaterThanOrEqualTo(expected))));
    }



    @When("^I select a category \"([^\"]*)\"$")
    public void i_apply_filter_category(String categoryName){
        resultsPage.selectFilterCategory(categoryName);
    }

    @Then("^I should be able to see title \"([^\"]*)\"$")
    public void i_should_be_able_to_see_title(String expected){
        String actual=resultsPage.getTitleOfCategoryPage();
        System.out.println(actual);
        assertThat(actual,containsString(expected));


    }

    @When("^I apply filter brands \"([^\"]*)\"$")
    public void i_apply_filter_brands(String selectBrand) {
        resultsPage.selectFilterBrand(selectBrand);

    }

    @Then("^I should be able to see products with names\"([^\"]*)\"$")
    public void i_should_be_able_to_see_products_with_names(String expected)  {
        List<String> actual=resultsPage.getAllProductsOfABrand();
        System.out.println(actual);
        assertThat(actual,everyItem(containsString(expected)));



    }

    @When("^I apply filter price \"([^\"]*)\"$")
    public void i_apply_filter_price(String applyFilterPrice)  {
        resultsPage.filterPrice(applyFilterPrice);
    }
    @Then("^I should be able to see product with prices greater than \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeProductWithPricesGreaterThan(Double expected) {
        List<Double> actual=resultsPage.getProductsByFilterPrice();
        System.out.println(actual);
        assertThat(actual,everyItem(greaterThanOrEqualTo(expected)));

    }


    @And("^add a random product to trolley and go to trolley$")
    public void addARandomProductToTrolleyAndShouldGoToTrolley() {
        resultsPage.selectARandomProduct();
        resultsPage.goToTrolley();

    }

    @Then("^the trolley should contain product\"([^\"]*)\"$")
    public void the_trolley_should_contain_product(String selectedRandomProduct)  {

    }


}
