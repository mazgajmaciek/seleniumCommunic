package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "mainpage")
    private WebElement mainPageBtn;

    public void loadMainPage() {
        mainPageBtn.click();
    }

}