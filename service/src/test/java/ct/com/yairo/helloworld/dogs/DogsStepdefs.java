package ct.com.yairo.helloworld.dogs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class DogsStepdefs {

    private RestTemplate restTemplate = new RestTemplate();
    private Dog dog;
    private Long dogId;

    @Given("I create a dog named {word} owned by {word}")
    public void createNewDog(String dogName, String dogOwner) {
        this.dog = new Dog(dogName, dogOwner);
    }

    @When("I store the dog")
    public void postNewDog(){
        ResponseEntity<Long> response = restTemplate.postForEntity("http://localhost:8080/v1/dogs", this.dog, Long.class);
        this.dogId = response.getBody();
        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Then("I can get the Dog with the id I got from POST and verify it's the same dog")
    public void getDogAndVerify() {
        Dog dogFromService = restTemplate.getForEntity("http://localhost:8080/v1/dogs/" + this.dogId, Dog.class).getBody();
        assertEquals(dog, dogFromService);
    }

    @And("I delete the dog")
    public void iDeleteTheDog() {
        restTemplate.delete("http://localhost:8080/v1/dogs/" + this.dogId);
    }

    @Then("I won't be able to get the Dog with the id I got from POST")
    public void iWonTBeAbleToGetTheDogWithTheIdIGotFromPOST() {
        try{
            restTemplate.getForEntity("http://localhost:8080/v1/dogs/" + this.dogId, Dog.class);
            fail();
        } catch (HttpClientErrorException.NotFound error){
            //expected
        }
    }
}
