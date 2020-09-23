package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GoogleSearchPage extends BaseClass {
    public GoogleSearchPage() {
        super();
    }

    public void search(String search, String expected) {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(search);
        element.submit();
        WebElement newElement = driver.findElement(By.cssSelector("h2[class=\"qrShPb kno-ecr-pt PZPZlf mfMhoc\"]>span"));
        String actual = newElement.getText();
        Assert.assertEquals(actual, expected );
    }
}
