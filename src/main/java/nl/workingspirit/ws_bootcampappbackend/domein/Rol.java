package nl.workingspirit.ws_bootcampappbackend.domein;

import javax.persistence.Id;

public enum Rol {
		STUDENT("Student"),
		ADMIN("Admin"),
		DOCENT("Docent"),
		MEDEWERKER("Medewerker");

		@Id
		String omschrijving;

		public String getOmschrijving() {
			return omschrijving;
		}

		Rol(String omschrijving) {
			this.omschrijving = omschrijving;
		}

}
