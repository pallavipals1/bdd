package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features = "feautureFiles/SearchAndSelectFlight.feature", dryRun = false, 
plugin = {"pretty","html:testReports/SearchAndSelectFlightTestCaseReport.html"}, glue = "StepDefination")
public class SearchAndSelectFlight {

}
