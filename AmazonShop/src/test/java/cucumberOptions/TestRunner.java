package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		glue = "stepDefinations",tags="@PositiveTest or @NegativeTest",dryRun=false,monochrome=true,strict=true,
		plugin= {"pretty","html:target/Report1","json:target/Report2.json","junit:target/Report3.xml"})

public class TestRunner {

}
