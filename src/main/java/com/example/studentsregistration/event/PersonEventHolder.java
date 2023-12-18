package com.example.studentsregistration.event;

import com.example.studentsregistration.model.Person;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;


@Getter
public class PersonEventHolder extends ApplicationEvent {

    private final Person person;

    public PersonEventHolder(Object source, Person person) {
        super(source);
        this.person=person;
    }
}