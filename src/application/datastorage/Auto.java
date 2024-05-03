
package application.datastorage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Auto implements FreierText {

  private StringProperty kostenGeplant;
  private StringProperty kostenEffektiv;
  private StringProperty reparaturVersicherung;
  private StringProperty unerwarteteKosten;
  private StringProperty freierText;

  public Auto() {
    kostenGeplant = new SimpleStringProperty("");
    kostenEffektiv = new SimpleStringProperty("");
    reparaturVersicherung = new SimpleStringProperty("");
    unerwarteteKosten = new SimpleStringProperty("");
    freierText = new SimpleStringProperty("");
  }

  public StringProperty kostenGeplantProperty() {
    return kostenGeplant;
  }

  public void setKostenGeplant(String newKostenGeplant) {
    this.kostenGeplant.set(newKostenGeplant);
  }

  public String getKostenGeplant() {
    return kostenGeplant.get();
  }

  public StringProperty kostenEffektivProperty() {
    return kostenEffektiv;
  }

  public void setKostenEffektiv(String newKostenEffektiv) {
    this.kostenEffektiv.set(newKostenEffektiv);
  }

  public String getKostenEffektiv() {
    return kostenEffektiv.get();
  }

  public StringProperty reparaturVersicherungProperty() {
    return unerwarteteKosten;
  }

  public void setReparaturVersicherung(String newReparaturVersicherung) {
    this.reparaturVersicherung.set(newReparaturVersicherung);
  }

  public String getReparaturVersicherungProperty() {
    return reparaturVersicherung.get();
  }

  public StringProperty unerwarteteKostenProperty() {
    return unerwarteteKosten;
  }

  public void setUnerwarteteKosten(String newUnerwarteteKosten) {
    this.unerwarteteKosten.set(newUnerwarteteKosten);
  }

  public String getUnerwarteteKosten() {
    return unerwarteteKosten.get();
  }

  // Freier Text
  @Override
  public StringProperty freierTextProperty() {
    return freierText;
  }

  @Override
  public void setFreierText(String newFreierText) {
    this.freierText.set(newFreierText);
  }

  @Override
  public String getFreierText() {
    return freierText.get();
  }

}
