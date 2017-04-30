package qa.propertyfinder.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.propertyfinder.pages.ResultsRentPage;
import qa.propertyfinder.pages.SearchRentPage;

/**
 * Created by Alexandr on 30.04.2017.
 * <p>
 * User story
 * "As a user I want the list of the least expensive apartment to rent in marina which has at least two bedrooms"
 * <p>
 * -- Additionally open the last item in the result set and verify it has two bedrooms
 * -- Bonus points: Refactor the above script to be data driven?
 */
public class SearchRentTest extends BaseTest {

    @Test (priority = 1, dataProviderClass = SearchRentDataProvider.class, dataProvider = "SearchRentApartment")
    public void verifyTheLeastExpensiveApartmentsIsDisplayed(String type, String state, String propertyType, String bedNum,
                                                             String sortType, int bedNumExp) {
        SearchRentPage searchRentPage = new SearchRentPage(driver);
        ResultsRentPage resultsRentPage = new ResultsRentPage(driver);
                       searchRentPage.selectCategotyFromDropDown(type);
                       searchRentPage.selectState(state);
                       searchRentPage.selectPropertyTypeFromDropDown(propertyType);
                       searchRentPage.selectMinBedsFromDropDown(bedNum);
                       searchRentPage.pressSearchButton();
                       searchRentPage.selectSortBy(sortType);
        Assert.assertTrue(resultsRentPage.isPricesSorted(),
                                         "Prices is sorted from least to more expensive");
        Assert.assertEquals(resultsRentPage.getBedsNumber(),bedNumExp,"Room has "+bedNumExp+" rooms" );

    }


}
