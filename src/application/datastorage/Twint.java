package application.datastorage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Twint {
	
	private StringProperty kostenGeplant;
	private StringProperty kostenEffektiv;
	private StringProperty ueberweisungPersonA;
	private StringProperty ueberweisungPersonB;
	
	public Twint() {
		kostenGeplant = new SimpleStringProperty("");
		kostenEffektiv = new SimpleStringProperty("");
		ueberweisungPersonA = new SimpleStringProperty("");
		ueberweisungPersonB = new SimpleStringProperty("");
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
	
	// Ueberweisung Person A
	public StringProperty ueberweisungPersonAProperty() {
		return ueberweisungPersonA;
	}
	
	public void setUeberweisungPersonA(String newUeberweisungPersonA) {
		this.ueberweisungPersonA.set(newUeberweisungPersonA);;
	}
	
	public String getUeberweisungPersonA() {
		return ueberweisungPersonA.get();
	}
	
	// Ueberweisung Person B
	public StringProperty ueberweisungPersonBProperty() {
		return ueberweisungPersonB;
	}
	
	public void setUeberweisungPersonB(String newUeberweisungPersonB) {
		this.ueberweisungPersonB.set(newUeberweisungPersonB);;
	}
	
	public String getUeberweisungPersonB() {
		return ueberweisungPersonB.get();
	}

}
