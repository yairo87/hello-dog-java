package ut.com.yairo.helloworld.dogs;

import com.yairo.helloworld.dogs.Dog;
import com.yairo.helloworld.dogs.DogNotFoundException;
import com.yairo.helloworld.dogs.DogsDao;
import com.yairo.helloworld.dogs.DogsService;
import com.yairo.helloworld.metrics.MetricsReporter;
import com.yairo.helloworld.metrics.events.DogCreatedMetricEvent;
import com.yairo.helloworld.metrics.events.DogDeletedMetricEvent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DogsServiceTest {

    @Mock DogsDao dogsDao;
    @Mock MetricsReporter metricsReporter;

    @InjectMocks DogsService dogsService;

    @Test(expected = DogNotFoundException.class)
    public void shouldThrowAnExceptionOnWrongId(){
        when(dogsDao.getById(-1L)).thenReturn(Optional.empty());
        dogsService.getDog(-1L);
    }

    @Test
    public void shouldBeAbleToGetDog(){
        Dog dog = new Dog();
        when(dogsDao.getById(1L)).thenReturn(Optional.of(dog));
        Assert.assertEquals(dog, dogsService.getDog(1L));
    }

    @Test
    public void shouldStoreNewDog(){
        Dog dog = new Dog("Spike", "John");

        long dogId = dogsService.store(dog);

        Mockito.verify(metricsReporter).sendMetricEvent(new DogCreatedMetricEvent(dogId, "Spike"));
    }

    @Test
    public void shouldDeleteDog(){
        Dog dog = new Dog("Spike", "John");
        long dogId = dogsService.store(dog);
        Mockito.reset(metricsReporter);

        dogsService.deleteById(dogId);

        Mockito.verify(metricsReporter).sendMetricEvent(new DogDeletedMetricEvent(dogId));
    }

}