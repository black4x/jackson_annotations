package dto.polymorphic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ZooTest {

    @Test
    public void serializingPolymorphicBean() throws JsonProcessingException {
        Dog dog = new Dog("bar");
        Zoo zoo = new Zoo(dog);

        String result = new ObjectMapper().writeValueAsString(zoo);

        assertThat(result, containsString("type"));
        assertThat(result, containsString("dog"));
        assertThat(result, containsString("bar"));
    }

    @Test
    public void deserializingPolymorphicBean() throws IOException {
        String json = "{\"animal\":{\"type\":\"cat\", \"name\":\"foo\", \"lives\":42}}";
        Zoo zoo = new ObjectMapper().reader().forType(Zoo.class).readValue(json);
        assertThat("foo", is(zoo.animal.name));
        assertEquals(Cat.class, zoo.animal.getClass());
        assertThat(42, is(((Cat)zoo.animal).lives));
    }

}