package com.yairo.helloworld.dogs;

import java.util.Optional;

public interface DogsDao {

    String store(Dog dog);
    Optional<Dog> getById(String dogId);
    void deleteById(String dogId);
}
