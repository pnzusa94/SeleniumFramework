import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;

public class GoogleSearchPageTest {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Test
    public void search() {
        googleSearchPage.search("Selenium","Selenium");
    }
}
