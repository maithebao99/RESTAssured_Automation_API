import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "TestSuites/API",  // Vị trí các tệp .feature
        glue = "StepDefinitions",                  // Vị trí các bước kiểm thử (step definitions)
        tags = "@RegressionTest",
        plugin = {
                    "pretty",
                    "html:target/cucumber-reports",
                    "json:target/cucumber.json",
        } // Các plugin để tạo báo cáo

)
public class TestRunner {
    // Test Runner này sẽ tự động tìm kiếm các kịch bản trong thư mục "features" và ánh xạ chúng tới các phương thức trong "StepDefinitions".
}
