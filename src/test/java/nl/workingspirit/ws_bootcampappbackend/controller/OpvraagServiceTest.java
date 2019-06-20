package nl.workingspirit.ws_bootcampappbackend.controller;

import org.assertj.core.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import nl.workingspirit.ws_bootcampappbackend.domein.Gebruiker;
import nl.workingspirit.ws_bootcampappbackend.domein.Rol;

import org.junit.Assert;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;


import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class OpvraagServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private GebruikerRepository gebruikerRepository;

    @InjectMocks
    private OpvraagService sut;

    @Before
    public void setUp() {
    	
    }

    @After
    public void tearDown() {

    }
    
    @Test
    public void haalAlleGebruikersOpMetRolStudent() {
    	Gebruiker student = new Gebruiker();
    	student.setRol(Rol.STUDENT);
    	Gebruiker docent = new Gebruiker();
    	docent.setRol(Rol.DOCENT);
    	Gebruiker student2 = new Gebruiker();
    	student2.setRol(Rol.STUDENT);
    	Gebruiker studenten [] = {student, student2};
    	Iterable<?> iterableStudentenVerwacht = Arrays.asList(studenten);
    	
    	when(gebruikerRepository.findByRol(Rol.STUDENT)).thenReturn((Iterable<Gebruiker>) iterableStudentenVerwacht);
    	Iterable<Gebruiker> iterableStudentenEcht = sut.geefPerRolAlleGebruikers(Rol.STUDENT);
    	Assert.assertEquals(iterableStudentenVerwacht, iterableStudentenEcht);
    	
    }
    
    @Test
    public void haalAlleGebruikersOpMetRolDocent() {
    	Gebruiker docent = new Gebruiker();
    	docent.setVoornaam("Frans");
    	docent.setAchternaam("Pietje");
    	docent.setEmailadres("hallo@hallo.nl");
    	docent.setWachtwoord("docent");
    	docent.setRol(Rol.DOCENT);
    	
    	Gebruiker docenten [] = {docent};
    	Iterable<?> docentenVerwacht = Arrays.asList(docenten);
    	
    	when(gebruikerRepository.findByRol(Rol.DOCENT)).thenReturn((Iterable<Gebruiker>) docentenVerwacht);
    	Iterable<Gebruiker> docentenEcht = sut.geefPerRolAlleGebruikers(Rol.DOCENT);
    	Assert.assertEquals(docentenVerwacht, docentenEcht);
    	
    }
    
    @Test
    public void haalGebruikerOpVoorEmail() {

        Gebruiker expectedGebruiker = new Gebruiker();

        when(gebruikerRepository.findByEmailadres(anyString())).thenReturn(Optional.of(expectedGebruiker));

        Optional<Gebruiker> gebruiker = sut.geefGebruikerViaEmail("test@test.nl");

        Assert.assertEquals(Optional.of(expectedGebruiker), gebruiker);
    }
    
}
