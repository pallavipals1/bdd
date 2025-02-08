package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features = "feautureFiles/BookFlightTestCase.feature",dryRun = true,
plugin = {"pretty","html:testReports/BookFlightTestCaseReport.html"},glue = "StepDefination")
public class BookFlightTestCase {

}

