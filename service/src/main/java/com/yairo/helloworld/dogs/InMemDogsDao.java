package com.yairo.helloworld.dogs;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InMemDogsDao implements DogsDao {

    private Dog dog;

    @Override
    public long store(Dog dog) {
        this.dog = dog;
        return 1L;
    }

    @Override
    public Optional<Dog> getById(long dogId) {
        return Optional.ofNullable(dogId == 1L ? this.dog : null);
    }

}
