package application.datastorage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EinnahmenGesamtNetto {
	
	private StringProperty einnahmenGesamtNetto;
	
	public EinnahmenGesamtNetto() {
		einnahmenGesamtNetto = new SimpleStringProperty("");
	}
	
	public StringProperty einnahmenGesamtNettoProperty() {
		return einnahmenGesamtNetto;
	}
	
	public void setEinnahmenGesamtNetto(String newEinnahmenGesamtNetto) {
		this.einnahmenGesamtNetto.set(newEinnahmenGesamtNetto);
	}
	
	public String getEinnahmenGesamtNetto() {
		return einnahmenGesamtNetto.get();
	}

}
