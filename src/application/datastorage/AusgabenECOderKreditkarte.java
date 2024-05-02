package application.datastorage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AusgabenECOderKreditkarte {
	
	private StringProperty kostenGeplant;
	private StringProperty kostenEffektiv;
	private StringProperty unerwarteteRechnungen;
	private StringProperty unerwarteteKosten;
	private StringProperty freierText;
	
	public AusgabenECOderKreditkarte() {
		kostenGeplant = new SimpleStringProperty("");
		kostenEffektiv = new SimpleStringProperty("");
		unerwarteteRechnungen = new SimpleStringProperty("");
		unerwarteteKosten = new SimpleStringProperty("");
		freierText = new SimpleStringProperty("");
	}
	
	public StringProperty kostenGeplantProperty() {
		return kostenGeplant;
	}
	
	public void setKostenGeplant(String newKostenGeplant) {
		this.kostenGeplant.set(newKostenGeplant);;
	}
	
	public String getKostenGeplant() {
		return kostenGeplant.get();
	}
	
	public StringProperty kostenEffektivProperty() {
		return kostenEffektiv;
	}
	
	public void setKostenEffektiv(String newKostenEffektiv) {
		this.kostenEffektiv.set(newKostenEffektiv);;
	}
	
	public String getKostenEffektiv() {
		return kostenEffektiv.get();
	}
	
	public StringProperty unerwarteteRechnungenProperty() {
		return unerwarteteRechnungen;
	}
	
	public void setUnerwarteteRechnungen(String newUnerwarteteRechnungen) {
		this.unerwarteteRechnungen.set(newUnerwarteteRechnungen);;
	}
	
	public String getUnerwarteteRechnungen() {
		return unerwarteteRechnungen.get();
	}
	
	public StringProperty unerwarteteKostenProperty() {
		return unerwarteteKosten;
	}
	
	public void setUnerwarteteKosten(String newUnerwarteteKosten) {
		this.unerwarteteKosten.set(newUnerwarteteKosten);;
	}
	
	public String getUnerwarteteKosten() {
		return unerwarteteKosten.get();
	}
	
	// Freier Text
	public StringProperty freierTextProperty() {
		return freierText;
	}
	
	public void setFreierText(String newFreierText) {
		this.freierText.set(newFreierText);
	}
	
	public String getFreierText() {
		return freierText.get();
	}

}
