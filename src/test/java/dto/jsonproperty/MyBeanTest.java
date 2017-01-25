package dto.jsonproperty;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class MyBeanTest {

    @Test
    public void whenUsingJsonProperty_thenCorrect()
            throws IOException {
        MyBean bean = new MyBean(1, "My bean");
        String result = new ObjectMapper().writeValueAsString(bean);
        assertThat(result, containsString("My bean"));
        assertThat(result, containsString("1"));

        MyBean resultBean = new ObjectMapper().readerFor(MyBean.class).readValue(result);
        assertEquals("My bean", resultBean.getTheName());
        assertEquals(1, resultBean.id);
    }
}