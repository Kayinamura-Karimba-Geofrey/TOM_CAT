import com.example.model.Person;
import com.example.model.Gender;
import org.junit.jupiter.api.Test;




import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    public void getGender() {
        Person p = new Person(1, "Mike", "Mugisha", Gender.MALE, 18);

        assertTrue(p.getGender() == Gender.MALE);
        assertFalse(p.getGender() == Gender.FEMALE);
    }

    @Test
    public void getAge() {
        Person p = new Person(1, "geofrey", "kayin", Gender.MALE, 25);
        assertEquals(25, p.getAge());
    }
}

