package dto.jsonanysetter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnySetterBeanTest {
    @Test
    public void add() throws Exception {

        String json = "{\"name\":\"My bean\",\"attr1\":\"val1\",\"attr2\":\"val2\"}";
        AnySetterBean bean = new ObjectMapper().readerFor(AnySetterBean.class).readValue(json);

        assertEquals("My bean", bean.name);

        assertEquals("val2", bean.getProperties().get("attr2"));

        System.out.println(bean);
    }

}