package com.example.laba9fx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TextFlag {

    @FXML
    private RadioButton redTop;
    @FXML
    private RadioButton greenTop;
    @FXML
    private RadioButton blueTop;
    @FXML
    private RadioButton whiteTop;
    @FXML
    private RadioButton yellowTop;

    @FXML
    private RadioButton redMiddle;
    @FXML
    private RadioButton greenMiddle;
    @FXML
    private RadioButton blueMiddle;
    @FXML
    private RadioButton whiteMiddle;
    @FXML
    private RadioButton yellowMiddle;

    @FXML
    private RadioButton redBottom;
    @FXML
    private RadioButton greenBottom;
    @FXML
    private RadioButton blueBottom;
    @FXML
    private RadioButton whiteBottom;
    @FXML
    private RadioButton yellowBottom;

    @FXML
    private Button drawButton;

    @FXML
    private ToggleGroup topStrip;
    @FXML
    private ToggleGroup middleStrip;
    @FXML
    private ToggleGroup bottomStrip;

    @FXML
    public void initialize() {
        topStrip = new ToggleGroup();
        redTop.setToggleGroup(topStrip);
        greenTop.setToggleGroup(topStrip);
        blueTop.setToggleGroup(topStrip);
        whiteTop.setToggleGroup(topStrip);
        yellowTop.setToggleGroup(topStrip);
        redTop.setSelected(true);

        middleStrip = new ToggleGroup();
        redMiddle.setToggleGroup(middleStrip);
        greenMiddle.setToggleGroup(middleStrip);
        blueMiddle.setToggleGroup(middleStrip);
        whiteMiddle.setToggleGroup(middleStrip);
        yellowMiddle.setToggleGroup(middleStrip);
        greenMiddle.setSelected(true);

        bottomStrip = new ToggleGroup();
        redBottom.setToggleGroup(bottomStrip);
        greenBottom.setToggleGroup(bottomStrip);
        blueBottom.setToggleGroup(bottomStrip);
        whiteBottom.setToggleGroup(bottomStrip);
        yellowBottom.setToggleGroup(bottomStrip);
        blueBottom.setSelected(true);

        drawButton.setOnAction(event -> {
            RadioButton topSelected = (RadioButton) topStrip.getSelectedToggle();
            RadioButton middleSelected = (RadioButton) middleStrip.getSelectedToggle();
            RadioButton bottomSelected = (RadioButton) bottomStrip.getSelectedToggle();

            if (topSelected != null && middleSelected != null && bottomSelected != null) {
                String message = topSelected.getText() + ", " + middleSelected.getText() + ", " + bottomSelected.getText();
                showAlert(message);
            } else {
                showAlert("Please select colors for all strips.");
            }
        });
    }

    private void showAlert(String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Flag Colors");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}