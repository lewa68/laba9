package com.example.laba9fx;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class Widgets {

    @FXML
    private Label label1;

    @FXML
    private CheckBox checkBox1;

    @FXML
    private Label label2;

    @FXML
    private CheckBox checkBox2;

    @FXML
    private Label label3;

    @FXML
    private CheckBox checkBox3;

    @FXML
    public void initialize() {
        checkBox1.selectedProperty().addListener((observable, oldValue, newValue) -> label1.setVisible(newValue));
        checkBox2.selectedProperty().addListener((observable, oldValue, newValue) -> label2.setVisible(newValue));
        checkBox3.selectedProperty().addListener((observable, oldValue, newValue) -> label3.setVisible(newValue));
    }
}
