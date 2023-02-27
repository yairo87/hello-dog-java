package com.yairo.helloworld.dogs;

import com.yairo.helloworld.metrics.MetricsReporter;
import com.yairo.helloworld.metrics.events.DogCreatedMetricEvent;
import com.yairo.helloworld.metrics.events.DogDeletedMetricEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DogsService {

    private final DogsDao dogsDao;
    private final MetricsReporter metricsReporter;

    @Autowired
    public DogsService(DogsDao dogsDao, MetricsReporter metricsReporter) {
        this.dogsDao = dogsDao;
        this.metricsReporter = metricsReporter;
    }

    public long store(Dog dog){
        long storedDogId = dogsDao.store(dog);
        this.metricsReporter.sendMetricEvent(new DogCreatedMetricEvent(storedDogId, dog.getName()));
        return storedDogId;
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
        this.metricsReporter.sendMetricEvent(new DogDeletedMetricEvent(dogId));
    }
}
