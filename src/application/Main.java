
package application;

import static application.Category.AUSGABEN_EC_ODER_KREDITKARTE;
import static application.Category.AUTO;
import static application.Category.EINNAHMEN_GESAMT_NETTO;
import static application.Category.FERIEN;
import static application.Category.SPARZIEL;
import static application.Category.STEUERN;
import static application.Category.TWINT;
import static application.Category.VERSCHIEDENES;
import static application.Category.VERSICHERUNG_UND_VORSORGE;
import static application.Category.WOHNKOSTEN;

import application.datastorage.DataStorage;
import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
  private static final String[] MONTHS = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
      "Dec" };
  private static final String[] WEEKS = new String[] { "Week 1", "Week 2", "Week 3", "Week 4" };
  private static final String[] WEEKDAYS = new String[] { "Mo", "Di", "Mi", "Do", "Fr", "Sa", "So" };
  private static final String[] VIEWS = new String[] { EINNAHMEN_GESAMT_NETTO.stringValue, SPARZIEL.stringValue, WOHNKOSTEN.stringValue,
      VERSICHERUNG_UND_VORSORGE.stringValue, TWINT.stringValue, AUTO.stringValue, VERSCHIEDENES.stringValue, STEUERN.stringValue,
      FERIEN.stringValue, AUSGABEN_EC_ODER_KREDITKARTE.stringValue };

  private Label displayField;
  private Label[] selectedLabels;
  private VBox inputFieldsContainer;
  private DataStorage[] appStorage;

  // AI Declaration for start
  // Pretty much the entirety of the start-method was written with the help of ChatGPT 3.5
  // To avoid learning the whole javaFX library, I instead worked with prompts which gradually stacked on top of each other.
  // Everything started with an input like "I need to display a bunch of buttons which a user can click" and this lead e.g. to the 4
  // addRow-method calls.
  // The only thing that was implemented completely by myself in this method (and throughout the whole app) was the implementation of my
  // "storage".
  // From the models to their usage in the app I did all by myself. Meaning I asked GPT 3.5 on how to display data and stuff, yet the actual
  // datamodels and how they would be used was done by me.
  @Override
  public void start(Stage primaryStage) {
    try {
      BorderPane root = new BorderPane();
      Scene scene = new Scene(root, 1600, 800);
      primaryStage.setScene(scene);

      // Create DataStorage instance (an instance for every combination of MONTHS x WEEKS x WEEKDAYS)
      appStorage = new DataStorage[336];
      initializeStorage();

      // Create VBox to hold rows
      VBox rowsContainer = new VBox();
      rowsContainer.setPadding(new Insets(10));
      rowsContainer.setSpacing(10);

      // Initialize selected labels array
      selectedLabels = new Label[4];

      // Add labels for each row
      addRow(rowsContainer, 0, MONTHS);
      addRow(rowsContainer, 1, WEEKS);
      addRow(rowsContainer, 2, WEEKDAYS);
      addRow(rowsContainer, 3, VIEWS);

      // Create input fields container
      inputFieldsContainer = new VBox();
      inputFieldsContainer.setPadding(new Insets(10));
      inputFieldsContainer.setSpacing(10);

      // Create display field
      displayField = new Label();
      displayField.setPadding(new Insets(10));

      // Add components to the root layout
      VBox registersAndDisplay = new VBox(rowsContainer, displayField, inputFieldsContainer);
      root.setTop(registersAndDisplay);

      primaryStage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // AI Declaration for initializeStorage
  // Written my myself. No AI-Support.

  // Initialization of the storage and their id's
  private void initializeStorage() {
    int position = 0;
    for (String month : MONTHS) {
      for (String week : WEEKS) {
        for (String weekday : WEEKDAYS) {
          appStorage[position] = new DataStorage(month, week, weekday, position);
          position++;
        }
      }
    }
  }

  // AI Declaration for addRow
  // Written by GPT 3.5, improved by me

  // Method to add registers to a row
  private void addRow(VBox container, int rowIndex, String[] labels) {
    HBox row = new HBox();
    row.setSpacing(10);
    row.setFillHeight(true);

    for (String label : labels) {
      Label register = createLabel(label);

      register.setOnMouseClicked(event -> {
        // Revert previously selected label to black
        if (selectedLabels[rowIndex] != null) {
          selectedLabels[rowIndex].setTextFill(Color.BLACK);
        }

        // Store the currently selected label
        selectedLabels[rowIndex] = register;

        // Change text color to red for selected label
        register.setTextFill(Color.RED);

        // Update input fields
        updateInputFields();
      });

      row.getChildren().add(register);
    }
    container.getChildren().add(row);
  }

  // AI Declaration for createLabel
  // Written by GPT 3.5

  // Method to create a label with initial style
  private Label createLabel(String text) {
    Label label = new Label(text);
    label.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 5px;");
    label.setFont(Font.font("Arial", 12));

    // Set initial text color to black
    label.setTextFill(Color.BLACK);

    return label;
  }

  // AI Declaration for updateInputFields
  // Mostly written by GPT 3.5. As mentioned in the AI Declaration for the start method, I created most of the method with GPT 3.5, yet the
  // handling of the data was made by myself.

  // Method to update input fields based on selected label
  private void updateInputFields() {
    // Clear input fields and labels
    inputFieldsContainer.getChildren().clear();

    // Add label displaying the selected label name (double size and bold)
    Label nameLabel = new Label(craftLabelWhenAllRowsSelected());
    nameLabel.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");
    inputFieldsContainer.getChildren().add(nameLabel);

    int dataStorageId = findCurrentDataStorageInstance();

    if (selectedLabels[3] != null) {
      if (selectedLabels[3].getText().equals(EINNAHMEN_GESAMT_NETTO.stringValue)) {
        addInputFieldWithLabel("Einnahmen gesamt (Netto) (Wert in CHF)",
            appStorage[dataStorageId].getEinnahmenGesamtNetto().einnahmenGesamtNettoProperty());
      } else if (selectedLabels[3].getText().equals(SPARZIEL.stringValue)) {
        addInputFieldWithLabel("Sparziel gesamt (Wert in CHF)", appStorage[dataStorageId].getSparziel().sparzielGesamtProperty());
        addInputFieldWithLabel("Sparziel effektiv (Wert in CHF)", appStorage[dataStorageId].getSparziel().sparzielEffektivProperty());
      } else if (selectedLabels[3].getText().equals(WOHNKOSTEN.stringValue)) {
        addInputFieldWithLabel("Kosten geplant (Wert in CHF)", appStorage[dataStorageId].getWohnkosten().kostenGeplantProperty());
        addInputFieldWithLabel("Kosten Wohnen effektiv (Wert in CHF)", appStorage[dataStorageId].getWohnkosten().kostenEffektivProperty());
        addInputFieldWithLabel("Wohn- und Nebenkosten (Wert in CHF)",
            appStorage[dataStorageId].getWohnkosten().wohnUndNebenkostenProperty());
        addInputFieldWithLabel("Unerwartete Kosten (Wert in CHF)", appStorage[dataStorageId].getWohnkosten().unerwarteteKostenProperty());
        addTwentyCharInputField(appStorage[dataStorageId].getAusgabenECOderKreditkarte().freierTextProperty());
      } else if (selectedLabels[3].getText().equals(VERSICHERUNG_UND_VORSORGE.stringValue)) {
        addInputFieldWithLabel("Kosten geplant (Wert in CHF)",
            appStorage[dataStorageId].getVersicherungUndVorsorge().kostenGeplantProperty());
        addInputFieldWithLabel("Kosten effektiv (Wert in CHF)",
            appStorage[dataStorageId].getVersicherungUndVorsorge().kostenEffektivProperty());
        addInputFieldWithLabel("Krankenversicherung (Wert in CHF)",
            appStorage[dataStorageId].getVersicherungUndVorsorge().krankenVersicherungProperty());
        addInputFieldWithLabel("Hausrat-, Hatfpflicht-, Rechtschutzversicherung (Wert in CHF)",
            appStorage[dataStorageId].getVersicherungUndVorsorge().hausratHatfpflichtRechtschutzversicherungProperty());
        addInputFieldWithLabel("3. Saeule (Wert in CHF)", appStorage[dataStorageId].getVersicherungUndVorsorge().dritteSaeuleProperty());
        addInputFieldWithLabel("Unerwartete Kosten (Wert in CHF)",
            appStorage[dataStorageId].getVersicherungUndVorsorge().unerwarteteKostenProperty());
        addTwentyCharInputField(appStorage[dataStorageId].getAusgabenECOderKreditkarte().freierTextProperty());
      } else if (selectedLabels[3].getText().equals(TWINT.stringValue)) {
        addInputFieldWithLabel("Kosten geplant (Wert in CHF)", appStorage[dataStorageId].getTwint().kostenGeplantProperty());
        addInputFieldWithLabel("Kosten effektiv (Wert in CHF)", appStorage[dataStorageId].getTwint().kostenEffektivProperty());
        addInputFieldWithLabel("Ueberweisung Person A (Wert in CHF)", appStorage[dataStorageId].getTwint().ueberweisungPersonAProperty());
        addInputFieldWithLabel("Ueberweisung Person B (Wert in CHF)", appStorage[dataStorageId].getTwint().ueberweisungPersonBProperty());
      } else if (selectedLabels[3].getText().equals(AUTO.stringValue)) {
        addInputFieldWithLabel("Kosten geplant (Wert in CHF)", appStorage[dataStorageId].getAuto().kostenGeplantProperty());
        addInputFieldWithLabel("Kosten effektiv (Wert in CHF)", appStorage[dataStorageId].getAuto().kostenEffektivProperty());
        addInputFieldWithLabel("Reparatur, Versicherung (Wert in CHF)",
            appStorage[dataStorageId].getAuto().reparaturVersicherungProperty());
        addInputFieldWithLabel("Unerwartete Kosten (Wert in CHF)", appStorage[dataStorageId].getAuto().unerwarteteKostenProperty());
        addTwentyCharInputField(appStorage[dataStorageId].getAusgabenECOderKreditkarte().freierTextProperty());
      } else if (selectedLabels[3].getText().equals(VERSCHIEDENES.stringValue)) {
        addInputFieldWithLabel("Kosten geplant (Wert in CHF)", appStorage[dataStorageId].getVerschiedenes().kostenGeplantProperty());
        addInputFieldWithLabel("Kosten effektiv (Wert in CHF)", appStorage[dataStorageId].getVerschiedenes().kostenEffektivProperty());
        addInputFieldWithLabel("Internet, Netflix, Mobile (Wert in CHF)",
            appStorage[dataStorageId].getVerschiedenes().internetNetflixMobileProperty());
        addInputFieldWithLabel("Schulgeld (Wert in CHF)", appStorage[dataStorageId].getVerschiedenes().schulgeldProperty());
        addInputFieldWithLabel("Kinderbetreuung, Putzfrau (Wert in CHF)",
            appStorage[dataStorageId].getVerschiedenes().kinderbetreuungProperty());
        addInputFieldWithLabel("Hobbys Kinder (Wert in CHF)", appStorage[dataStorageId].getVerschiedenes().hobbysKinderProperty());
        addInputFieldWithLabel("Hobbys Erwachsene (Wert in CHF)", appStorage[dataStorageId].getVerschiedenes().hobbysErwachseneProperty());
        addInputFieldWithLabel("Unerwartete Kosten (Wert in CHF)",
            appStorage[dataStorageId].getVerschiedenes().unerwarteteKostenProperty());
        addTwentyCharInputField(appStorage[dataStorageId].getAusgabenECOderKreditkarte().freierTextProperty());
      } else if (selectedLabels[3].getText().equals(STEUERN.stringValue)) {
        addInputFieldWithLabel("Steuern gesamt (Wert in CHF)", appStorage[dataStorageId].getSteuern().steuernGesamtProperty());
      } else if (selectedLabels[3].getText().equals(FERIEN.stringValue)) {
        addInputFieldWithLabel("Kosten geplant (Wert in CHF)", appStorage[dataStorageId].getFerien().kostenGeplantProperty());
        addInputFieldWithLabel("Kosten effektiv (Wert in CHF)", appStorage[dataStorageId].getFerien().kostenEffektivProperty());
        addInputFieldWithLabel("Unterkunft (Wert in CHF)", appStorage[dataStorageId].getFerien().unterkunftProperty());
        addInputFieldWithLabel("Ausfluege, Essen, Diverses (Wert in CHF)",
            appStorage[dataStorageId].getFerien().ausfluegeEssenDiversesProperty());
        addInputFieldWithLabel("Unerwartete Kosten (Wert in CHF)", appStorage[dataStorageId].getFerien().unerwarteteKostenProperty());
        addTwentyCharInputField(appStorage[dataStorageId].getAusgabenECOderKreditkarte().freierTextProperty());
      } else if (selectedLabels[3].getText().equals(AUSGABEN_EC_ODER_KREDITKARTE.stringValue)) {
        addInputFieldWithLabel("Kosten geplant (Wert in CHF)",
            appStorage[dataStorageId].getAusgabenECOderKreditkarte().kostenGeplantProperty());
        addInputFieldWithLabel("Kosten effektiv (Wert in CHF)",
            appStorage[dataStorageId].getAusgabenECOderKreditkarte().kostenEffektivProperty());
        addInputFieldWithLabel("Unerwartete Rechnungen (Wert in CHF)",
            appStorage[dataStorageId].getAusgabenECOderKreditkarte().unerwarteteRechnungenProperty());
        addInputFieldWithLabel("Unerwartete Kosten (Wert in CHF)",
            appStorage[dataStorageId].getAusgabenECOderKreditkarte().unerwarteteKostenProperty());
        addTwentyCharInputField(appStorage[dataStorageId].getAusgabenECOderKreditkarte().freierTextProperty());
      }
    }
  }

  // AI Declaration for craftLabelWhenAllRowsSelected
  // Written by me

  private String craftLabelWhenAllRowsSelected() {
    if (selectedLabels[0] != null && selectedLabels[1] != null && selectedLabels[2] != null && selectedLabels[3] != null) {
      return selectedLabels[0].getText() + " " + selectedLabels[1].getText() + " " + selectedLabels[2].getText() + " "
          + selectedLabels[3].getText();
    } else {
      return "";
    }
  }

  // AI Declaration for findCurrentDataStorageInstance
  // Written by me

  // Method to handle the current combination of buttons selected and loading the actual dataset
  private int findCurrentDataStorageInstance() {
    DataStorage currentDataStorage = new DataStorage("", "", "", 0);
    if (selectedLabels[0] == null || selectedLabels[1] == null || selectedLabels[2] == null || selectedLabels[3] == null) {
      return 0;
    }
    for (DataStorage dataStorage : appStorage) {
      if (dataStorage.getId()[0].equals(selectedLabels[0].getText()) && //
          dataStorage.getId()[1].equals(selectedLabels[1].getText()) && //
          dataStorage.getId()[2].equals(selectedLabels[2].getText())) {
        currentDataStorage = dataStorage;
      }
    }
    return currentDataStorage.getPosition();
  }

  // AI Declaration for addInputFieldWithLabel
  // Written by GPT 3.5, improved by me

  // Method to add an input field with label to the input fields container
  private void addInputFieldWithLabel(String labelText, StringProperty property) {
    Label label = new Label(labelText);
    TextField textField = new TextField("");
    textField.textProperty().bindBidirectional(property);
    inputFieldsContainer.getChildren().addAll(label, textField);
  }

  // AI Declaration for addTwentyCharInputField
  // Written by me

  // Method to create inputfields that only measure twenty characters at max
  private void addTwentyCharInputField(StringProperty property) {
    TextField textField = new TextField("");
    textField.textProperty().bindBidirectional(property);
    addTextLimiter(textField);
    inputFieldsContainer.getChildren().addAll(textField);
  }

  // AI Declaration for addTextLimiter
  // Written by GPT 3.5, improved by me

  //
  public void addTextLimiter(final TextField textField) {
    textField.textProperty().addListener(new ChangeListener<String>() {
      int maxLength = 20;

      @Override
      public void changed(ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
        if (textField.getText().length() > maxLength) {
          String userInputString = textField.getText().substring(0, maxLength);
          textField.setText(userInputString);
        }
      }
    });
  }

  // AI Declaration for main
  // Written by GPT 3.5

  //
  public static void main(String[] args) {
    launch(args);
  }
}
