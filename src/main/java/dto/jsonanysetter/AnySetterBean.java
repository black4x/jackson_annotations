package dto.jsonanysetter;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class AnySetterBean {

    public String name;
    private Map<String, String> properties = new HashMap<>();

    @JsonAnySetter
    public void add(String key, String value) {
        properties.put(key, value);
    }

    public Map<String, String> getProperties() {
        return properties;
    }
}
