package application.datastorage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Wohnkosten {
	
	private StringProperty kostenGeplant;
	private StringProperty kostenEffektiv;
	private StringProperty wohnUndNebenkosten;
	private StringProperty unerwarteteKosten;
	private StringProperty freierText;
	
	public Wohnkosten() {
		kostenGeplant = new SimpleStringProperty("");
		kostenEffektiv = new SimpleStringProperty("");
		wohnUndNebenkosten = new SimpleStringProperty("");
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
	
	// Wohn- und Nebenkosten
	public StringProperty wohnUndNebenkostenProperty() {
		return wohnUndNebenkosten;
	}
	
	public void setWohnUndNebenkosten(String newWohnUndNebenkosten) {
		this.wohnUndNebenkosten.set(newWohnUndNebenkosten);;
	}
	
	public String getWohnUndNebenkosten() {
		return wohnUndNebenkosten.get();
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
