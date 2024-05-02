package application.datastorage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Steuern {
	
	private StringProperty steuernGesamt;
	
	public Steuern() {
		steuernGesamt = new SimpleStringProperty("");
	}
	
	// Steuern gesamt
	public StringProperty steuernGesamtProperty() {
		return steuernGesamt;
	}
	
	public void setSteuernGesamt(String newSteuernGesamt) {
		this.steuernGesamt.set(newSteuernGesamt);;
	}
	
	public String getSteuernGesamt() {
		return steuernGesamt.get();
	}

}
