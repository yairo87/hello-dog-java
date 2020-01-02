package ct.com.yairo.helloworld.dogs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class DogsStepdefs {

    private RestTemplate restTemplate = new RestTemplate();
    private Dog dog;

    @Given("I create a dog named {word} owned by {word}")
    public void createNewDog(String dogName, String dogOwner) {
        this.dog = new Dog(dogName, dogOwner);
    }

    @When("I store the dog")
    public void postNewDog(){
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/v1/dogs", this.dog, String.class);
        assert response.getStatusCode() == HttpStatus.CREATED;
    }

    @Then("I can get Dog with Id {long} and verify it's the same dog")
    public void getDogAndVerify(long id) {
        Dog dogFromService = restTemplate.getForEntity("http://localhost:8080/v1/dogs/" + id, Dog.class).getBody();
        assert dog.equals(dogFromService);
    }

}
