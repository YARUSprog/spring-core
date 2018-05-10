package com.spring.core;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {
    private Integer id;
    private String messge;
    private Date date;
    private DateFormat dateFormat;
    private static Random random = new Random(100);

    public Event(final Date date, final DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
        this.id = random.nextInt();
    }

    public String getMessge() {
        return messge;
    }

    public void setMessge(final String messge) {
        this.messge = messge;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", messge='" + messge + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }
}
