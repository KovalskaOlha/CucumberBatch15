package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
        glue = "StepDefinitions",
        dryRun = false,
        tags = "@database",
        plugin = {"pretty",
                "html:target/Cucumber.html",
                "json:target/Cucumber.json",
                "rerun:target/failed.txt"}
        )
public class SmokeRunner {
}

//tags option will execute the tagged testcase as mentioned in your runner class
// if we want to run 2 cases we can use 'or' to execute
//target folder is mostly used for storing the test case execution reports generated using Cucumber
// we can generate diff types of report
//html report