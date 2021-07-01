package repositories;

import domain.Person;

import java.util.Collection;
import java.util.UUID;

public interface PersonRepository {

    Collection<Person> findAll();

    void insertPerson(Person person);

    void removeById(UUID id);

}
