package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void personHasAutoGeneratedId() {
        //given
        //when
        Person person = new Person("Andreas der heile Hengst (AAA)");

        //then
        assertNotNull(person.getId());
    }
}