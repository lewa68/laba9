package com.example.laba9fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Загрузка формы Перекидыватель слов
        loadScene(primaryStage, "word_shifter.fxml", "Word Shifter");

//        // Загрузка формы с виджетами и чекбоксами
//        loadScene(primaryStage, "/fxml/widget.fxml", "Widgets");
//
//        // Загрузка формы заказа в ресторане
//        loadScene(primaryStage, "/fxml/order.fxml", "Order");
//
//        // Загрузка формы калькулятора
//        loadScene(primaryStage, "/fxml/calculator.fxml", "Calculator");
//
//        // Загрузка формы Текстового флага
//        loadScene(primaryStage, "/fxml/text_flag.fxml", "Text Flag");
    }

    private void loadScene(Stage stage, String fxmlPath, String title) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}