package com.yairo.helloworld.dogs;

import com.yairo.helloworld.config.ServiceConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/dogs")
public class DogsController {

    DogsService dogsService;
    ServiceConfiguration config;

    @Autowired
    public DogsController(DogsService dogsService, ServiceConfiguration config) {
        this.dogsService = dogsService;
        this.config = config;
    }

    @PostMapping
    public ResponseEntity<Long> createDog(@RequestBody Dog dog) {
        log.info(config.getServiceOwner() + "! adding new dog {}", dog);
        return ResponseEntity.status(HttpStatus.CREATED).body(dogsService.store(dog));
    }

    @GetMapping("/{dogId}")
    public Dog getDog(@PathVariable long dogId) {
        log.info("fetching dog with ID {}", dogId);
        return dogsService.getDog(dogId);
    }

    @DeleteMapping("/{dogId}")
    public void deleteDog(@PathVariable long dogId) {
        log.info("deleting dog with ID {}", dogId);
        dogsService.deleteById(dogId);
    }

    @ExceptionHandler(DogNotFoundException.class)
    public ResponseEntity<Dog> dogNotFound(){
        return ResponseEntity.notFound().build();
    }

}
