package qa4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Alexandr on 22.04.2017.
 * <p>
 * * User story
 * "As a user I want the list of the least expensive apartment to rent in marina which has at least two bedrooms"
 * <p>
 * -- Additionally open the last item in the result set and verify it has two bedrooms
 * -- Bonus points: Refactor the above script to be data driven?
 */
public class PropertyfinderPage {

    @FindBy
            (xpath = ".//*[@id='search-form-property']/div[3]/div[1]/span/input")
    private WebElement inputState;


    @FindBy
            (xpath = ".//*[@id='search-form-property']/div[3]/div[2]/div/button")
    private WebElement type;

    @FindBy
            (xpath = ".//*[@id='search-form-property']/div[3]//li")
    private List<WebElement> listOfCategories;

    @FindBy
            (xpath = "//span[text()='Property type']")
    private WebElement propertyType;

    @FindBy
            (xpath = ".//*[@id='search-form-property']/div[4]/div/div[1]/div/div/ul/li")
    private List<WebElement> propertyTypeList;

    @FindBy
            (xpath = ".//*[@id='search-form-property']//div[1]//div[text()='Search']")
    private WebElement searchButton;

    @FindBy
            (xpath = ".//*[@id='bedroom_group']//span[text()='Min. bed']")
    private WebElement minBed;

    @FindBy
            (xpath = ".//*[@id='bedroom_group']/div[1]//li")
    private List<WebElement> listofMinBeds;


    public WebElement inputState(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='search-form-property']/div[3]/div[1]/span/input")));
        return inputState;
    }


    public WebElement categoryDropDown() {
        return type;
    }

    public List<WebElement> selectCategory(String type) {
        for (WebElement category : listOfCategories) {
            System.out.println(category.getText());
            if (category.getText().equalsIgnoreCase(type)) {
                category.click();
                break;
            }
        }
        return listOfCategories;
    }

    public WebElement propertyTypeDropDown(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Property type']")));
        return propertyType;
    }

    public List<WebElement> selectPropertyType(WebDriver driver, String propertyType) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.xpath(".//*[@id='search-form-property']/div[4]/div/div[1]/div/div/ul/li")));

        for (WebElement type : propertyTypeList) {
            System.out.println(type.getText());
            if (type.getText().equalsIgnoreCase(propertyType)) {
                type.click();
                break;
            }
        }
        System.out.println(propertyTypeList);
        return propertyTypeList;
    }

    public WebElement pressSearchButton() {
        searchButton.click();
        return searchButton;
    }

    public WebElement minBedDropDown() {
        return minBed;
    }

    public List<WebElement> selectMinBed(String bedsNumber) {
        for (WebElement minbed : listofMinBeds) {
            if (minbed.getText().equalsIgnoreCase(bedsNumber)) {
                minbed.click();
                break;
            }
        }
        return listofMinBeds;
    }

    public PropertyfinderPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed(WebDriver driver) {
        List<WebElement> isCityDisplayed = driver.findElements(By.xpath(".//*[@id='autocomplete-results']/span"));
        if (isCityDisplayed.isEmpty()) {
            return false;
        } else

            return true;
    }

    public void selectStatefromDropDown(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.xpath(".//*[@id='search-form-property']/div[3]/div[1]/span/div/div/div")));
        List<WebElement> states = driver.findElements(By.xpath("//div[@class='tt-suggestion tt-selectable']/strong"));
        for (WebElement w : states) {
            System.out.println(w.getText());
            states.get(0).click();
            break;
        }
    }

    public List<String> getResults (WebDriver driver) {
        List<WebElement> result = driver.findElements(By.xpath(".//*[@id='serp']/ul/li"));


        return result.get(0);
    }
}
