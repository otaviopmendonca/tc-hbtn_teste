import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class PersonTest {
    Person person = new Person();

    @BeforeEach
    public void setup(){
        person.setName("Paul");
        person.setSurname("McCartney");
        person.setBirthDate(new Date(100, 0, 1));
        person.setAnotherCompanyOwner(true);
        person.setPublicServer(true);
    }

    @Test
    public void show_full_name(){
        Assertions.assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary(){
        person.setSalary(1200);
        Assertions.assertEquals(14400, person.calculateYearlySalary());
    }

    @Test
    public void person_is_MEI(){
        person.setPublicServer(false);
        person.setPensioner(false);
        person.setAnotherCompanyOwner(false);
        Assertions.assertTrue(person.isMEI());
    }

    @Test
    public void person_is_not_MEI(){
        person.setPublicServer(true);
        Assertions.assertFalse(person.isMEI());
    }
}