package ct.com.yairo.helloworld;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = {"ct.com.yairo.helloworld"})
public class CucumberTest {
}
