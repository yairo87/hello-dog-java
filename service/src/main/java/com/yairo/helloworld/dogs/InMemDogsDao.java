package com.yairo.helloworld.dogs;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Component
public class InMemDogsDao implements DogsDao {

    private Map<Long, Dog> dogsById;
    private Random random;

    public InMemDogsDao(){
        this.dogsById = Maps.newHashMap();
        this.random = new Random();
    }

    @Override
    public long store(Dog dog) {
        long newId = this.random.nextLong();
        this.dogsById.put(newId, dog);
        return newId;
    }

    @Override
    public Optional<Dog> getById(long dogId) {
        return Optional.ofNullable(this.dogsById.get(dogId));
    }

    @Override
    public void deleteById(long dogId) {
        this.dogsById.remove(dogId);
    }

}
