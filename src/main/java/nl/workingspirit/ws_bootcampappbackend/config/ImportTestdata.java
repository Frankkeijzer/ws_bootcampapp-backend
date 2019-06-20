package ws.workingspirit.bootcamp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ws.workingspirit.bootcamp.controller.GebruikerRepository;
import ws.workingspirit.bootcamp.domein.Gebruiker;
import ws.workingspirit.bootcamp.domein.Rol;

@Configuration
public class ImportTestdata {
	@Bean
	public CommandLineRunner importGebruikersTestdata(GebruikerRepository gebruikerRepository) {
		return (args) -> {
			//data opzet is gelijk aan het Insert script wat met SQL kan worden ingelezen
			gebruikerRepository.save(createGebruiker("Graafmans", "w.graafmans@workingspirit.nl", Rol.STUDENT, "Wietse", "kombinnen"));
			gebruikerRepository.save(createGebruiker("Nekoui", "a.nekoui@workingspirit.nl", Rol.STUDENT, "Arash", "kombinnen"));
			gebruikerRepository.save(createGebruiker("Kikkert", "j.kikkert@workingspirit.nl", Rol.STUDENT, "Justin", "kombinnen"));
			gebruikerRepository.save(createGebruiker("Westhof", "e.Westhof@workingspirit.nl", Rol.STUDENT, "Eline", "kombinnen"));
			gebruikerRepository.save(createGebruiker("Smit", "d.smit@workingspirit.nl", Rol.STUDENT, "David", "kombinnen"));
			gebruikerRepository.save(createGebruiker("Keijzer", "f.keijzer@workingspirit.nl", Rol.STUDENT, "Frank", "kombinnen"));
			gebruikerRepository.save(createGebruiker("Lunding", "m.lunding@workingspirit.nl", Rol.STUDENT, "Mark", "kombinnen"));
			gebruikerRepository.save(createGebruiker("Loenen van", "digitaleservice@gmail.com", Rol.DOCENT, "Felxi", "kombinnen"));
			gebruikerRepository.save(createGebruiker("Faber", "faber.coding101@gmail.com", Rol.DOCENT, "Cor", "kombinnen"));
			gebruikerRepository.save(createGebruiker("Kerkdijk", "m.kerkdijk@workingspirit.nl", Rol.DOCENT, "Marco", "kombinnen"));
			gebruikerRepository.save(createGebruiker("", "raymond@carpago.nl", Rol.DOCENT, "Raymond", "kombinnen"));
			gebruikerRepository.save(createGebruiker("Scheuneman", "f.scheuneman@workingspirit.nl", Rol.ADMIN, "Frans", "kombinnen"));
			gebruikerRepository.save(createGebruiker("Oosterhuis", "r.oosterhuis@workingspirit.nl", Rol.ADMIN, "Richard", "kombinnen"));
			gebruikerRepository.save(createGebruiker("Gulik, van", "m.vangulik@workingspirit.nl", Rol.MEDEWERKER, "Mathijs", "kombinnen"));
		};
	}

	private Gebruiker createGebruiker(String achternaam, String emailadres, Rol rol, String voornaam, String wachtwoord) {
		Gebruiker gebruiker = new Gebruiker();
		gebruiker.setVoornaam(voornaam);
		gebruiker.setAchternaam(achternaam);
		gebruiker.setEmailadres(emailadres);
		gebruiker.setWachtwoord(wachtwoord);
		gebruiker.setRol(rol);
		return gebruiker;
	}
	
	
	
}
