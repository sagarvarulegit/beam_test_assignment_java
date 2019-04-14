package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AmazonWebShop_PageObject extends PageObject {
    //span[@data-component-type='s-search-results']/div[@class='s-result-list sg-row']//span[text()='Samsung Galaxy S10 Factory Unlocked Phone with 512GB (U.S. Warranty), Prism Black']
    @FindBy(id = "twotabsearchtextbox")
    private WebElement textbox_search;

    @FindBy(xpath = "//input[@value='Go']")
    private WebElement button_go;

    @FindAll({@FindBy(xpath = "//span[@class='a-price-whole']")})
    private List<WebElement> span_price_tag;

    @FindBy(id = "add-to-cart-button")
    private WebElement button_add_to_cart;

    @FindBy(id = "quantity")
    private WebElement drpdwn_quantity;

    @FindBy(id = "nav-cart-count")
    private WebElement span_cart_count;

    @FindBy(xpath = "//a[text()='View Cart']")
    private WebElement button_view_cart;

    @FindAll(@FindBy(xpath = "//span[@class='a-size-medium sc-product-title a-text-bold']"))
    private List<WebElement> span_product_names_in_cart;

    @FindBy(name = "quantityBox")
    private WebElement textbox_quantity;

    @FindBy(xpath = "//a[@data-action='update']")
    private WebElement button_update;

    @FindBy(id = "sc-subtotal-amount-activecart")
    private WebElement span_total_price;

    @FindBy(className = "a-dropdown-prompt")
    private WebElement span_viewcart_quantity;

    @FindAll(@FindBy(xpath = "//li[@class='a-dropdown-item quantity-option']"))
    private List<WebElement> li_viewcart_quantity;

    public AmazonWebShop_PageObject(WebDriver driver) {
        super(driver);
    }

    public void searchForProduct(String name) {
        this.textbox_search.sendKeys(name);
        this.button_go.click();
    }

    public void visitHomepage() {
        driver.get("http://www.amazon.com");
    }

    public void addProductToCart(String quantity, String price) {
        for (WebElement element_price : span_price_tag) {
            if (element_price.getText().equals(price)) {
                element_price.click();
                break;
            }
        }
        Select select = new Select(drpdwn_quantity);
        select.selectByValue(quantity);
        button_add_to_cart.click();
        button_view_cart.click();
    }

    public String getCartCount() {
        return span_cart_count.getText();

    }

    public List<String> getProductNamesFromCart() {
        List<String> list_of_string = new ArrayList<>();
        for (WebElement element : span_product_names_in_cart) {
            list_of_string.add(element.getText());
        }
        return list_of_string;
    }

    public void increaseQuantityOnViewCart(String increase_quantity) {
        String initial_price = span_total_price.getText();
        if (textbox_quantity.isDisplayed()) {
            span_cart_count.click();
            textbox_quantity.click();
            textbox_quantity.sendKeys(increase_quantity);
            button_update.click();
        } else {
            span_viewcart_quantity.click();
            for (WebElement element : li_viewcart_quantity) {
                if (element.getText().equals(increase_quantity)) {
                    element.click();
                }
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("sc-subtotal-amount-activecart"), initial_price));

    }

    public String getTotalPrice() {
        return span_total_price.getText();
    }
}
