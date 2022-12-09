import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(  monochrome = true,
        dryRun = false,
        features = "src/test/java/features/",
        glue = "src/test/java/steps/"
//        tags = "@test"
)
public class TestRunner {
}
