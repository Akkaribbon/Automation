package pageObject;

import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Kasia on 2015-11-19.
 */
public class ComparisonPage extends PageObject{

    private final static Logger logger = LoggerFactory.getLogger(ComparisonPage.class);

    public ComparisonPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[6]/td[2]")
    WebElementFacade availability;

    @FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[1]/td[2]")
    WebElementFacade productName;

    @FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[3]/td[2]")
    WebElementFacade price;

    @FindBy(className = "btn-danger")
    WebElementFacade removeButton;

    @FindBy(className = "btn-primary")
    WebElementFacade addToCartButton;

    @FindBy(className = "alert-success")
    WebElementFacade successAlertForProductModify;

    @FindBy(xpath = "//a[@title='Shopping Cart']")
    WebElementFacade shoppingCart;

    public String getTextFromAvailabilityColumn () {
        return availability.getText();
    }

    public String getTextFromProductNameColumn () {
        return productName.getText();
    }

    public String getPriceFromComparisonPage() {
        return price.getText();
    }

    public ComparisonPage removeOutOfStockItem() {
        logger.debug("Remove Out of Stock item");
        if(getTextFromAvailabilityColumn().equals("Out Of Stock")); {
            removeButton.click();
        }
        return this;
    }

    public ComparisonPage addItemToCart () {
        logger.debug("Add item to cart");
        if(getTextFromAvailabilityColumn().equals("2-3 Days") && getTextFromProductNameColumn().equals("iPod Nano")); {
            getPriceFromComparisonPage();
            addToCartButton.click();
        }
        return this;
    }

    public boolean checkIfSuccessAlertAppears () {
        successAlertForProductModify.waitUntilVisible();
        return successAlertForProductModify.isPresent();
    }

    public String getTextFromSuccessAlertForRemovingItem() {
        return successAlertForProductModify.getText().split("\n")[0];
    }

    public String getTextFromSuccessAlertForAddingItem() {
        return successAlertForProductModify.getText();
    }

    public CartPage goToCartPage () {
        logger.debug("Go to Cart Page");
        shoppingCart.click();
        return new CartPage(getDriver());
    }
}
