package org.launchcode.codingevents.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
//        Event event = (Event) o;
//        return id == event.id;
        AbstractEntity entity = (AbstractEntity) o;
        return id == entity.id;
    }
//    The compiler error occurs on the last line, and the context menu in IntelliJ describes it for us:
//       'id' has private access in 'org.launchcode.codingevents.models.AbstractEntity'
//    What is this telling us? As written, event is an Event object,
//    since it is the result of casting o to Event in the line above: Event event = (Event) o;.
//    But when we reference event.id we are attempting to reference the private field id,
//    which lives not in Event but in AbstractEntity. This is not allowed.//
//    This error is easy to fix; simply change the cast on the next-to-last line to convert o to an instance of AbstractEntity.
//    And while we’re at it, let’s give the variable event a better name.

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
