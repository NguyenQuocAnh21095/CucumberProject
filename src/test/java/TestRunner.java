//https://cucumber.io/docs/cucumber/api/?lang=java#running-cucumber

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/features",
        glue = "steps",
        plugin = {"pretty","json:target/junit-cucumber-reports/cucumber.json",
                "junit:target/junit-cucumber-reports/cucumberReport.xml",
                "html:target/junit-cucumber-reports/cucumberReport.html"},
        tags = "@playlists or @test2"
)

//Supported properties are:
//
//        cucumber.ansi-colors.disabled=  # true or false. default: false
//        cucumber.execution.dry-run=     # true or false. default: false
//        cucumber.execution.limit=       # number of scenarios to execute (CLI only).
//        cucumber.execution.order=       # lexical, reverse, random or random:[seed] (CLI only). default: lexical
//        cucumber.execution.wip=         # true or false. default: false.
//        cucumber.features=              # comma separated paths to feature files. example: path/to/example.feature, path/to/other.feature
//        cucumber.filter.name=           # regex. example: .*Hello.*
//        cucumber.filter.tags=           # tag expression. example: @smoke and not @slow
//        cucumber.glue=                  # comma separated package names. example: com.example.glue
//        cucumber.plugin=                # comma separated plugin strings. example: pretty, json:path/to/report.json
//        cucumber.object-factory=        # object factory class name. example: com.example.MyObjectFactory
//        cucumber.snippet-type=          # underscore or camelcase. default: underscore

public class TestRunner {
}
