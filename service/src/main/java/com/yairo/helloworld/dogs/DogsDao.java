package com.yairo.helloworld.dogs;

import java.util.Optional;

public interface DogsDao {

    long store(Dog dog);
    Optional<Dog> getById(long dogId);

}
