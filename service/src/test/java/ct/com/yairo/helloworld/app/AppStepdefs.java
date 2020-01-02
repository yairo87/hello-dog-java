package ct.com.yairo.helloworld.app;

import io.cucumber.java.en.Then;
import org.springframework.web.client.RestTemplate;

public class AppStepdefs {

    private RestTemplate restTemplate = new RestTemplate();

    @Then("I get {word} response from healthcheck")
    public void verifyHealthCheck(String status) {
        HealthStatus response = restTemplate.getForEntity("http://localhost:8080/health", HealthStatus.class).getBody();
        assert status.equals(response.getStatus());
    }

    @Then("I get API doc from API")
    public void iGetAPIDocFromAPI() {
        SwaggerDoc swaggerDoc = restTemplate.getForEntity("http://localhost:8080/v2/api-docs", SwaggerDoc.class).getBody();
        assert "2.0".equals(swaggerDoc.getSwagger());
    }
}
