package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "StepDefination", // Ensure the package contains the Hooks class
        plugin = {
                "pretty",

        },
        monochrome = true
)
public class CucumberTestRunner {
}
