package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page {
    private static String username = "usernameTest";
    private static String email = "email@test.com";
    private static String password = "passwordTest";
    @FindBy(xpath = "//form[@class='form-register']/button")
    private WebElement registerBtn;
    @FindBy(id = "username")
    private WebElement usernameBox;
    @FindBy(id = "email")
    private WebElement emailBox;
    @FindBy(id = "password")
    private WebElement passwordBox;
    @FindBy(xpath = "//div[@id='modalRegister']//button[contains(.,'Send')]")
    private WebElement registerFormSendBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //https://stackoverflow.com/questions/33348600/selenium-wait-for-ajax-content-to-load-universal-approach
    public boolean waitForJSandJQueryToLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            try {
                return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
            } catch (Exception e) {
                // no jQuery present
                return true;
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .toString().equals("complete");

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    public MainPage registerUser() {
        registerBtn.click();
        waitForJSandJQueryToLoad();
        usernameBox.clear();
        usernameBox.sendKeys(username);
        emailBox.clear();
        emailBox.sendKeys(email);
        passwordBox.clear();
        passwordBox.sendKeys(password);
        registerFormSendBtn.click();
        return new MainPage(driver);
    }

}
