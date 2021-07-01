package services;

import domain.Person;
import repositories.PersonRepository;

import java.util.Optional;

public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void insertPerson(Person person) {
        personRepository.insertPerson(person);
    }

    public Optional<Person> findPerson(Person person) {
        return personRepository.findAll()
                .stream()
                .filter(person::equals)
                .findFirst();
    }
}
