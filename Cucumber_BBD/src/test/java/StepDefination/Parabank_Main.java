package StepDefination;

import io.cucumber.java.en.Given;
import utils.regCSVData;
import base.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Parabank_Main extends base.BaseTest {

	Parabank_POM pom;
	
	@Before
    public void setUp() {
        BaseTest.setupDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }
	
	@Given("registration page should open in default browser")
	public void registration_page_should_open_in_default_browser() {
	    pom = new Parabank_POM(driver);
	    
	}

	@When("register using data from {string}")
	public void register_using_data_from(String filepath) throws Exception{
		Object[][] data = regCSVData.getCSVData(filepath);
		for(Object[] row : data) {
			pom.register(
					(String) row[0],
					(String) row[1], 
		            (String) row[2], 
		            (String) row[3], 
		            (String) row[4], 
		            (String) row[5], 
		            (String) row[6], 
		            (String) row[7], 
		            (String) row[8], 
		            (String) row[9]
		            );
			
		}
		
	}

	@Then("login success to dashboard")
	public void login_success_to_dashboard() {
		System.out.println("Registration process completed successfully.");
	}

	
	
}
