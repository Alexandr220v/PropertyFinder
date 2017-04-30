package qa.propertyfinder.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alexandr on 30.04.2017.
 */
public class BaseTest {

    private static final String BASE_URL = "https://www.propertyfinder.qa/";
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
    }

    @AfterMethod
    public void close() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
