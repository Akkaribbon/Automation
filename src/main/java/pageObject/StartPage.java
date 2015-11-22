package pageObject;

import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Kasia on 2015-11-19.
 */
public class StartPage extends PageObject{

    private final static Logger logger = LoggerFactory.getLogger(StartPage.class);

    public StartPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "currency")
    WebElementFacade chooseCurrency;

    @FindBy(name = "GBP")
    WebElementFacade gbpCurrency;

    @FindBy(name = "search")
    WebElementFacade searchInput;

    @FindBy (id = "compare-total")
    WebElementFacade productComparisonLink;


    public StartPage goToOpenCartStartPage(String url) {
        logger.info("Go to Open Cart start page at {}", url);
        getDriver().get(url);
        return this;
    }

    public StartPage changeCurrencyToGbp() {
        logger.debug("Change currency to GBP");
        chooseCurrency.click();
        gbpCurrency.click();
        return this;
    }

    public StartPage searchForItem(String itemName) {
        logger.debug("Search for iPod");
        enter(itemName).into(searchInput);
        searchInput.sendKeys(Keys.ENTER);
        return this;
    }

    public StartPage selectAllItems() {
        logger.debug("Selecting all items on search list");
        List<WebElement> rows = getDriver().findElements(By.xpath("//button[@data-original-title='Compare this Product']"));
        for (int i = 0; i < rows.size(); i++) {
            rows.get(i).click();
        }
        return this;
    }

    public ComparisonPage clickOnComparisonPageLink () {
        logger.debug("Click on compare product link");
        productComparisonLink.click();
        return new ComparisonPage(getDriver());
    }
}
