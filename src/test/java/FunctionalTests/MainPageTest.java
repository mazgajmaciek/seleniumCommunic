package FunctionalTests;

import PageObjects.MainPage;
import PageObjects.Page;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class MainPageTest extends BaseTest {
    private static MainPage mainPage;

//    public MainPageTest(WebDriver driver) {
//        super(driver);
//    }

//    @BeforeClass
//    public static void localSetUp() {
//        mainPage = new MainPage(driver);
//        driver.get("https://www.maciekmazgaj.com/communic/public/admin/pages/index.php");
//    }

    @Test
    public void loadMainPage() {
        mainPage.loadMainPage();
//        return new MainPage(driver);
    }
}
