package nl.workingspirit.ws_bootcampappbackend.controller;

import org.assertj.core.util.Arrays;
import org.junit.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import nl.workingspirit.ws_bootcampappbackend.domein.Role;
import nl.workingspirit.ws_bootcampappbackend.domein.User;

import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class GettingServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private GettingService sut;

    @Before
    public void setUp() {
    	
    }

    @After
    public void tearDown() {

    }
    
    @Test
    public void haalAlleGebruikersOpMetRolStudent() {
    	User student = new User();
    	student.setRole(Role.STUDENT);
    	User docent = new User();
    	docent.setRole(Role.DOCENT);
    	User student2 = new User();
    	student2.setRole(Role.STUDENT);
    	User studenten [] = {student, student2};
    	Iterable<?> iterableStudentenVerwacht = Arrays.asList(studenten);
    	
    	when(userRepository.findByRoleOrderByLastNameAsc(Role.STUDENT)).thenReturn((Iterable<User>) iterableStudentenVerwacht);
    	Iterable<User> iterableStudentenEcht = sut.getAllUsersPerRole(Role.STUDENT);
    	Assert.assertEquals(iterableStudentenVerwacht, iterableStudentenEcht);
    	
    }
    
    @Test
    public void haalAlleGebruikersOpMetRolDocent() {
    	User docent = new User();
    	docent.setFirstName("Frans");
    	docent.setLastName("Pietje");
    	docent.setEmailaddress("hallo@hallo.nl");
    	docent.setPassword("docent");
    	docent.setRole(Role.DOCENT);
    	
    	User docenten [] = {docent};
    	Iterable<?> docentenVerwacht = Arrays.asList(docenten);
    	
    	when(userRepository.findByRoleOrderByLastNameAsc(Role.DOCENT)).thenReturn((Iterable<User>) docentenVerwacht);
    	Iterable<User> docentenEcht = sut.getAllUsersPerRole(Role.DOCENT);
    	Assert.assertEquals(docentenVerwacht, docentenEcht);
    	
    }
    
    @Test
    public void haalGebruikerOpVoorEmail() {

        User expectedUser = new User();

        when(userRepository.findByEmailaddress(anyString())).thenReturn(Optional.of(expectedUser));

        Optional<User> user = sut.getUserByEmailadress("test@test.nl");

        Assert.assertEquals(Optional.of(expectedUser), user);
    }
    
}
