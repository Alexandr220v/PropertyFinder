package qa.propertyfinder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by olepa on 4/28/2017.
 */
public class ResultsRentPage {

    private final WebDriver driver;

    @FindBy(xpath = "//li[contains(@data-properties,'referenceNumber')]//span[@class='val']")
    private List<WebElement> prices;
    @FindBy(xpath = "//li[contains(@data-properties,'referenceNumber')]//div[@class='property-details']//span[2]")
    private List<WebElement> bedsNumber;

    public boolean isPricesSorted() {
         return isSortedByPrice(prices);
    }

    public int getBedsNumber() {
        return Integer.parseInt(bedsNumber.get(0).getText());
    }

    public <T extends Comparable> boolean isSortedByPrice(List<WebElement> prices) {
        WebElement previous = null;
        for (WebElement price : prices) {
            double current = Double.parseDouble(price.getText().replace(",","."));
            if (previous != null) {
                double prevNumber = Double.parseDouble(previous.getText().replace(",","."));
                if (current<prevNumber) {
                    return false;
                }
            }
            previous = price;
        }
        return true;
    }

     public ResultsRentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
