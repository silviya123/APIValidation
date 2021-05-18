package au.com.sbs.api.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feature/sbsAPITesting.feature",
        glue = {"au.com.sbs.api.glue"}
        )

public class ApiTestRunner {
}
