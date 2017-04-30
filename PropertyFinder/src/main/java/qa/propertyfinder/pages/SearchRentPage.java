package qa.propertyfinder.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by alexandrp on 4/30/2017.
 * <p>
 * * User story
 * "As a user I want the list of the least expensive apartment to rent in marina which has at least two bedrooms"
 * <p>
 * -- Additionally open the last item in the result set and verify it has two bedrooms
 * -- Bonus points: Refactor the above script to be data driven?
 */
public class SearchRentPage {

    private final WebDriver driver;

    @FindBy(xpath = "//*[@id='search-form-property']//span[text()='Rent']")
    private WebElement categoryType;
    @FindBy(xpath = "//input[@placeholder='City or Community or Tower']")
    private WebElement inputState;
    @FindBy(xpath = "//*[@id='search-form-property']//span[text()='Property type']")
    private WebElement propertyType;
    @FindBy(xpath = "//*[@id='bedroom_group']//span[text()='Min. bed']")
    private WebElement minBed;
    @FindBy(xpath = "//button//div[text()='Search']")
    private WebElement searchButton;
    @FindBy(xpath = "//*[@id='serp-nav']//span[text()='Featured']")
    private WebElement sortBy;

    public void selectCategotyFromDropDown(String category) {
        selectFromCombobox(categoryType, category);
    }

    public void selectState(String str)  {
        inputState.sendKeys(str);
        List<WebElement> statelist = driver.findElements(By.xpath("//strong[contains(text(),'"+str+"')]"));
        statelist.get(0).click();
    }

    public void selectPropertyTypeFromDropDown(String type) {
        selectFromCombobox(propertyType, type);
    }

    public void selectMinBedsFromDropDown(String bedNumber) {
        selectFromCombobox(minBed, bedNumber);
    }

    private void selectFromCombobox(WebElement element, String str) {
        element.click();
        driver.findElement(By.xpath("//li[text()='" + str + "']")).click();
    }

    public void pressSearchButton() {
        searchButton.click();
    }

    public void selectSortBy(String sortType) {
       selectFromCombobox(sortBy,sortType);
    }

    public SearchRentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
