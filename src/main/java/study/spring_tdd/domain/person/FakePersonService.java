package study.spring_tdd.domain.person;

import java.util.ArrayList;
import java.util.List;

public class FakePersonService implements PersonService {

    List<Person> persons = new ArrayList<>();

    @Override
    public Person create(Person person) {
        Long newId = Long.valueOf(persons.size() + 1);
        person.setId(newId);
        persons.add(person);
        return person;
    }

    @Override
    public Person update(Long id, String name) {
        Person person = persons.stream().filter(p -> p.getId().equals(id)).toList().getFirst();
        if (person != null) {
            person.setName(name);
            return person;
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        persons.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public Person getOne(Long id) {
        return persons.stream().filter(p -> p.getId().equals(id)).toList().getFirst();
    }
}
