package study.spring_tdd.domain.person;

public interface PersonService {

    Person create(Person person);

    Person update(Long id, String name);

    void delete(Long id);

    Person getOne(Long id);

}
