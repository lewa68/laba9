package com.example.laba9fx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class WordShifter {

    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    @FXML
    private Button swapButton;

    private boolean isSwapped = false;

    @FXML
    public void handleSwapButtonAction() {
        if (!isSwapped) {
            textField2.setText(textField1.getText());
            textField1.clear();
            swapButton.setText("<--");
        } else {
            textField1.setText(textField2.getText());
            textField2.clear();
            swapButton.setText("-->");
        }
        isSwapped = !isSwapped;
    }
}
