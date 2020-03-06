package step_def;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page_obj.HomePage;
import page_obj.ResultsPage;

import java.util.List;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringEndsWith.endsWith;

public class CommonSteps {
    private HomePage homePage=new HomePage();


    @Given("^I am homepage$")
    public void i_am_homepage() {
        String actual=homePage.getCurrentUrl();
        assertThat(actual,endsWith("co.uk/"));
    }

    @When("^I search for product \"([^\"]*)\"$")
    public void i_search_for_product(String searchTerm) {
        homePage.doSearch(searchTerm);

    }


}
