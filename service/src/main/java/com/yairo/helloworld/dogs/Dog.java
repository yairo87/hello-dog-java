package com.yairo.helloworld.dogs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog {
    public Dog(String name, String owner){
        this.name = name;
        this.owner = owner;
    }
    private String id;
    private String name;
    private String owner;

}
