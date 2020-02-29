package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository <Event, Integer>{
//    CrudRepository is the base class we are extending to create our EventRepository
//    CrudRepository contains the behaviors to Create, Read, Update, and Delete objects from our database
//    EventRepository will be storing "Event" objects and that the primary key is of the data type "Integer"
//    Note: Java will do autoboxing between the use of Integer here and int in Event.java

}
