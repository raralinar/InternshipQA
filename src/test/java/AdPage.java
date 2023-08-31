import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdPage {
    private final WebDriver driver;

    public AdPage(WebDriver driver1) {
        PageFactory.initElements(driver1, this);
        this.driver = driver1;
    }

    @FindBy(xpath = "//button[@class='desktop-usq1f1']")
    private WebElement addToFavoriteButton;

    public void clickBttn() {
        addToFavoriteButton.click();
    }


}
