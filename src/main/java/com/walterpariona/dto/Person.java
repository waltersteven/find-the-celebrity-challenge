package com.walterpariona.dto;

import java.util.List;

public class Person {
    int id;
    String name;
    List<Integer> knownPeople;

    public Person(int id, String name, List<Integer> knownPeople) {
        this.id = id;
        this.name = name;
        this.knownPeople = knownPeople;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getKnownPeople() {
        return knownPeople;
    }
}
