package application;


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
	private static final String[] MONTHS = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	private static final String[] WEEKS = new String[]{"Week 1", "Week 2", "Week 3", "Week 4"};
	private static final String[] WEEKDAYS = new String[]{"Mo", "Di", "Mi", "Do", "Fr", "Sa", "So"};
	private static final String[] VIEWS = new String[]{Category.EINNAHMEN_GESAMT_NETTO.label, Category.SPARZIEL.label, Category.WOHNKOSTEN.label, Category.VERSICHERUNG_UND_VORSORGE.label, Category.TWINT.label, Category.AUTO.label, Category.VERSCHIEDENES.label, Category.STEUERN.label, Category.FERIEN.label, Category.AUSGABEN_EC_ODER_KREDITKARTE.label};
	
	private Label displayField;
    private Label[] selectedLabels;
    private VBox inputFieldsContainer;
    private DataStorage[] appStorage;

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 1600, 800);
            primaryStage.setScene(scene);
            
            // Create DataStorage instance
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

    private void initializeStorage() {
    	int position = 0;
    	for(String month : MONTHS) {
    		for(String week : WEEKS) {
    			for(String weekday : WEEKDAYS) {
    				appStorage[position] = new DataStorage(month, week, weekday, position);
    				position++;
    			}
    		}
    	}
	}

	// Method to add registers to a row
    private void addRow(VBox container, int rowIndex, String[] labels) {
        HBox row = new HBox();
        row.setSpacing(10);
        row.setFillHeight(true);

        for (String label : labels) {
            Label register = createLabel(label);
            final int colIndex = row.getChildren().size(); // Column index of this label

            register.setOnMouseClicked(event -> {
                // Revert previously selected label to black
                if (selectedLabels[rowIndex] != null) {
                    selectedLabels[rowIndex].setTextFill(Color.BLACK);
                }

                // Store the currently selected label
                selectedLabels[rowIndex] = register;

                // Change text color to red for selected label
                register.setTextFill(Color.RED);

                // Update the display field
                updateDisplayField();

                // Update input fields 
                updateInputFields();
            });

            row.getChildren().add(register);
        }
        container.getChildren().add(row);
    }

    // Method to create a label with initial style
    private Label createLabel(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 5px;");
        label.setFont(Font.font("Arial", 12));

        // Set initial text color to black
        label.setTextFill(Color.BLACK);

        return label;
    }

    // Method to update the display field based on selected labels
    private void updateDisplayField() {
        StringBuilder textBuilder = new StringBuilder();

        // Check if at least one label is selected from each row
        boolean allRowsSelected = true;
        for (Label label : selectedLabels) {
            if (label == null) {
                allRowsSelected = false;
                break;
            }
        }

        // If all rows are selected, concatenate the text from selected labels
        if (allRowsSelected) {
            for (Label label : selectedLabels) {
                textBuilder.append(label.getText()).append(" ");
            }
        } else {
            textBuilder.append("Select one label from each row...");
        }

        // Update the display field
        displayField.setText(textBuilder.toString());
    }

    // Method to update input fields based on selected label
    private void updateInputFields() {
    	// Clear input fields and labels 
    	inputFieldsContainer.getChildren().clear(); 

    	// Add label displaying the selected label name (double size and bold)
    	Label nameLabel = new Label(craftLabelWhenAllRowsSelected());
    	nameLabel.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");
    	inputFieldsContainer.getChildren().add(nameLabel);
	            
    	int dataStorageId = findCurrentDataStorageInstance();
            
    	if(selectedLabels[3] != null) {
    	if (selectedLabels[3].getText().equals(Category.EINNAHMEN_GESAMT_NETTO.label)) {
    		addInputFieldWithLabel("Einnahmen gesamt (Netto):", "Input 2", appStorage[dataStorageId].getEinnahmenGesamtNetto().einnahmenGesamtNettoProperty());
    	} else if (selectedLabels[3].getText().equals(Category.SPARZIEL.label)) {
    		addInputFieldWithLabel("Sparziel gesamt", "Input 1", appStorage[dataStorageId].getSparziel().sparzielGesamtProperty());
    		addInputFieldWithLabel("Sparziel effektiv", "Input 2", appStorage[dataStorageId].getSparziel().sparzielEffektivProperty());
    	} else if (selectedLabels[3].getText().equals(Category.WOHNKOSTEN.label)) {
    		addInputFieldWithLabel("Kosten geplant", "Input 1", appStorage[dataStorageId].getWohnkosten().kostenGeplantProperty());
    		addInputFieldWithLabel("Kosten Wohnen effektiv", "Input 2", appStorage[dataStorageId].getWohnkosten().kostenEffektivProperty());
    		addInputFieldWithLabel("Wohn- und Nebenkosten", "Input 3", appStorage[dataStorageId].getWohnkosten().wohnUndNebenkostenProperty());
    		addInputFieldWithLabel("Unerwartete Kosten", "Input 4", appStorage[dataStorageId].getWohnkosten().unerwarteteKostenProperty());
    		addTwentyCharInputField(appStorage[dataStorageId].getAusgabenECOderKreditkarte().freierTextProperty());
    	} else if (selectedLabels[3].getText().equals(Category.VERSICHERUNG_UND_VORSORGE.label)) {
    		addInputFieldWithLabel("Kosten geplant", "Input 1", appStorage[dataStorageId].getVersicherungUndVorsorge().kostenGeplantProperty());
    		addInputFieldWithLabel("Kosten effektiv", "Input 2", appStorage[dataStorageId].getVersicherungUndVorsorge().kostenEffektivProperty());
    		addInputFieldWithLabel("Krankenversicherung", "Input 3", appStorage[dataStorageId].getVersicherungUndVorsorge().krankenVersicherungProperty());
    		addInputFieldWithLabel("Hausrat-, Hatfpflicht-, Rechtschutzversicherung", "Input 4", appStorage[dataStorageId].getVersicherungUndVorsorge().hausratHatfpflichtRechtschutzversicherungProperty());
    		addInputFieldWithLabel("3. Säule", "Input 5", appStorage[dataStorageId].getVersicherungUndVorsorge().dritteSaeuleProperty());
    		addInputFieldWithLabel("Unerwartete Kosten", "Input 6", appStorage[dataStorageId].getVersicherungUndVorsorge().unerwarteteKostenProperty());
    		addTwentyCharInputField(appStorage[dataStorageId].getAusgabenECOderKreditkarte().freierTextProperty());
    	} else if (selectedLabels[3].getText().equals(Category.TWINT.label)) {
    		addInputFieldWithLabel("Kosten geplant", "Input 1", appStorage[dataStorageId].getTwint().kostenGeplantProperty());
    		addInputFieldWithLabel("Kosten effektiv", "Input 2", appStorage[dataStorageId].getTwint().kostenEffektivProperty());
    		addInputFieldWithLabel("Ueberweisung Person A", "Input 3", appStorage[dataStorageId].getTwint().ueberweisungPersonAProperty());
    		addInputFieldWithLabel("Ueberweisung Person B", "Input 4", appStorage[dataStorageId].getTwint().ueberweisungPersonBProperty());
    	} else if (selectedLabels[3].getText().equals(Category.AUTO.label)) {
    		addInputFieldWithLabel("Kosten geplant", "Input 1", appStorage[dataStorageId].getAuto().kostenGeplantProperty());
    		addInputFieldWithLabel("Kosten effektiv", "Input 2", appStorage[dataStorageId].getAuto().kostenEffektivProperty());
    		addInputFieldWithLabel("Reparatur, Versicherung", "Input 3", appStorage[dataStorageId].getAuto().reparaturVersicherungProperty());
    		addInputFieldWithLabel("Unerwartete Kosten", "Input 4", appStorage[dataStorageId].getAuto().unerwarteteKostenProperty());
    		addTwentyCharInputField(appStorage[dataStorageId].getAusgabenECOderKreditkarte().freierTextProperty());
    	} else if (selectedLabels[3].getText().equals(Category.VERSCHIEDENES.label)) {
    		addInputFieldWithLabel("Kosten geplant", "Input 1", appStorage[dataStorageId].getVerschiedenes().kostenGeplantProperty());
    		addInputFieldWithLabel("Kosten effektiv", "Input 2", appStorage[dataStorageId].getVerschiedenes().kostenEffektivProperty());
    		addInputFieldWithLabel("Internet, Netflix, Mobile", "Input 3", appStorage[dataStorageId].getVerschiedenes().internetNetflixMobileProperty());
    		addInputFieldWithLabel("Schulgeld", "Input 4", appStorage[dataStorageId].getVerschiedenes().schulgeldProperty());
    		addInputFieldWithLabel("Kinderbetreuung, Putzfrau", "Input 5", appStorage[dataStorageId].getVerschiedenes().kinderbetreuungProperty());
    		addInputFieldWithLabel("Hobbys Kinder", "Input 6", appStorage[dataStorageId].getVerschiedenes().hobbysKinderProperty());
    		addInputFieldWithLabel("Hobbys Erwachsene", "Input 7", appStorage[dataStorageId].getVerschiedenes().hobbysErwachseneProperty());
    		addInputFieldWithLabel("Unerwartete Kosten", "Input 8", appStorage[dataStorageId].getVerschiedenes().unerwarteteKostenProperty());
    		addTwentyCharInputField(appStorage[dataStorageId].getAusgabenECOderKreditkarte().freierTextProperty());
    	} else if (selectedLabels[3].getText().equals(Category.STEUERN.label)) {
    		addInputFieldWithLabel("Steuern gesamt", "Input 1", appStorage[dataStorageId].getSteuern().steuernGesamtProperty());
    	} else if (selectedLabels[3].getText().equals(Category.FERIEN.label)) {
    		addInputFieldWithLabel("Kosten geplant", "Input 1", appStorage[dataStorageId].getFerien().kostenGeplantProperty());
    		addInputFieldWithLabel("Kosten effektiv", "Input 2", appStorage[dataStorageId].getFerien().kostenEffektivProperty());
    		addInputFieldWithLabel("Unterkunft", "Input 3", appStorage[dataStorageId].getFerien().unterkunftProperty());
    		addInputFieldWithLabel("Ausfluege, Essen, Diverses", "Input 4", appStorage[dataStorageId].getFerien().ausfluegeEssenDiversesProperty());
    		addInputFieldWithLabel("Unerwartete Kosten", "Input 5", appStorage[dataStorageId].getFerien().unerwarteteKostenProperty());
    		addTwentyCharInputField(appStorage[dataStorageId].getAusgabenECOderKreditkarte().freierTextProperty());
    	} else if (selectedLabels[3].getText().equals(Category.AUSGABEN_EC_ODER_KREDITKARTE.label)) {
    		addInputFieldWithLabel("Kosten geplant", "Input 1", appStorage[dataStorageId].getAusgabenECOderKreditkarte().kostenGeplantProperty());
    		addInputFieldWithLabel("Kosten effektiv", "Input 2", appStorage[dataStorageId].getAusgabenECOderKreditkarte().kostenEffektivProperty());
    		addInputFieldWithLabel("Unerwartete Rechnungen", "Input 3", appStorage[dataStorageId].getAusgabenECOderKreditkarte().unerwarteteRechnungenProperty());
    		addInputFieldWithLabel("Unerwartete Kosten", "Input 4", appStorage[dataStorageId].getAusgabenECOderKreditkarte().unerwarteteKostenProperty());
    		addTwentyCharInputField(appStorage[dataStorageId].getAusgabenECOderKreditkarte().freierTextProperty());
    	}
    	}
    }

	private String craftLabelWhenAllRowsSelected() {
		if (selectedLabels[0] != null && selectedLabels[1] != null && selectedLabels[2] != null && selectedLabels[3] != null) {
			return selectedLabels[0].getText() + " " + selectedLabels[1].getText() + " " + selectedLabels[2].getText() + " " + selectedLabels[3].getText(); 
		} else {
			return "";
		}
	}

	private int findCurrentDataStorageInstance() {
		DataStorage currentDataStorage = new DataStorage("", "", "", 0);
		if(selectedLabels[0] == null || selectedLabels[1] == null || selectedLabels[2] == null || selectedLabels[3] == null) {
			return 0;
		}
    	for(DataStorage dataStorage : appStorage) {
    		if(dataStorage.getId()[0].equals(selectedLabels[0].getText()) && //
    		   dataStorage.getId()[1].equals(selectedLabels[1].getText()) && //
    		   dataStorage.getId()[2].equals(selectedLabels[2].getText())) {
    			currentDataStorage = dataStorage;
    		}
    	}
    	return currentDataStorage.getPosition();
    }

	// Method to add an input field with label to the input fields container
    private void addInputFieldWithLabel(String labelText, String inputPrompt, StringProperty property) {
        Label label = new Label(labelText);
        TextField textField = new TextField("");
        textField.setPromptText(inputPrompt);
        textField.textProperty().bindBidirectional(property);
        inputFieldsContainer.getChildren().addAll(label, textField);
    }
    
    private void addTwentyCharInputField(StringProperty property) {
        TextField textField = new TextField("");
        textField.textProperty().bindBidirectional(property);
        addTextLimiter(textField);
        inputFieldsContainer.getChildren().addAll(textField);
    }
    
    public void addTextLimiter(final TextField textField) {
    	textField.textProperty().addListener(new ChangeListener<String>() {
    		int maxLength = 20;
    		@Override
    		public void changed(ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
    			if (textField.getText().length() > maxLength) {
    				String s = textField.getText().substring(0, maxLength);
    				textField.setText(s);
    			}
    		}
    	});
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
