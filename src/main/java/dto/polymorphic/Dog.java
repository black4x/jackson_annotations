package dto.polymorphic;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("dog")
public class Dog extends Zoo.Animal{
    public double barkValue;

    public Dog(String name) {
        super(name);
    }

    public Dog() {
    }
}
