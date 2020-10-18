package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {
    protected static WebDriver driver;

    public Page(WebDriver driver) {
        setWebDriver(driver);
    }

    public void setWebDriver(WebDriver driver) {
        Page.driver = driver;
        //TODO - initElements is not enough for catching elements on websites with JS
        //TODO - when initElements commented, it will throw NullPointerException since @FindBy elements in Page Object are using it
        PageFactory.initElements(driver, this);
    }
}