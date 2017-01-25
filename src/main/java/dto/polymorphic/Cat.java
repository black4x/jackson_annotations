package dto.polymorphic;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("cat")
public class Cat extends Zoo.Animal{
    public boolean likesCream;
    public int lives;
}
