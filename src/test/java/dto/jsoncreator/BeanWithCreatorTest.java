package dto.jsoncreator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.jsoncreator.BeanWithCreator;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class BeanWithCreatorTest {

    @Test
    public void whenDeserializingUsingJsonCreator_thenCorrect()
            throws JsonProcessingException, IOException {
        String json = "{\"id\":1,\"theName\":\"My bean\"}";

        BeanWithCreator bean = new ObjectMapper().readerFor(BeanWithCreator.class).readValue(json);
        assertEquals("My bean", bean.name);
    }

}