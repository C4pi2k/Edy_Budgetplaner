package application.datastorage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sparziel {
	
	private StringProperty sparzielGesamt;
	private StringProperty sparzielEffektiv;
	
	public Sparziel() {
		sparzielGesamt = new SimpleStringProperty("");
		sparzielEffektiv = new SimpleStringProperty("");
	}
	
	public StringProperty sparzielGesamtProperty() {
		return sparzielGesamt;
	}
	
	public void setSparzielGesamt(String newSparzielGesamt) {
		this.sparzielGesamt.set(newSparzielGesamt);;
	}
	
	public String getSparzielGesamt() {
		return sparzielGesamt.get();
	}
	
	public StringProperty sparzielEffektivProperty() {
		return sparzielEffektiv;
	}
	
	public void setSparzielEffektiv(String newSparzielEffektiv) {
		this.sparzielEffektiv.set(newSparzielEffektiv);;
	}
	
	public String getSparzielEffektiv() {
		return sparzielEffektiv.get();
	}

}
