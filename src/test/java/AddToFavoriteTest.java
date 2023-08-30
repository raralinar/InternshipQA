import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AddToFavoriteTest {
    private static WebDriver driver;
    public static AdPage adPage;
    public static FavoritePage favoritePage;


    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.get(ConfProperties.getProperty("ad"));
        adPage = new AdPage(driver);
        favoritePage = new FavoritePage(driver);
    }

    @Test
    public void testAddToFavorite() {
        adPage.clickBttn();
        driver.get(ConfProperties.getProperty("favorite"));
        Assert.assertEquals(favoritePage.getCount(), "1");
        Assert.assertEquals(favoritePage.getProductName(),
                ConfProperties.getProperty("productName"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
