package nl.workingspirit.ws_bootcampappbackend.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OpslaanServiceTest{

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private GebruikerRepository gebruikerRepository;

    @InjectMocks
    private OpslaanService sut;
    
    @InjectMocks
    private OpvraagService sutje;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }
}    
/*
 * @Test public void PostGebruikerBestaandEmailadres() { Gebruiker
 * nieuweGebruiker = new Gebruiker();
 * nieuweGebruiker.setEmailadres("t@test.nl"); Gebruiker
 * gebruikerZelfdeEmailadres = new Gebruiker();
 * gebruikerZelfdeEmailadres.setEmailadres("t@test.nl");
 * sut.postGebruiker(nieuweGebruiker);
 * 
 * } }
 */
