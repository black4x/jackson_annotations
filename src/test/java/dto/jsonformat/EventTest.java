package dto.jsonformat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class EventTest {

    @Test
    public void testDateFormat() throws JsonProcessingException, ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        String toParse = "25-12-2017 12:00:00";

        Event event = new Event();
        event.eventDate = simpleDateFormat.parse(toParse);
        String json = new ObjectMapper().writeValueAsString(event);
        assertThat(json, containsString(toParse));
    }

}