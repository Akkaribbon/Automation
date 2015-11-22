package pageObject;

import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Kasia on 2015-11-19.
 */
public class CartPage extends PageObject{

    private final static Logger logger = LoggerFactory.getLogger(CartPage.class);

    public CartPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[1]/td[6]")
    WebElementFacade price;

    @FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[1]/td[2]")
    WebElementFacade productName;



    public String getPriceFromCartPage() {
        return price.getText();
    }

    public String getProductNameFromCartPage () {
        return productName.getText();
    }

    public CartPage priceFromCartPage () {
        if(getProductNameFromCartPage().equals("iPod Nano")) {
            getPriceFromCartPage();
        }
        return this;
    }

}
