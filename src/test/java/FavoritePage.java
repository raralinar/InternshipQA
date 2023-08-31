import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FavoritePage {

    private final WebDriver driver;

    public FavoritePage (WebDriver driver1) {
        PageFactory.initElements(driver1, this);
        this.driver = driver1;
    }

    @FindBy(xpath = "//button[@data-marker='favorites-rubricator/item-0/selected']")
    private WebElement favoriteProductsCount;

    @FindBy(css = ".styles-module-root-hwVld")
    private WebElement productName;

    @FindBy(css = ".withFavorites-heart-x57Yw.withFavorites-heart_fill-InZcS")
    private WebElement heartFilledBttn;

    public String getProductName() {
        return productName.getText();
    }

    public void clickHeartBttn() {
        heartFilledBttn.click();
    }

    public String productsCount() {
        WebElement productsContainer = driver.findElement(By.xpath("//favorite-items-list"));
        List<WebElement> products = productsContainer.findElements(By.className("item-snippet-root-d2wFO"));
        return Integer.toString(products.size());
    }
}
