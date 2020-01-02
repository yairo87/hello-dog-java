package ct.com.yairo.helloworld.dogs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog {

    private String name;
    private String owner;

}
