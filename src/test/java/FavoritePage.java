import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FavoritePage {

    private WebDriver driver;

    public FavoritePage (WebDriver driver1) {
        PageFactory.initElements(driver, this);
        this.driver = driver1;
    }

    @FindBy(xpath = "//button[@data-marker='favorites-rubricator/item-0/selected']")
    private WebElement favoriteProductsCount;

    @FindBy(css = ".styles-module-root-hwVld")
    private WebElement productName;

    public String getCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-marker='favorites-rubricator/item-0/selected']")));
        return favoriteProductsCount.getText().substring(3);
    }

    public String getProductName() {
        return productName.getText();
    }
}
