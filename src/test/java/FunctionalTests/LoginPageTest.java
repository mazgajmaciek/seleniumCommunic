package FunctionalTests;

import PageObjects.LoginPage;
import PageObjects.MainPage;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginPageTest extends BaseTest{
    private static LoginPage loginPage;

    private String newUsername = "new_user";
    private String newEmail = "email@address.com";
    private String newPassword = "email@address.com";

    @BeforeClass
    public static void localSetUp() {
        loginPage = new LoginPage(driver);
        driver.get("https://www.maciekmazgaj.com/communic/public/");
    }

    @Test
    public void registerNewUser() {
        loginPage.registerUser();
    }

}
