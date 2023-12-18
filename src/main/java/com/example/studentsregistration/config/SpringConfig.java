package com.example.studentsregistration.config;


import com.example.studentsregistration.dao.PersonDAO;
import com.example.studentsregistration.properties.InjectPersonYml;
import com.example.studentsregistration.properties.ReaderPersonYml;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean(InjectPersonYml.class)
public class SpringConfig {

    @Bean
    public InjectPersonYml injectPersonYml(ReaderPersonYml readerPersonYml,
                                           PersonDAO personDAO ) {
        return new InjectPersonYml(personDAO, readerPersonYml);
    }
}