package nl.workingspirit.ws_bootcampappbackend.domein;

import javax.persistence.Id;

public enum Role {
		STUDENT("Student"),
		ADMIN("Admin"),
		DOCENT("Docent"),
		MEDEWERKER("Medewerker");

		@Id
		String description;

		public String getOmschrijving() {
			return description;
		}

		Role(String description) {
			this.description = description;
		}

}
