package facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by alexandrp on 4/30/2017.
 */
public class FaceBookLoginPage {

    private RemoteWebDriver driver;

    @FindBy(id = "login_username")
    private WebElement login_username;
    @FindBy(id = "login_password")
    private WebElement login_password;
    @FindBy(id = "login_login")
    private WebElement login_login;

    public WebElement inputUserName(String name) {
        login_username.clear();
        login_username.sendKeys(name);
        return login_username;
    }

    public WebElement inputPassword(String pass) {
        login_password.clear();
        login_password.sendKeys(pass);
        return login_password;
    }

    public void pressLoginButton() {
        login_login.click();
    }

    public FaceBookLoginPage(RemoteWebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


}
