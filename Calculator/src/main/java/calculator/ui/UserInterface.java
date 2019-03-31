package calculator.ui;

import calculator.domain.Calculus;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class UserInterface extends Application {

    static boolean limit = false;

    @Override
    public void start(Stage stage) throws Exception {
        Calculus calculator = new Calculus();

        BorderPane mainLayout = new BorderPane();
        mainLayout.setPrefSize(400, 400);

        Label screen = new Label("");

        screen.setScaleX(2);
        screen.setScaleY(2);

        StackPane top = new StackPane();
        top.getChildren().add(screen);
        top.setPrefHeight(100);

        GridPane grid = new GridPane();

        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        Button button5 = new Button("5");
        Button button6 = new Button("6");
        Button button7 = new Button("7");
        Button button8 = new Button("8");
        Button button9 = new Button("9");
        Button button0 = new Button("0");
        Button plusButton = new Button("+");
        Button minusButton = new Button("-");
        Button multiButton = new Button("*");
        Button divButton = new Button("/");
        Button equalButton = new Button("=");
        Button cButton = new Button("C");
        Button emptyButton = new Button();

        grid.add(button7, 1, 1);
        grid.add(button8, 2, 1);
        grid.add(button9, 3, 1);
        grid.add(button4, 1, 2);
        grid.add(button5, 2, 2);
        grid.add(button6, 3, 2);
        grid.add(button1, 1, 3);
        grid.add(button2, 2, 3);
        grid.add(button3, 3, 3);
        grid.add(button0, 2, 4);
        grid.add(plusButton, 4, 1);
        grid.add(minusButton, 4, 2);
        grid.add(multiButton, 4, 3);
        grid.add(divButton, 4, 4);
        grid.add(equalButton, 4, 0);
        grid.add(cButton, 0, 0);

        button1.setOnAction(e -> addNumberIntoScreen("1", screen));
        button2.setOnAction(e -> addNumberIntoScreen("2", screen));
        button3.setOnAction(e -> addNumberIntoScreen("3", screen));
        button4.setOnAction(e -> addNumberIntoScreen("4", screen));
        button5.setOnAction(e -> addNumberIntoScreen("5", screen));
        button6.setOnAction(e -> addNumberIntoScreen("6", screen));
        button7.setOnAction(e -> addNumberIntoScreen("7", screen));
        button8.setOnAction(e -> addNumberIntoScreen("8", screen));
        button9.setOnAction(e -> addNumberIntoScreen("9", screen));
        button0.setOnAction(e -> addNumberIntoScreen("0", screen));
        plusButton.setOnAction(e -> addStringIntoScreen(" + ", screen));
        minusButton.setOnAction(e -> addStringIntoScreen(" - ", screen));
        multiButton.setOnAction(e -> addStringIntoScreen(" * ", screen));
        divButton.setOnAction(e -> addStringIntoScreen(" / ", screen));
        cButton.setOnAction(e -> {
            screen.setText("");
            limit = false;
        });
        equalButton.setOnAction(e -> {
            screen.setText(calculator.calculate(screen.getText()));
            limit = false;
        });

        mainLayout.setTop(top);
        mainLayout.setCenter(grid);

        Scene scene = new Scene(mainLayout);

        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.show();
    }

    public Label addNumberIntoScreen(String s, Label label) {
        if (label.getText().equals("error")) {
            label.setText("");
        }
        label.setText(label.getText() + s);
        return label;
    }

    public Label addStringIntoScreen(String s, Label label) {
        if (label.getText().equals("error")) {
            label.setText("");
        }
        if (!label.getText().equals("") && !limit) {
            label.setText(label.getText() + s);
            limit = true;
        }
        return label;
    }

}
