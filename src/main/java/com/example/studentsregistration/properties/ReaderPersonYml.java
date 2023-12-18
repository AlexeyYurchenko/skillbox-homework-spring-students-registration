package com.example.studentsregistration.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@ConfigurationProperties(prefix = "inject-person-yml")
@Component
public class ReaderPersonYml {


    private List<PersonYml> personYml = new ArrayList<>();

    @Getter
    @Setter
    public static class PersonYml {

        private String firstName;

        private String lastName;

        private String age;

    }
}