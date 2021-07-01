package services;

import domain.Person;
import org.junit.jupiter.api.Test;
import repositories.PersonRepositoryImpl;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonServiceTest {

    @Test
    void findPerson_whenNoPerson_returnsEmptyOptional() {
        //arrange
        var personService = new PersonService(new PersonRepositoryImpl());
        var person = new Person("Cool Person (Florian Weingartshofer ;*)");

        //act
        var optionalPerson = personService.findPerson(person);

        //assert
        assertTrue(optionalPerson.isEmpty());
    }

    @Test
    void findPerson_whenPersonIsPresent_returnsNonEmptyOptional() {
        //arrange
        var personService = new PersonService(new PersonRepositoryImpl());
        var person = new Person("Cool Person (Florian Weingartshofer ;*)");
        personService.insertPerson(person);
        //act
        var optionalPerson = personService.findPerson(person);

        //assert
        assertTrue(optionalPerson.isPresent());
    }

    @Test
    void findPerson_whenPersonIsPresent_returnsEqualPerson() {
        //arrange
        var personService = new PersonService(new PersonRepositoryImpl());
        var person = new Person("Cool Person (Florian Weingartshofer ;*)");
        personService.insertPerson(person);
        //act
        var optionalPerson = personService.findPerson(person);

        //assert
        assertEquals(person, optionalPerson.get());
    }

    @Test
    void insertPerson_insertsPersonInTheRepository() {
        //arrange
        var personRepository = mock(PersonRepositoryImpl.class);
        when(personRepository.findAll())
                .thenReturn(new ArrayList<>());
        var personService = new PersonService(personRepository);
        var person = new Person("Cool Person (Florian Vino ;*)");
        personService.insertPerson(person);

        //act
        var optionalPerson = personService.findPerson(person);

        //assert
        verify(personRepository, times(1)).insertPerson(any());
    }

}