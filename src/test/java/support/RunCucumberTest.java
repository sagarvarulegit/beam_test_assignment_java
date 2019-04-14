package support;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        dryRun = true,
        glue = "step_definitions",
        plugin = "pretty",
        features = "src/test/resources",
        tags = "@wip"
)
public class RunCucumberTest {

}
