package dto.jsonautodetect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class PrivateBeanTest {

    @Test
    public void testAutoVisibility() throws JsonProcessingException {
        PrivateBean privateBean = new PrivateBean(1, "bar");

        String json = new ObjectMapper().writeValueAsString(privateBean);

        assertThat(json, containsString("1"));
        assertThat(json, containsString("bar"));
    }

}