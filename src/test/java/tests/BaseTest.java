package tests;

import common.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageObject.CartPage;
import pageObject.ComparisonPage;
import pageObject.StartPage;

/**
 * Created by Kasia on 2015-11-19.
 */
public class BaseTest {

    private WebDriver driver;

    private final static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    StartPage startPage;
    ComparisonPage comparisonPage;
    CartPage cartPage;


    @BeforeTest
    public void setup( ) {
        logger.info("------- Starting Tests -------");
        driver = DriverFactory.getDriver();
        startPage = new StartPage(driver);
        comparisonPage = new ComparisonPage(driver);
        cartPage = new CartPage(driver);

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void openStartPage () {
        startPage
            .goToOpenCartStartPage("http://demo.opencart.com/");
    }

    @AfterClass
    public void tearDown () {
       driver.quit();
    }

}
