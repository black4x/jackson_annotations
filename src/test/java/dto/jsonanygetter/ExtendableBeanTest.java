package dto.jsonanygetter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dto.jsonanygetter.ExtendableBean;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class ExtendableBeanTest  {

    @Test
    public void whenSerializingUsingJsonAnyGetter_thenCorrect()
            throws JsonProcessingException {
        ExtendableBean bean = new ExtendableBean("My bean");
        bean.add("attr1", "val1");
        bean.add("attr2", "val2");

        ObjectMapper mapper = new ObjectMapper();
        // for root element
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

        String result = mapper.writeValueAsString(bean);
        assertThat(result, containsString("attr1"));
        assertThat(result, containsString("val1"));
        // test root element presence
        assertThat(result, containsString("BeanName"));
    }
}