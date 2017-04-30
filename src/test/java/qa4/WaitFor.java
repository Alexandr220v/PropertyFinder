package qa4;

import org.apache.xpath.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by olepa on 4/25/2017.
 */
public class WaitFor {


    public void waitForPresenceOfElementLocated(WebDriver driver, By xPath) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath(xPath.toString())));

    }

    public boolean isClickable(WebDriver driver, By xPath) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.
                elementToBeClickable(By.xpath(xPath.toString())));
        return true;
    }

    public void WaitForAjax(WebDriver driver) throws InterruptedException
    {

        while (true)
        {

            Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor)driver).executeScript("return jQuery.active == 0");
            if (ajaxIsComplete){
                break;
            }
            Thread.sleep(100);
        }
    }

}

