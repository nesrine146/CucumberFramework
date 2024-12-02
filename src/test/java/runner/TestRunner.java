package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
                 glue={"stepDefinitions","hooks"},
                 tags = "not @ignore",
                 publish=true,
                 plugin={"pretty","html:target/CucumberReports/cucumberReport.html"})
public class TestRunner {

}
