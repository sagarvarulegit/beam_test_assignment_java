package step_definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.AmazonWebShop_PageObject;
import support.FunctionalTest;

import java.util.concurrent.TimeUnit;

public class AmazonWebShop_StepDefs extends FunctionalTest {
    private AmazonWebShop_PageObject amazonWebShop_pageObject;

    @Before()
    public  void before(){
        initialization();
        amazonWebShop_pageObject = new AmazonWebShop_PageObject(driver);
    }

    @After()
    public  void after(){
        driver.close();
    }

    @Given("I am on homepage")
    public void i_am_on_homepage() {
       amazonWebShop_pageObject.visitHomepage();
    }

    @When("I search for product {string}")
    public void i_search_for_product(String string) {
        amazonWebShop_pageObject.searchForProduct(string);
    }

    @Then("verify all search result include {string}")
    public void verify_all_search_result_include(String string) {
       //tbd
    }

    @When("add {int} products to cart with price {string}")
    public void add_products_to_cart_with_price(int quantity, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("Verify <quantity> products are present in cart")
    public void verify_quantity_products_are_present_in_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }


}
