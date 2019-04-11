package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class AmazonWebShop_PageObject extends PageObject {
    //span[@data-component-type='s-search-results']/div[@class='s-result-list sg-row']//span[text()='Samsung Galaxy S10 Factory Unlocked Phone with 512GB (U.S. Warranty), Prism Black']
    @FindBy(id="twotabsearchtextbox")
    private WebElement textbox_search;

    @FindBy(xpath = "//input[@value='Go']")
    private WebElement button_go;

    @FindAll({@FindBy(xpath="//span[@class='a-price']")})
    private List<WebElement> span_price_tag;

    @FindBy(id="add-to-cart-button")
    private WebElement button_add_to_cart;


    public AmazonWebShop_PageObject(WebDriver driver) {
        super(driver);
    }

    public void searchForProduct(String name){
        this.textbox_search.sendKeys(name);
        this.button_go.click();
    }

    public void addProductToCart(String price){
        for (WebElement element_price: span_price_tag) {
            if (element_price.getText().equals(price)){
                element_price.click();
            }
        }
        button_add_to_cart.click();
    }


}
