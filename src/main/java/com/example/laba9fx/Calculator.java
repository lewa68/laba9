package com.example.laba9fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Calculator {

    @FXML
    private TextField display;

    private double firstOperand = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    @FXML
    public void handleDigitPress(ActionEvent event) {
        Button button = (Button) event.getSource();
        String digit = button.getText();
        if (startNewNumber) {
            display.setText(digit);
            startNewNumber = false;
        } else {
            display.setText(display.getText() + digit);
        }
    }

    @FXML
    public void handleOperatorPress(ActionEvent event) {
        Button button = (Button) event.getSource();
        if (!display.getText().isEmpty()) {
            firstOperand = Double.parseDouble(display.getText());
            operator = button.getText();
            startNewNumber = true;
        }
    }

    @FXML
    public void handleEqualsPress() {
        if (!display.getText().isEmpty() && !operator.isEmpty()) {
            double secondOperand = Double.parseDouble(display.getText());
            double result = 0;
            switch (operator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        result = firstOperand / secondOperand;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }
            display.setText(String.valueOf(result));
            startNewNumber = true;
            operator = "";
        }
    }

    @FXML
    public void handleClearPress() {
        display.clear();
        firstOperand = 0;
        operator = "";
        startNewNumber = true;
    }
}