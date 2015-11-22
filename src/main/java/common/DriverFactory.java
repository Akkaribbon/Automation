package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.log4testng.Logger;

import java.io.File;

/**
 * Created by Kasia on 2015-11-19.
 */
public class DriverFactory {

    private static final Logger logger = Logger.getLogger(DriverFactory.class);

    public static WebDriver getDriver() {
        FirefoxProfile profile = new FirefoxProfile();
        try {
            profile.addExtension(new File("extensions/firebug.xpi"));
            profile.setPreference("extensions.firebug.currentVersion", "2.0.8");
            return new FirefoxDriver(profile);

        } catch (Exception e) {
            logger.error("Error Loading Firebug Extension, trying to run without", e);
            return new FirefoxDriver();
        }
    }
}
