package nl.workingspirit.ws_bootcampappbackend.config;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import nl.workingspirit.ws_bootcampappbackend.controller.AssignmentRepository;
import nl.workingspirit.ws_bootcampappbackend.controller.UserRepository;
import nl.workingspirit.ws_bootcampappbackend.domein.User;
import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;
import nl.workingspirit.ws_bootcampappbackend.domein.Role;


@Configuration
public class ImportTestdata {

    private final String WACHTWOORD = "kombinnen";
    private final int NUMBEROFUSERS = 14;

    @Bean
    public CommandLineRunner importUserTestdata(UserRepository userRepository) {
        return (args) -> {
        	
            Faker faker = Faker.instance();

            // create 14 random users
            for (int i = 0; i < NUMBEROFUSERS; i++) {
                Name person = faker.name();
                int n = i % Role.values().length;
                userRepository.save(createUser(person.lastName(), faker.bothify("????##@gmail.com"), Role.values()[n], person.firstName(), WACHTWOORD));
            }
        };
    }
    
    @Bean
    public CommandLineRunner importAssignmentTestdata(AssignmentRepository assignmentRepository) {
        return (args) -> {

//         volgorde en type input: String level, String day, boolean visible, String description, String title, String codeExample
        	
            assignmentRepository.save(createAssignment("1", "1", true, "Print de concatenatie van een aantal strings. Voorbeeld: “po”, “ging”, “en” wordt “pogingen”.", "Concateneer Strings", "public class StringConcat {\r\n" + 
            		"   public static void main(String[] args) {\r\n" + 
            		"       String str1 = dop;\r\n" + 
            		"       String str2 = erwt;\r\n" + 
            		"       String str3 = en;\r\n" + 
            		"       String result;\r\n" + 
            		"       // Concateneer str1, str2 en str3 en assign aan result\r\n" + 
            		"       // print string result\r\n" + 
            		"   }\r\n" + 
            		"\r\n" + 
            		"}"));
            assignmentRepository.save(createAssignment("2", "1", true, "Van twee gegeven variabelen x en y, print het verschil en de som.", "Print som en verschil", "\r\n" + 
            		"package opdracht._15_print_som_en_verschil;\r\n" + 
            		"\r\n" + 
            		"public class PrintSomEnVerschil {\r\n" + 
            		"\r\n" + 
            		"   int x = 8;\r\n" + 
            		"\r\n" + 
            		"   int y = 2;\r\n" + 
            		"\r\n" + 
            		"   // print x + y\r\n" + 
            		"\r\n" + 
            		"   // print x - y\r\n" + 
            		"\r\n" + 
            		"}"));
            assignmentRepository.save(createAssignment("3", "1", true, "Vergelijk de variabele die in de code cijfer heet met het getal 6.\r\n" + 
            		"Indien cijfer > 6 print “hoger”,\r\n" + 
            		"Indien cijfer = 6 print “gelijk”,\r\n" + 
            		"Indien cijfer < 6 print “lager”.\r\n" + 
            		"Geef variabele cijfer verschillende waardes om je programma te testen\r\n" +
    				"\r\n" + 
            		"Moeilijke variant:\r\n" + 
            		"Lees cijfer als input m.b.v. Scanner.", "Hoger of lager dan 6", "package opdracht._13_Hoger_of_lager_dan_6;\r\n" + 
            				"import java.util.Scanner;\r\n" + 
            				"public class VergelijkMetZes {\r\n" + 
            				"   public static void main(String[] args) {\r\n" + 
            				"       int cijfer = 8;\r\n" + 
            				"\r\n" + 
            				"       // Vergelijk cijfer met 6\r\n" + 
            				"   }\r\n" + 
            				"}"));
            assignmentRepository.save(createAssignment("4", "1", true, "Tel het aantal keer dat de letter “e” in een gegeven string voorkomt.\r\n" + 
            		"Voorbeeld: “regenen” heeft 3 keer de letter “e”.", "Letter count", "public class LetterCount {\r\n" + 
            				"   public static void main(String[] args) {\r\n" + 
            				"       String org = \"Deze regel heeft best wel veel eees.\";\r\n" + 
            				"       int res;\r\n" + 
            				"\r\n" + 
            				"       // Tel hoe vaak de letter \"e\" voorkomt in string org\r\n" + 
            				"\r\n" + 
            				"       // Print aantal \"e\"-s in org\r\n" + 
            				"   }\r\n" + 
            				"\r\n" + 
            				"}"));
            assignmentRepository.save(createAssignment("1", "2", false, "Tel het aantal keer dat de letter “e” in een gegeven string voorkomt.\r\n" + 
            		"Voorbeeld: “regenen” heeft 3 keer de letter “e”.", "Array sum", "public class LetterCount {\r\n" + 
            				"   public static void main(String[] args) {\r\n" + 
            				"       String org = \"Deze regel heeft best wel veel eees.\";\r\n" + 
            				"       int res;\r\n" + 
            				"\r\n" + 
            				"       // Tel hoe vaak de letter \"e\" voorkomt in string org\r\n" + 
            				"\r\n" + 
            				"       // Print aantal \"e\"-s in org\r\n" + 
            				"   }\r\n" + 
            				"}"));
            assignmentRepository.save(createAssignment("2", "2", false, "Tel het aantal keer dat de letter “e” in een gegeven string voorkomt.\r\n" + 
            		"Voorbeeld: “regenen” heeft 3 keer de letter “e”.", "Letter count", "\r\n" + 
            		"public class LetterCount {\r\n" + 
            		"   public static void main(String[] args) {\r\n" + 
            		"       String org = \"Deze regel heeft best wel veel eees.\";\r\n" + 
            		"       int res;\r\n" + 
            		"\r\n" + 
            		"       // Tel hoe vaak de letter \"e\" voorkomt in string org\r\n" + 
            		"\r\n" + 
            		"       // Print aantal \"e\"-s in org\r\n" + 
            		"   }\r\n" + 
            		"}"));
            assignmentRepository.save(createAssignment("3", "2", true, "Print een overzicht van alle kaarten van het kaartspel. Gebruik hierbij een array.", "Print het hele kaartspel uit", "Codeer de opdracht volledig zelf met wat je hebt geleerd"));
            
        };
    }
        	
    private User createUser(String achternaam, String emailadres, Role rol, String firstName, String wachtwoord) {
        User gebruiker = new User();
        gebruiker.setFirstName(firstName);
        gebruiker.setLastName(achternaam);
        gebruiker.setEmailaddress(emailadres);
        gebruiker.setPassword(wachtwoord);
        gebruiker.setRole(rol);
        return gebruiker;
    }
    
    private Assignment createAssignment(String level, String day, boolean visible, String description, String title, String codeExample) {
    	Assignment assignment = new Assignment();
    	assignment.setLevel(level);
    	assignment.setDay(day);
    	assignment.setVisible(visible);
    	assignment.setDescription(description);
    	assignment.setTitle(title);
    	assignment.setCodeExample(codeExample);
    	return assignment;
    }
}
