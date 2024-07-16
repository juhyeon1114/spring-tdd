package study.spring_tdd.domain.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@Slf4j
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    final Person dummyPerson = new Person(999L, "DummyPerson", "person@dummy.com");

    @InjectMocks
    PersonServiceImpl personService;

    @Mock
    PersonJpaRepository mockPersonJpaRepository;

    @Spy
    PersonSpyService personSpyService;

    @Mock
    FakePersonService fakePersonService;

    @Captor
    ArgumentCaptor<Person> personCaptor;

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

    @Test
    void Captor_테스트() {
        fakePersonService.create(dummyPerson);

        verify(fakePersonService).create(personCaptor.capture());
        Person person = personCaptor.getValue();

        log.info(String.valueOf(person.getId()));

    }

}