package dto.jacksoninject;

import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class BeanWithInjectTest {

    @Test
    public void whenDeserializingUsingJsonInject_thenCorrect() throws IOException {
        String json = "{\"name\":\"My bean\"}";
        InjectableValues inject = new InjectableValues.Std().addValue(int.class, 1);
        BeanWithInject bean = new ObjectMapper().reader(inject)
                .forType(BeanWithInject.class)
                .readValue(json);

        assertEquals("My bean", bean.name);
        assertEquals(1, bean.id);
    }
}