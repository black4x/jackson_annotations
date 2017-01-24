package dto.jsonanygetter;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonRootName(value = "BeanName")
public class ExtendableBean {
    private String name;
    private Map<String, String> properties = new HashMap<>();

    public ExtendableBean(String name) {
        this.name = name;
    }

    public ExtendableBean() {
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    public void add(String key, String value) {
        properties.put(key, value);
    }

    @JsonGetter("bar")
    public String getName() {
        return name;
    }

    @JsonSetter("name")
    public void setName(String name) {
        this.name = name;
    }
}