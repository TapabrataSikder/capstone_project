package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.NinjaPage;

public class NinjaTest extends base.BaseTest {

	NinjaPage ninja;
	
	@BeforeMethod
	public void setUp() {
		ninja=new NinjaPage(driver);
	}
	
	@DataProvider(name="regData")
	public Object[][] getData() throws Exception{
		String path=System.getProperty("user.dir")+"/src/test/resources/NinjaData.csv";
		return utils.ExcelUtil.getRegData(path);
	}

	@Test(dataProvider="regData", priority=1)
	public void testRegister(String firstName, String lastName, String mail, String telephone, String password, String cnfpwd) throws InterruptedException {
		ninja.openRegister();
		ninja.registration(firstName, lastName, mail, telephone, password, cnfpwd);
		System.out.println("Registering: " + firstName + " " + mail);
	}

}
