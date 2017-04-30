package qa4;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Alexandr on 22.04.2017.
 * <p>
 * User story
 * "As a user I want the list of the least expensive apartment to rent in marina which has at least two bedrooms"
 * <p>
 * -- Additionally open the last item in the result set and verify it has two bedrooms
 * -- Bonus points: Refactor the above script to be data driven?
 */
public class PropertyfinderTest extends BaseTest {


    @Test
    public void verifyTheLeastExpensiveApartmentsIsDisplayed() throws InterruptedException {
        PropertyfinderPage propertyfinderPage = new PropertyfinderPage(driver);
        propertyfinderPage.categoryDropDown().click();
        propertyfinderPage.selectCategory("Rent");
        propertyfinderPage.inputState(driver).sendKeys("marine");
        propertyfinderPage.selectStatefromDropDown(driver);
       // propertyfinderPage.isDisplayed(driver);
        propertyfinderPage.propertyTypeDropDown(driver).click();
        propertyfinderPage.selectPropertyType(driver,"Apartment");
        propertyfinderPage.minBedDropDown().click();
        propertyfinderPage.selectMinBed("2 Beds");
        propertyfinderPage.pressSearchButton();
        Thread.sleep(5000);
        List<String> actual = propertyfinderPage.getResults(driver);
        Assert.assertEquals(propertyfinderPage.getResults(driver), );

    }
}
