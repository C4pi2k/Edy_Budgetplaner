package application.datastorage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VersicherungUndVorsorge {
	
	private StringProperty kostenGeplant;
	private StringProperty kostenEffektiv;
	private StringProperty krankenversicherung;
	private StringProperty hausratHatfpflichtRechtschutzversicherung;
	private StringProperty dritteSaeule;
	private StringProperty unerwarteteKosten;
	private StringProperty freierText;
	
	public VersicherungUndVorsorge() {
		kostenGeplant = new SimpleStringProperty("");
		kostenEffektiv = new SimpleStringProperty("");
		krankenversicherung = new SimpleStringProperty("");
		hausratHatfpflichtRechtschutzversicherung = new SimpleStringProperty("");
		dritteSaeule = new SimpleStringProperty("");
		unerwarteteKosten = new SimpleStringProperty("");
		freierText = new SimpleStringProperty("");
	}
	
	// Kosten geplant
	public StringProperty kostenGeplantProperty() {
		return kostenGeplant;
	}
	
	public void setKostenGeplant(String newKostenGeplant) {
		this.kostenGeplant.set(newKostenGeplant);;
	}
	
	public String getKostenGeplant() {
		return kostenGeplant.get();
	}
	
	// Kosten effektiv
	public StringProperty kostenEffektivProperty() {
		return kostenEffektiv;
	}
	
	public void setKostenEffektiv(String newKostenEffektiv) {
		this.kostenEffektiv.set(newKostenEffektiv);;
	}
	
	public String getKostenEffektiv() {
		return kostenEffektiv.get();
	}
	
	// Krankenversicherung
	public StringProperty krankenVersicherungProperty() {
		return krankenversicherung;
	}
	
	public void setKrankenversicherung(String newKrankenversicherung) {
		this.krankenversicherung.set(newKrankenversicherung);;
	}
	
	public String getKrankenversicherung() {
		return krankenversicherung.get();
	}
	
	// Hausrat Hatfpflicht Rechtschutzversicherung
	public StringProperty hausratHatfpflichtRechtschutzversicherungProperty() {
		return hausratHatfpflichtRechtschutzversicherung;
	}
	
	public void setHausratHatfpflichtRechtschutzversicherung(String newHausratHatfpflichtRechtschutzversicherung) {
		this.hausratHatfpflichtRechtschutzversicherung.set(newHausratHatfpflichtRechtschutzversicherung);;
	}
	
	public String getHausratHatfpflichtRechtschutzversicherung() {
		return hausratHatfpflichtRechtschutzversicherung.get();
	}
	
	// Dritte Saeule
	public StringProperty dritteSaeuleProperty() {
		return dritteSaeule;
	}
	
	public void setDritteSaeule(String newDritteSaeule) {
		this.dritteSaeule.set(newDritteSaeule);;
	}
	
	public String getDritteSaeule() {
		return dritteSaeule.get();
	}
	
	// Unerwartete Kosten
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
