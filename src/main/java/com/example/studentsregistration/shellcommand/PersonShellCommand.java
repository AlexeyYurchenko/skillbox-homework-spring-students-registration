package com.example.studentsregistration.shellcommand;


import com.example.studentsregistration.dao.PersonDAO;
import com.example.studentsregistration.model.Person;
import com.example.studentsregistration.util.PersonValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@ShellComponent
@RequiredArgsConstructor
public class PersonShellCommand {


    private final PersonDAO personDAO;

    @ShellMethod(value = "Information on commands", key = "info")
    public String info() {
        return "Select command: " +
                "(add) Add Student, " +
                "(list) All List Students, " +
                "(del) Remove Student by ID, " +
                "(delAll) Delete all Students";
    }

    @ShellMethod(value = "List Student",key = "list")
    public void list() {
        personDAO.personList().forEach(System.out::println);
    }

    @ShellMethod(value = "Add Student",key = "add")
    public void add() throws IOException {
        boolean stop = true;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (stop) {
            System.out.println("enter your firstName: ");
            String firstName = bf.readLine().trim();
            if (!PersonValidator.isfirstName(firstName)) {
                System.out.println("Invalid firstName input format");
                continue;
            }
            System.out.println("enter your lastName: ");
            String lastName = bf.readLine().trim();
            if (!PersonValidator.islastName(lastName)) {
                System.out.println("Invalid lastName input format");
                continue;
            }
            System.out.println("enter your age: ");
            String age = bf.readLine().trim();
            if (!PersonValidator.isAge(age)) {
                System.out.println("Invalid age input format");
                continue;
            }
            personDAO.save(new Person(1,firstName, lastName, age));
            stop=false;
        }
    }
    @ShellMethod(value = "Remove Student by ID",key = "del")
    public void delete(int id) {
        personDAO.delete(id);
    }

    @ShellMethod(value = "Delete all Students", key = "delAll")
    public void deleteAll() {
        personDAO.deleteAll();
    }
}