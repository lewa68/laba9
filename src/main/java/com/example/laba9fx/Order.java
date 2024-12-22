package com.example.laba9fx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

import java.text.DecimalFormat;

public class Order {

    @FXML
    private VBox orderItemsContainer;

    @FXML
    private TextArea orderSummary;

    private ObservableList<OrderItem> orderItems = FXCollections.observableArrayList(
            new OrderItem("Pizza", 10.0),
            new OrderItem("Burger", 8.0),
            new OrderItem("Salad", 5.0)
    );

    @FXML
    public void initialize() {
        for (OrderItem item : orderItems) {
            HBox hbox = new HBox(10);
            CheckBox checkBox = new CheckBox(item.getName());
            Spinner<Integer> spinner = new Spinner<>(1, 10, 1);

            checkBox.setOnAction(event -> updateOrderSummary());

            spinner.valueProperty().addListener((observable, oldValue, newValue) -> {
                item.setQuantity(newValue);
                updateOrderSummary();
            });

            hbox.getChildren().addAll(checkBox, spinner);
            orderItemsContainer.getChildren().add(hbox);
        }
        updateOrderSummary();
    }

    private void updateOrderSummary() {
        double totalCost = 0.0;
        StringBuilder summaryBuilder = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.00");

        for (OrderItem item : orderItems) {
            if (item.getCheckBox().isSelected()) {
                double cost = item.getPrice() * item.getQuantity();
                summaryBuilder.append(item.getName()).append(" x ").append(item.getQuantity())
                        .append(": $").append(df.format(cost)).append("\n");
                totalCost += cost;
            }
        }

        summaryBuilder.append("Total Cost: $").append(df.format(totalCost));
        orderSummary.setText(summaryBuilder.toString());
    }

    public static class OrderItem {
        private final String name;
        private final double price;
        private int quantity;
        private CheckBox checkBox;

        public OrderItem(String name, double price) {
            this.name = name;
            this.price = price;
            this.quantity = 1;
            this.checkBox = new CheckBox(name);
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }
    }
}
