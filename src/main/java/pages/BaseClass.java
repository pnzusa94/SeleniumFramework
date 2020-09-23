package pages;
import org.openqa.selenium.WebDriver;
import util.DriverUtils;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseClass {
    protected WebDriver driver;
    private Properties properties = getProperties();

    public BaseClass() {
        try {
            String baseURL = properties.getProperty("baseURL");
            String browser = properties.getProperty("defaultBrowser");
            driver = DriverUtils.getDriver(driver, browser, baseURL);

            int implicitWaitTimeout = Integer.parseInt(properties.getProperty("implicitWaitTimeout"));
            driver.manage().timeouts().implicitlyWait(implicitWaitTimeout, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/env-qa.properties"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return properties;
    }
}
