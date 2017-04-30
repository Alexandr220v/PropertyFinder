package qa4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alexandr on 22.04.2017.
 */
public class BaseTest {

    public static final String BASE_URL = "https://www.propertyfinder.qa/";
    public WebDriver driver = new FirefoxDriver();



    @BeforeSuite
    public void setUp() {
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    @AfterSuite
    public void close() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
