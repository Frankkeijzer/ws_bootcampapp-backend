package nl.workingspirit.ws_bootcampappbackend.domein;

import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Opdracht {
	@Id
	@GeneratedValue
	private Long id;
	private String niveau;
	private String dag;
	private boolean zichtbaar;
	private String beschrijving;
	private String titel;
	private String codeVoorbeeld;

	@OneToMany
	private List<Uitwerking> uitwerkingen;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getDag() {
		return dag;
	}

	public void setDag(String dag) {
		this.dag = dag;
	}

	public boolean isZichtbaar() {
		return zichtbaar;
	}

	public void setZichtbaar(boolean zichtbaar) {
		this.zichtbaar = zichtbaar;
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getCodeVoorbeeld() {
		return codeVoorbeeld;
	}

	public void setCodeVoorbeeld(String codeVoorbeeld) {
		this.codeVoorbeeld = codeVoorbeeld;
	}

	public List<Uitwerking> getUitwerkingen() {
		return Collections.unmodifiableList(uitwerkingen);
	}
	
	public void addUitwerking(Uitwerking uitwerking) {
		this.uitwerkingen.add(uitwerking);
	}
	
}
