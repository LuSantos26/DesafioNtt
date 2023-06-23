package Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources",glue = { "Steps"},
monochrome = true,
plugin ={"pretty","junit:target/JUnitReports/reports.html",
		"junit:target/JUnitReports/reports.json",
		"junit:target/JUnitReports/reports.xml"}
,tags="@Pesquisas"
)


public class RunnerTest {

}
