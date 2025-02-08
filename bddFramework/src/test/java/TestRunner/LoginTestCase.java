package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features = "feautureFiles/login.feature",dryRun = false,
plugin = {"pretty","html:testReports/loginTestCaseReport.html"},glue = "StepDefination")
public class LoginTestCase {
	

}
