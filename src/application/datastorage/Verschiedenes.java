
package application.datastorage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Verschiedenes implements FreierText {

  private StringProperty kostenGeplant;
  private StringProperty kostenEffektiv;
  private StringProperty internetNetflixMobile;
  private StringProperty schulgeld;
  private StringProperty kinderbetreuung;
  private StringProperty hobbysKinder;
  private StringProperty hobbysErwachsene;
  private StringProperty unerwarteteKosten;
  private StringProperty freierText;

  public Verschiedenes() {
    kostenGeplant = new SimpleStringProperty("");
    kostenEffektiv = new SimpleStringProperty("");
    internetNetflixMobile = new SimpleStringProperty("");
    schulgeld = new SimpleStringProperty("");
    kinderbetreuung = new SimpleStringProperty("");
    hobbysKinder = new SimpleStringProperty("");
    hobbysErwachsene = new SimpleStringProperty("");
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

  // Internet Netflix Mobile
  public StringProperty internetNetflixMobileProperty() {
    return internetNetflixMobile;
  }

  public void setInternetNetflixMobile(String newInternetNetflixMobile) {
    this.internetNetflixMobile.set(newInternetNetflixMobile);
  }

  public String getInternetNetflixMobile() {
    return internetNetflixMobile.get();
  }

  // Schulgeld
  public StringProperty schulgeldProperty() {
    return schulgeld;
  }

  public void setSchulgeld(String newSchulgeld) {
    this.schulgeld.set(newSchulgeld);
  }

  public String getSchulgeld() {
    return schulgeld.get();
  }

  // Kinderbetreuung
  public StringProperty kinderbetreuungProperty() {
    return kinderbetreuung;
  }

  public void setKinderbetreuung(String newKinderbetreuung) {
    this.kinderbetreuung.set(newKinderbetreuung);
  }

  public String getKinderbetreuung() {
    return kinderbetreuung.get();
  }

  // Hobbys Kinder
  public StringProperty hobbysKinderProperty() {
    return hobbysKinder;
  }

  public void setHobbysKinder(String newHobbysKinder) {
    this.hobbysKinder.set(newHobbysKinder);
  }

  public String getHobbysKinder() {
    return hobbysKinder.get();
  }

  // Hobbys Erwachsene
  public StringProperty hobbysErwachseneProperty() {
    return hobbysErwachsene;
  }

  public void setHobbysErwachsene(String newHobbysErwachsene) {
    this.hobbysErwachsene.set(newHobbysErwachsene);
  }

  public String getHobbysErwachsene() {
    return hobbysErwachsene.get();
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
