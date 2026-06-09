package testcases;

import org.testng.Assert;
import org.testng.annotations.*;
import base.BaseTest;
import pages.LoginPage;
import utils.ExcelReader;

public class LoginTest extends BaseTest {
	
	@DataProvider(name = "validUsers")
	public Object[][] getValidData() throws Exception {
	    return ExcelReader.getExcelData("src/test/resources/TestData1.xlsx", "Sheet1");
	}
	
	@DataProvider(name = "invalidUsers")
	public Object[][] getInvalidData() throws Exception {
	    return ExcelReader.getExcelData("src/test/resources/TestData1.xlsx", "Sheet2");
	}

    @BeforeMethod
    public void setup() {
        initializeDriver();
    }

    @Test(priority=1, dataProvider = "validUsers")
    public void verifyValidLogin(String user, String pass) {

        if (user == null || user.trim().isEmpty()) {
            throw new org.testng.SkipException("Skipping empty test data row.");
        }
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user, pass);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(priority=2, dataProvider = "invalidUsers")
    public void testInvalidLogin(String user, String pass) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user, pass);
        String actualError = loginPage.getErrorMessage();
        Assert.assertTrue(actualError.contains("Epic sadface"));
    }
    
    
    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}