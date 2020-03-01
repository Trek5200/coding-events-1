package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Created by Chris Bay
 */
@Entity
public class EventCategory extends AbstractEntity {

//    Move the 4 class members that we identified as being duplicated across both models up into AbstractEntity.
//          id, getId, equals, hashMap
//    Now your Event class will inherit these members rather than define them itself.

//    @Id
//    @GeneratedValue
//    private int id;

    @Size(min=3, message="Name must be at least 3 characters long")
    private String name;

    public EventCategory(@Size(min = 3, message = "Name must be at least 3 characters long") String name) {
        this.name = name;
    }

    public EventCategory() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getId() {
//        return id;
//    }

    @Override
    public String toString() {
        return name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        EventCategory that = (EventCategory) o;
//        return id == that.id;
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}
