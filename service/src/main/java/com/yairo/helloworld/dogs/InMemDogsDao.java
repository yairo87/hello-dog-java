package com.yairo.helloworld.dogs;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
public class InMemDogsDao implements DogsDao {

    private Map<String, Dog> dogsById;

    public InMemDogsDao(){
        this.dogsById = Maps.newHashMap();
    }

    @Override
    public String store(Dog dog) {
        String newId = UUID.randomUUID().toString();
        dog.setId(newId);
        this.dogsById.put(newId, dog);
        return newId;
    }

    @Override
    public Optional<Dog> getById(String dogId) {
        return Optional.ofNullable(this.dogsById.get(dogId));
    }

    @Override
    public void deleteById(String dogId) {
        this.dogsById.remove(dogId);
    }

}
