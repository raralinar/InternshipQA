import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class AddToFavoriteTest {
    private static WebDriver driver;
    public static AdPage adPage;
    public static FavoritePage favoritePage;


    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("ad"));
        adPage = new AdPage(driver);
        favoritePage = new FavoritePage(driver);
    }

    @Test
    public void testAddToFavorite() {
        adPage.clickBttn();
        driver.get(ConfProperties.getProperty("favorite"));
        Assert.assertEquals(favoritePage.productsCount(), "1");
        Assert.assertEquals(favoritePage.getProductName(),
                ConfProperties.getProperty("productName"));
    }

    @Test
    public void testDeleteFromFavorite() {
        favoritePage.clickHeartBttn();
        driver.get(ConfProperties.getProperty("favorite"));
        Assert.assertEquals("0", favoritePage.productsCount());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
