package com.walterpariona;

import com.walterpariona.dto.Person;
import com.walterpariona.services.FindCelebrityService;
import com.walterpariona.utils.Utils;

import java.util.List;

public class Main {
    // Author: Walter Pariona.
    // Challenge: Find the celebrity.

    public static void main(String[] args) {
        // - In a team of N people, a celebrity is known by everyone but he/she doesn't know anybody.

        // 1. Initialize sample data and service
        List<Person> people = Utils.initializePeople();

        FindCelebrityService findCelebrityService = new FindCelebrityService();

        // 2. Iterate through them and find out who is the possible celebrity.
        Person possibleCelebrity = findCelebrityService.findPossibleCelebrity(people);

        // 3. Validate if person found is the celebrity: checks if everyone knows this person and if the celebrity doesn't know anybody.
        boolean isCelebrity = findCelebrityService.validateCelebrity(possibleCelebrity, people);

        if (isCelebrity) {
            System.out.println("The celebrity's name is >>> " + possibleCelebrity.getName());
        } else {
            System.out.println("No celebrity found in people.");
        }
    }
}
