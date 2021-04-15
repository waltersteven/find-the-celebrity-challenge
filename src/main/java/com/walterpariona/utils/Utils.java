package com.walterpariona.utils;

import com.walterpariona.dto.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static List<Person> initializePeople() {
        return new ArrayList<>(Arrays.asList(
                new Person(0, "Walter", Arrays.asList(1, 2)),
                new Person(1, "Jair", Arrays.asList(0, 2)),
                new Person(2, "Michael", Arrays.asList(2))
        ));
    }
}
