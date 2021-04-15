package com.walterpariona.services;

import com.walterpariona.dto.Person;

import java.util.List;

public class FindCelebrityService {
    /**
     *
     * @param possibleCelebrity
     * @param people
     * @return
     */
    public boolean validateCelebrity(Person possibleCelebrity, List<Person> people) {
        // In order to validate is a celebrity, we can check if everyone knows this person and also check the celebrity doesn't know anybody.
        // Otherwise, person shouldn't be a celebrity.
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId() != possibleCelebrity.getId()
                    && (knowsPerson(possibleCelebrity, people.get(i)) || !knowsPerson(people.get(i), possibleCelebrity))) {
                return false;
            }
        }

        return true;
    }

    /**
     *
     * @param people
     * @return
     */
    public Person findPossibleCelebrity(List<Person> people) {
        Person possibleCelebrity = people.get(0);

        for (int i = 1; i < people.size(); i++) {
            // If the possible celebrity knows the ish person, then it means he/she isn't the celebrity.
            // Hence, we take the ish person as the new possible celebrity.
            if (knowsPerson(possibleCelebrity, people.get(i))) {
                possibleCelebrity = people.get(i);
            }
        }

        return possibleCelebrity;
    }

    /**
     *
     * @param personA
     * @param personB
     * @return
     */
    public boolean knowsPerson(Person personA, Person personB) {
        // We can find if a person knows another person by checking personA's knownPeople list.
        if (personA.getKnownPeople().contains(personB.getId())) {
            return true;
        }
        return false;
    }
}
