import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "TestSuites/API",  // Vị trí các tệp .feature
        glue = "StepDefinitions",                  // Vị trí các bước kiểm thử (step definitions)
        tags = "@DeleteObject",
        plugin = {
                "pretty",
                "html:reports/cucumber-report",   //HTML report
        }
)
public class TestRunner {

}
