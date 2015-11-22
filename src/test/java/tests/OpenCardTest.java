package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Kasia on 2015-11-19.
 */
public class OpenCardTest extends BaseTest{


    private final static Logger logger = LoggerFactory.getLogger(OpenCardTest.class);


    @Test
    public void shoppingCardTest () {
        startPage
                .changeCurrecnyToGbp()
                .changeCurrecnyToGbp()
                .searchForItem("iPod")
                .selectAllItems()
                .clickOnComparisonPageLink()
                .removeOutOfStockItem();
        Assert.assertTrue(comparisonPage.checkIfSuccessAlertAppears(),
                "Comparison page wasn't changed/ item was not removed or added to cart");
        Assert.assertEquals(comparisonPage.getTextFromSuccessAlertForRemovingItem(),
                "Success: You have modified your product comparison!",
                "Incorrect text on success alert after removing item");
        comparisonPage
                .addItemToCart();
        Assert.assertTrue(comparisonPage.checkIfSuccessAlertAppears(),
                "Comparison page wasn't changed/ item was not removed or added to cart");
        logger.info(comparisonPage.getTextFromSuccessAlertForAddingItem());
//        Assert.assertTrue(comparisonPage.getTextFromSuccessAlertForAddingItem().startsWith("Success: You have added"),
//                "Incorrect text on success alert after adding item");
        comparisonPage
                .goToCartPage();
        Assert.assertEquals(comparisonPage.getPriceFromComparisonPage(),cartPage.getPriceFromCartPage(),
                "Prices doesn't match");
    }

}
