
package application.datastorage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ferien implements FreierText {

  private StringProperty kostenGeplant;
  private StringProperty kostenEffektiv;
  private StringProperty unterkunft;
  private StringProperty ausfluegeEssenDiverses;
  private StringProperty unerwarteteKosten;
  private StringProperty freierText;

  public Ferien() {
    kostenGeplant = new SimpleStringProperty("");
    kostenEffektiv = new SimpleStringProperty("");
    unterkunft = new SimpleStringProperty("");
    ausfluegeEssenDiverses = new SimpleStringProperty("");
    unerwarteteKosten = new SimpleStringProperty("");
    freierText = new SimpleStringProperty("");
  }

  // Kosten geplant
  public StringProperty kostenGeplantProperty() {
    return kostenGeplant;
  }

  public void setKostenGeplant(String newKostenGeplant) {
    this.kostenGeplant.set(newKostenGeplant);
  }

  public String getKostenGeplant() {
    return kostenGeplant.get();
  }

  // Kosten effektiv
  public StringProperty kostenEffektivProperty() {
    return kostenEffektiv;
  }

  public void setKostenEffektiv(String newKostenEffektiv) {
    this.kostenEffektiv.set(newKostenEffektiv);
  }

  public String getKostenEffektiv() {
    return kostenEffektiv.get();
  }

  // Unterkunft
  public StringProperty unterkunftProperty() {
    return unterkunft;
  }

  public void setUnterkunft(String newUnterkunft) {
    this.unterkunft.set(newUnterkunft);
  }

  public String getUnterkunft() {
    return unterkunft.get();
  }

  // Ausfluege Essen Diverses
  public StringProperty ausfluegeEssenDiversesProperty() {
    return ausfluegeEssenDiverses;
  }

  public void setAusfluegeEssenDiverses(String newAusfluegeEssenDiverses) {
    this.ausfluegeEssenDiverses.set(newAusfluegeEssenDiverses);
  }

  public String getAusfluegeEssenDiverses() {
    return ausfluegeEssenDiverses.get();
  }

  // Unerwartete Kosten
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
