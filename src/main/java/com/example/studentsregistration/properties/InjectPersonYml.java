package com.example.studentsregistration.properties;


import com.example.studentsregistration.dao.PersonDAO;
import com.example.studentsregistration.model.Person;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty("app.inject.enabled")
public class InjectPersonYml {

    private final PersonDAO personDAO;


    private final ReaderPersonYml readerPersonYml;

    public InjectPersonYml(PersonDAO personDAO, ReaderPersonYml readerPersonYml) {
        this.personDAO = personDAO;
        this.readerPersonYml = readerPersonYml;
        inject();
    }

    public void inject(){
        for (ReaderPersonYml.PersonYml person : readerPersonYml.getPersonYml()) {
            personDAO.save(new Person(1,person.getLastName(),
                    person.getFirstName(),person.getAge()));
        }
    }
}