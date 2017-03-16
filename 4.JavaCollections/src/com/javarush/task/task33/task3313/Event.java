package com.javarush.task.task33.task3313;

//import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Event {
    public String name;

    public Date eventDate;

    public Event(String name) {
        this.name = name;
        eventDate = new Date();
    }
}