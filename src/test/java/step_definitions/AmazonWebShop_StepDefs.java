package step_definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.AmazonWebShop_PageObject;
import support.FunctionalTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonWebShop_StepDefs extends FunctionalTest {
    private AmazonWebShop_PageObject amazonWebShop_pageObject;

    @Before()
    public void before() {
        initialization();
        amazonWebShop_pageObject = new AmazonWebShop_PageObject(driver);
    }

    @After()
    public void after() {
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

    @When("add {string} products to cart with price {string}")
    public void add_products_to_cart_with_price(String quantity, String price) {
        amazonWebShop_pageObject.addProductToCart(quantity, price);
    }

    @Then("Verify {string} products are present in cart")
    public void verify_products_are_present_in_cart(String quantity) {
        Assert.assertEquals(quantity, amazonWebShop_pageObject.getCartCount());
    }

    @Then("Verify {string} is in the cart")
    public void verify_is_in_the_cart(String product_name) {
        boolean found = false;
        List<String> list_string = amazonWebShop_pageObject.getProductNamesFromCart();
        for (String str : list_string) {
            if (str.contains(product_name)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
    }

    @When("I change {string} in view cart page")
    public void i_change_in_view_cart_page(String increase_quantity) {
       amazonWebShop_pageObject.increaseQuantityOnViewCart(increase_quantity);
    }

    @Then("Verify total price {string}")
    public void verify_total_price_has_increased(String total_price) {
       Assert.assertTrue(amazonWebShop_pageObject.getTotalPrice().contains(total_price));
    }

}
