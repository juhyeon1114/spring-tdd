package study.spring_tdd.domain.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonJpaRepository personJpaRepository;

    public Person create(Person person) {
        return personJpaRepository.save(person);
    }

    public Person update(Long id, String name) {
        Person person = personJpaRepository.findById(id).orElse(null);
        if (person == null) return null;

        person.setName(name);
        return personJpaRepository.saveAndFlush(person);
    }

    public void delete(Long id) {
        personJpaRepository.deleteById(id);
    }

    public Person getOne(Long id) {
        return personJpaRepository.findById(id).orElse(null);
    }
}
