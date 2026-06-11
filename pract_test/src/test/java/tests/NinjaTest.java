package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.RegisterPage;

public class NinjaTest extends base.BaseTest {
	
	RegisterPage ninja;
	
	@BeforeMethod
	public void setUp() {
		ninja=new RegisterPage(driver);	
	}
	
	@DataProvider(name = "getRegisterData")
	public Object[][] regData() throws Exception{
		return utils.ExcelUtil.getCSVData("src/test/resources/data/testdata.csv");
	}
	
	
	@Test(dataProvider = "getRegisterData")
	public void registerTest(String firstName, String lastName, String email, String telephone, String password) {
		ninja.openRegisterPage();
		ninja.registration(firstName, lastName, email, telephone, password);
		System.out.println("Registration successful for: " + email);
	}
	
	
	
}
