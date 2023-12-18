package com.example.studentsregistration.dao;

import com.example.studentsregistration.event.PersonEventHolder;
import com.example.studentsregistration.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@RequiredArgsConstructor
public class PersonDAO {

    private static int PEOPLE_COUNT;

    private final List<Person> people = new CopyOnWriteArrayList<>();

    private final ApplicationEventPublisher publisher;

    public List <Person> personList() {
        return people;
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
        publisher.publishEvent(new PersonEventHolder(this,person));
    }

    public void delete(int id) {
        for(Person person : people){
            if (person.getId() == id) {
                publisher.publishEvent(new PersonEventHolder(this,person));
                people.remove(person);
            }
        }
    }

    public void deleteAll() {
        people.clear();
        System.out.println("List students deleted");
    }
}