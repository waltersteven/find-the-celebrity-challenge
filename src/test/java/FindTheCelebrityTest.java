import com.walterpariona.dto.Person;
import com.walterpariona.services.FindCelebrityService;
import com.walterpariona.utils.Utils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindTheCelebrityTest {
    private static FindCelebrityService service;
    @BeforeAll
    static void initAll() {
        service = new FindCelebrityService();
    }

    @Test
    @DisplayName("Test when a celebrity exist in people")
    void testACelebrityIsFound() {
        List<Person> people = getSamplePeopleWithCelebrity();

        Person possibleCelebrity = service.findPossibleCelebrity(people);
        boolean isCelebrity = service.validateCelebrity(possibleCelebrity, people);

        assertTrue(isCelebrity);
    }

    @Test
    @DisplayName("Test when celebrity does not exist in people")
    void testACelebrityIsNotFound() {
        List<Person> people = getSamplePeopleWithoutCelebrity();

        Person possibleCelebrity = service.findPossibleCelebrity(people);
        boolean isCelebrity = service.validateCelebrity(possibleCelebrity, people);

        assertFalse(isCelebrity);
    }

    private List<Person> getSamplePeopleWithCelebrity() {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person(0, "Walter", Arrays.asList(1, 2)),
                new Person(1, "Jair", Arrays.asList(0, 2)),
                new Person(2, "Michael", Arrays.asList(2))
        ));
        return people;
    }

    private List<Person> getSamplePeopleWithoutCelebrity() {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person(0, "Walter", Arrays.asList(1, 2)),
                new Person(1, "Jair", Arrays.asList(0, 2)),
                new Person(2, "Michael", Arrays.asList(1))
        ));
        return people;
    }
}
