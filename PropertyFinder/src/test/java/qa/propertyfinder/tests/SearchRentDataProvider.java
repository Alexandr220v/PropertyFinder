package qa.propertyfinder.tests;

import org.testng.annotations.DataProvider;

/**
 * Created by olepa on 4/30/2017.
 */
public class SearchRentDataProvider {

    @DataProvider (name = "SearchRentApartment")
    public static Object [][] searchRentApartment() {
        return new Object[][] {
                {"Rent","Marina Gate","Apartment","2 Beds","Price (low)",2},
                {"Rent","Marina Gate","Apartment","1 Bed","Price (low)",1},
                {"Rent","Doha","Apartment","3 Beds","Price (low)",3},
                {"Rent","Doha","Apartment","2 Beds","Price (low)",2},
        };
    }
}
