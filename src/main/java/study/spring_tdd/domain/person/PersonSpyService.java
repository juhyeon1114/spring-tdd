package study.spring_tdd.domain.person;


public class PersonSpyService implements PersonService {

    @Override
    public Person create(Person person) {
        return new Person(1L, "Kim_create", "hello@world.com");
    }

    @Override
    public Person update(Long id, String name) {
        return new Person(2L, "Kim_update", "hello@world.com");
    }

    @Override
    public void delete(Long id) {
        // do nothing
    }

    @Override
    public Person getOne(Long id) {
        return new Person(3L, "Kim_getOne", "hello@world.com");
    }
}
