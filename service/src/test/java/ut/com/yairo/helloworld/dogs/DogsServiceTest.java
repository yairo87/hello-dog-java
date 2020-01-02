package ut.com.yairo.helloworld.dogs;

import com.yairo.helloworld.dogs.Dog;
import com.yairo.helloworld.dogs.DogNotFoundException;
import com.yairo.helloworld.dogs.DogsDao;
import com.yairo.helloworld.dogs.DogsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DogsServiceTest {

    @Mock
    DogsDao dogsDao;

    @InjectMocks
    DogsService dogsService;

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

}