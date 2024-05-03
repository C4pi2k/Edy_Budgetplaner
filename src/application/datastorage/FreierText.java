/*
 * Copyright (c) 2024 Bison Schweiz AG, All Rights Reserved.
 */

package application.datastorage;

import javafx.beans.property.StringProperty;

/**
 * @author timo.capitelli
 */
public interface FreierText {

  public StringProperty freierTextProperty();

  public void setFreierText(String newFreierText);

  public String getFreierText();

}
