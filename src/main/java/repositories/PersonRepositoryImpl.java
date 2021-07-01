package repositories;

import domain.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;


public class PersonRepositoryImpl implements PersonRepository {
    List<Person> persons = new ArrayList<>();

    public Collection<Person> findAll() {
        return persons;
    }

    public void insertPerson(Person person) {
        persons.add(person);
    }

    public void removeById(UUID id) {
        var opt = persons.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
        opt.ifPresent(person -> persons.remove(person));
    }
}
