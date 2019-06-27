package nl.workingspirit.ws_bootcampappbackend.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import nl.workingspirit.ws_bootcampappbackend.controller.UserRepository;
import nl.workingspirit.ws_bootcampappbackend.domein.User;
import nl.workingspirit.ws_bootcampappbackend.domein.Role;


@Configuration
public class ImportTestdata {

    private final String WACHTWOORD = "kombinnen";
    private final int NUMBEROFUSERS = 14;

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportTestdata.class);


    @Bean
    public CommandLineRunner importUserTestdata(UserRepository userRepository) {
        return (args) -> {

            Faker faker = Faker.instance();

            //data opzet is gelijk aan het Insert script wat met SQL kan worden ingelezen
            // create 14 random users
            for (int i = 0; i < NUMBEROFUSERS; i++) {
                Name person = faker.name();
                userRepository.save(createUser(person.lastName(), faker.bothify("????##@gmail.com"), Role.STUDENT, person.firstName(), WACHTWOORD));
            }
        };
    }

    private User createUser(String achternaam, String emailadres, Role rol, String firstName, String wachtwoord) {

        LOGGER.debug("Entering ImportTestdata::createUser");

        User gebruiker = new User();
        gebruiker.setFirstName(firstName);
        gebruiker.setLastName(achternaam);
        gebruiker.setEmailaddress(emailadres);
        gebruiker.setPassword(wachtwoord);
        gebruiker.setRole(rol);

        LOGGER.info("Created user: "+gebruiker);

        // LOGGER.error("Dit ging vaut");

        LOGGER.debug("Leaving ImportTestdata::createUser");

        return gebruiker;
    }
}
