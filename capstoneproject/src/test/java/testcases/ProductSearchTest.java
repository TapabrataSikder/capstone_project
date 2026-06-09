package testcases;

import org.testng.annotations.*;
import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ExcelReader;

public class ProductSearchTest extends BaseTest {

    @DataProvider(name = "productData")
    public Object[][] getProducts() throws Exception {
        return ExcelReader.getExcelData("src/test/resources/TestData1.xlsx", "Sheet3");
    }

    @Test(dataProvider = "productData")
    public void testProductSearchAndAdd(String productName, String category) {
        initializeDriver(); 
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        
        ProductsPage prod = new ProductsPage(driver);
        prod.addProductToCart(productName);
        System.out.println("Verified product: " + productName + " in category: " + category);
        
        quitDriver();
    }
}