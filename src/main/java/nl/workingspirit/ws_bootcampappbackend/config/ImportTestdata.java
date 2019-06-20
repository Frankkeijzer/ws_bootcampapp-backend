package nl.workingspirit.ws_bootcampappbackend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nl.workingspirit.ws_bootcampappbackend.controller.UserRepository;
import nl.workingspirit.ws_bootcampappbackend.domein.User;
import nl.workingspirit.ws_bootcampappbackend.domein.Role;



@Configuration
public class ImportTestdata {
	@Bean
	public CommandLineRunner importUserTestdata(UserRepository userRepository) {
		return (args) -> {
			//data opzet is gelijk aan het Insert script wat met SQL kan worden ingelezen
			userRepository.save(createUser("Graafmans", "w.graafmans@workingspirit.nl", Role.STUDENT, "Wietse", "kombinnen"));
			userRepository.save(createUser("Nekoui", "a.nekoui@workingspirit.nl", Role.STUDENT, "Arash", "kombinnen"));
			userRepository.save(createUser("Kikkert", "j.kikkert@workingspirit.nl", Role.STUDENT, "Justin", "kombinnen"));
			userRepository.save(createUser("Westhof", "e.Westhof@workingspirit.nl", Role.STUDENT, "Eline", "kombinnen"));
			userRepository.save(createUser("Smit", "d.smit@workingspirit.nl", Role.STUDENT, "David", "kombinnen"));
			userRepository.save(createUser("Keijzer", "f.keijzer@workingspirit.nl", Role.STUDENT, "Frank", "kombinnen"));
			userRepository.save(createUser("Lunding", "m.lunding@workingspirit.nl", Role.STUDENT, "Mark", "kombinnen"));
			userRepository.save(createUser("Loenen van", "digitaleservice@gmail.com", Role.DOCENT, "Felxi", "kombinnen"));
			userRepository.save(createUser("Faber", "faber.coding101@gmail.com", Role.DOCENT, "Cor", "kombinnen"));
			userRepository.save(createUser("Kerkdijk", "m.kerkdijk@workingspirit.nl", Role.DOCENT, "Marco", "kombinnen"));
			userRepository.save(createUser("", "raymond@carpago.nl", Role.DOCENT, "Raymond", "kombinnen"));
			userRepository.save(createUser("Scheuneman", "f.scheuneman@workingspirit.nl", Role.ADMIN, "Frans", "kombinnen"));
			userRepository.save(createUser("Oosterhuis", "r.oosterhuis@workingspirit.nl", Role.ADMIN, "Richard", "kombinnen"));
			userRepository.save(createUser("Gulik, van", "m.vangulik@workingspirit.nl", Role.MEDEWERKER, "Mathijs", "kombinnen"));
		};
	}

	private User createUser(String achternaam, String emailadres, Role rol, String firstName, String wachtwoord) {
		User gebruiker = new User();
		gebruiker.setVoornaam(firstName);
		gebruiker.setAchternaam(achternaam);
		gebruiker.setEmailaddress(emailadres);
		gebruiker.setPassword(wachtwoord);
		gebruiker.setRole(rol);
		return gebruiker;
	}
	
	
	
}
