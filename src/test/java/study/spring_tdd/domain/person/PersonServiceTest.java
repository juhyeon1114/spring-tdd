package study.spring_tdd.domain.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    final Person dummyPerson = new Person(999L, "DummyPerson", "person@dummy.com");

    @InjectMocks
    PersonServiceImpl personService;

    @Mock
    PersonJpaRepository mockPersonJpaRepository;

    @Spy
    PersonSpyService personSpyService;

    @Test
    void Mock_테스트() {
        when(mockPersonJpaRepository.findById(1L)).thenReturn(Optional.of(dummyPerson));

        // Mock 검증
        Person person = personService.getOne(1L);
        assertEquals(999L, person.getId());
        assertEquals("DummyPerson", person.getName());
    }
    
    @Test
    void Spy_테스트() {
        when(personSpyService.getOne(1L)).thenReturn(dummyPerson);

        // Spy 검증
        Person mustBeSpy = personSpyService.getOne(1L);
        assertEquals(999L, mustBeSpy.getId());
        assertEquals("DummyPerson", mustBeSpy.getName());

        // Spy 검증
        Person mustNotBeSpy = personSpyService.getOne(2L);
        assertEquals(3L, mustNotBeSpy.getId());
        assertEquals("Kim_getOne", mustNotBeSpy.getName());
    }

}