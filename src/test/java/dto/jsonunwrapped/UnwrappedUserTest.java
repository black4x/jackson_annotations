package dto.jsonunwrapped;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class UnwrappedUserTest {

    @Test
    public void serializingUsingUnwrap() throws JsonProcessingException {
        UnwrappedUser.Name name = new UnwrappedUser.Name("A", "B");
        UnwrappedUser unwrappedUser = new UnwrappedUser();
        unwrappedUser.name = name;

        String result = new ObjectMapper().writeValueAsString(unwrappedUser);

        System.out.println(result);
        assertThat(result, containsString("A"));
        assertThat(result, not(containsString("name")));

    }

}