package repositories;

import domain.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PersonRepositoryImplTest {

    @Test
    void findAll_returnsNonNull() {
        //arrange
        var personRepository = new PersonRepositoryImpl();

        //act
        var result = personRepository.findAll();

        //assert
        assertNotNull(result);
    }

    @Test
    @DisplayName("PersonRepositoryImpl findAll when Person is present returns non empty")
    void findAll_whenPersonPresent_returnsNonEmpty() {
        //arrange
        var personRepository = new PersonRepositoryImpl();
        personRepository.insertPerson(new Person("Sleya die Weltenverschlingering"));

        //act
        var result = personRepository.findAll();

        //assert
        assertFalse(result.isEmpty());
    }

    @Test
    @DisplayName("PersonRepositoryImpl findAll when Person is present is in returned list")
    void findAll_whenPersonPresent_isInReturnedList() {
        //arrange
        var personRepository = new PersonRepositoryImpl();
        var person = new Person("Sleya die Weltenverschlingering");
        personRepository.insertPerson(person);

        //act
        var result = personRepository.findAll();

        //assert
        assertTrue(result.contains(person));
    }

    @Test
    void remove_whenNoPersonMatches_DoesNothing() {
        //arrange
        var personRepository = new PersonRepositoryImpl();
        var person = new Person("Sleya die Weltenverschlingering");
        personRepository.insertPerson(person);

        //act
        var countBefore = personRepository.findAll().size();
        personRepository.removeById(UUID.randomUUID());
        var countAfter = personRepository.findAll().size();

        //assert
        assertEquals(countBefore, countAfter);
    }

    @Test
    void remove_whenPersonRemoved_isNotPresent() {
        //arrange
        var personRepository = new PersonRepositoryImpl();
        var person = new Person("Sleya die Weltenverschlingering");
        personRepository.insertPerson(person);

        //act
        var countBefore = personRepository.findAll().size();
        personRepository.removeById(person.getId());
        var countAfter = personRepository.findAll().size();

        //assert
        assertFalse(personRepository.findAll().contains(person));
    }

}