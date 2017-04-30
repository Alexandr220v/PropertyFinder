package facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexandrp on 4/30/2017.
 */
public class ValidationMessagePage {

    private RemoteWebDriver driver;
    @FindBy(id = "message")
    private WebElement errorUserNameMessage;

    public String getErrorMessage() {
        return errorUserNameMessage.getText();
    }

    public ValidationMessagePage(RemoteWebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
