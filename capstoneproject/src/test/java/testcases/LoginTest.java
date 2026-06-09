package testcases;

import org.testng.annotations.*;
import base.BaseClass;
import pages.LoginPage;
import utils.ExcelReader;

public class LoginTest extends BaseClass {
	
	@DataProvider(name = "loginData")
    public Object[][] getData() throws Exception {
        return ExcelReader.getExcelData("src/test/resources/TestData1.xlsx", "Sheet1");
    }

    @BeforeMethod
    public void setup() {
        initializeDriver();
    }

    @Test(dataProvider = "loginData")
    public void verifyValidLogin(String user, String pass) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user, pass);
        
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}