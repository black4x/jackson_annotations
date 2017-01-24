package dto.jsonvalue;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.jsonvalue.TypeEnum;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TypeEnumTest {

    @Test
    public void whenSerializingUsingJsonValue_thenCorrect() throws IOException {
        String enumAsString = new ObjectMapper().writeValueAsString(TypeEnum.TYPE1);
        assertThat(enumAsString, is("\"Type A\""));
    }
}