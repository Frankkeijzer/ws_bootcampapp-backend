package nl.workingspirit.ws_bootcampappbackend.controller;

import org.assertj.core.util.Arrays;
import org.junit.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import nl.workingspirit.ws_bootcampappbackend.domein.Role;
import nl.workingspirit.ws_bootcampappbackend.domein.User;
import nl.workingspirit.ws_bootcampappbackend.dto.UserWithoutEmailDTO;

import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class GettingServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserGetService sut;

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
    	List<User> listStudentenVerwacht = new ArrayList();
    	
    	
    	when(userRepository.findByRoleOrderByLastNameAsc(Role.STUDENT)).thenReturn((List<User>) listStudentenVerwacht);
    	Iterable<User> iterableStudentenEcht = sut.getAllUsersPerRole(Role.STUDENT);
    	Assert.assertEquals(listStudentenVerwacht, iterableStudentenEcht);
    	
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
    	List<User> docentenVerwacht = new ArrayList();
    	docentenVerwacht.add(docent);
    	
    	when(userRepository.findByRoleOrderByLastNameAsc(Role.DOCENT)).thenReturn((List<User>) docentenVerwacht);
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
    
    @Test
    public void GetUsersWithoutEmailAndPasswordTest() {
    	User expectedUser = new User();
    	expectedUser.setFirstName("Gert");
    	expectedUser.setLastName("Samson");
    	expectedUser.setEmailaddress("amai@gert.nl");
    	expectedUser.setPassword("mwajoahGertje");
    	expectedUser.setRole(Role.STUDENT);
    	
    	when(userRepository.findByRoleOrderByLastNameAsc(Mockito.eq(Role.STUDENT))).thenReturn(Collections.singletonList(expectedUser));
    	
    	List<UserWithoutEmailDTO> studentList = sut.getUsersWithoutEmailAndPassword(Role.STUDENT);
    	
    	Assert.assertTrue(studentList.size() == 1);
    	
    	UserWithoutEmailDTO requestedUser = studentList.get(0);
    	
    	Assert.assertEquals(expectedUser.getFirstName(), requestedUser.getFirstName());
    	Assert.assertEquals(expectedUser.getLastName(), requestedUser.getLastName());
    }
}
