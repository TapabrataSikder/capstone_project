package StepDefination;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
		features = "src/test/resources/features/parabank.feature",
		glue= {"StepDefination"},
		plugin = {
				"pretty", "html:target/htmlreports/Parabank_report.html"
		}
		)


public class RunnerTest extends AbstractTestNGCucumberTests {

}
