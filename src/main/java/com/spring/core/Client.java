package com.spring.core;

public class Client {
    private Integer id;
    private String name;
    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(final String greeting) {
        this.greeting = greeting;
    }

    public Client(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
