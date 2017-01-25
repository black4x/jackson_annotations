package dto.jsonview;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void serializingUsingJsonView() throws JsonProcessingException {
        Item item = new Item(42, "public", "internal");

        String publicBean = new ObjectMapper().writerWithView(Views.Public.class).writeValueAsString(item);
        String internalBean = new ObjectMapper().writerWithView(Views.Internal.class).writeValueAsString(item);

        // checking public properties
        assertThat(publicBean, containsString("public"));
        assertThat(publicBean, containsString("42"));
        assertThat(publicBean, not(containsString("internal")));

        // checking internal properties
        assertThat(internalBean, containsString("internal"));

    }

}