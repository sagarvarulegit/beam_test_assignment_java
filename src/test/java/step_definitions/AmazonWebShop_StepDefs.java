package step_definitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.AmazonWebShop_PageObject;
import support.FunctionalTest;

import java.util.concurrent.TimeUnit;

public class AmazonWebShop_StepDefs {
    private AmazonWebShop_PageObject amazonWebShop_pageObject;
    private WebDriver driver;

    @Before()
    public  void before(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.amazonWebShop_pageObject = new AmazonWebShop_PageObject(driver);
    }

    @Given("I am on homepage")
    public void i_am_on_homepage() {
        driver.get("www.amazon.com");
    }

    @When("I search for product {string}")
    public void i_search_for_product(String string) {
        amazonWebShop_pageObject.searchForProduct(string);
    }

    @Then("verify all search result include {string}")
    public void verify_all_search_result_include(String string) {
       //tbd
    }

}
