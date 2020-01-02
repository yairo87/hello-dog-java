package com.yairo.helloworld.dogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DogsService {

    DogsDao dogsDao;

    @Autowired
    public DogsService(DogsDao dogsDao) {
        this.dogsDao = dogsDao;
    }

    public long store(Dog dog){
        return dogsDao.store(dog);
    }

    public Dog getDog(long dogId) {
        Optional<Dog> dog = this.dogsDao.getById(dogId);
        if (dog.isEmpty()){
            throw new DogNotFoundException();
        }
        return dog.get();
    }

    public void deleteById(long dogId) {
        this.dogsDao.deleteById(dogId);
    }
}
