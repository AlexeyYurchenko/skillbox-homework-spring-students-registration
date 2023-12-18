package com.example.studentsregistration.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PersonEventHolderListener {

    @EventListener
    public void listen(PersonEventHolder personHolder){
        System.out.println("listen method");
        System.out.println(personHolder.getPerson());
    }
}