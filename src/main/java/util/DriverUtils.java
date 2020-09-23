package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class DriverUtils {
    private static Properties properties;
    private static final String DRIVER_PROP_FILE = "src/main/resources/driver.properties";

    public static WebDriver getDriver(WebDriver driver, String browser, String baseURL) throws Exception, FileNotFoundException {
        properties = new Properties();
        properties.load(new FileInputStream(DRIVER_PROP_FILE));
        if (isWindows()) {
            if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                options.setCapability(CapabilityType.BROWSER_VERSION, 48);

                System.setProperty("webdriver.gecko.driver", properties.getProperty(Constants.FIREFOX_DRIVER_WIN));
                driver = new FirefoxDriver();
            }
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", properties.getProperty(Constants.CHROME_DRIVER_WIN));
                driver = new ChromeDriver();
            }
        } else if (isMac()) {
            if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                options.setCapability(CapabilityType.BROWSER_VERSION, 48);

                System.setProperty("webdriver.gecko.driver", properties.getProperty(Constants.FIREFOX_DRIVER_MAC));
                driver = new FirefoxDriver();
            }
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", properties.getProperty(Constants.CHROME_DRIVER_MAC));
                driver = new ChromeDriver();
            }
        }
        driver.get(baseURL);
        driver.manage().window().maximize();
        return driver;
    }

    private static boolean isWindows() {
        String os = System.getProperty("os.name");
        return os.startsWith("Windows");
    }

    private static boolean isMac() {
        String os = System.getProperty("os.name");
        return os.startsWith("Mac");
    }
}