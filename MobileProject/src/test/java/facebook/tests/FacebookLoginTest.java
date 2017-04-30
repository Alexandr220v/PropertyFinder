package facebook.tests;

import facebook.pages.FaceBookLoginPage;
import facebook.pages.ValidationMessagePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alexandrp on 4/30/2017.
 */
public class FacebookLoginTest extends FacebookBaseTest {


    @Test (priority = 1)
    public void loginWithIncorrectUserName() {
       FaceBookLoginPage loginPage = new FaceBookLoginPage(driver);
                         loginPage.inputUserName("test_1");
                         loginPage.inputPassword("1234");
                         loginPage.pressLoginButton();
       ValidationMessagePage validationMessagePage = new ValidationMessagePage(driver);
        Assert.assertEquals(validationMessagePage.getErrorMessage(),
                "The username you entered doesn't appear to belong to an account. Please check your username and try again.");
    }

    @Test (priority = 2)
    public void loginWithIncorrectPassword() {
        FaceBookLoginPage loginPage = new FaceBookLoginPage(driver);
                          loginPage.inputUserName("goit@gmail.com");
                          loginPage.inputPassword("1234");
                          loginPage.pressLoginButton();
        ValidationMessagePage validationMessagePage = new ValidationMessagePage(driver);
        Assert.assertEquals(validationMessagePage.getErrorMessage(),
                "The password you entered is incorrect. Please try again.");
    }
}
