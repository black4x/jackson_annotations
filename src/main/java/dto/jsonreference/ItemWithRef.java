package dto.jsonreference;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class ItemWithRef {
    public int id;
    public String name;

    @JsonManagedReference
    public UserWithRef owner;

    public ItemWithRef() {
    }

    public ItemWithRef(int id, String name, UserWithRef owner) {
        this.id = id;
        this.name = name;
        this.owner = owner;
    }
}
